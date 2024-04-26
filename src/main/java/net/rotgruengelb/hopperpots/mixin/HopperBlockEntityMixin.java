package net.rotgruengelb.hopperpots.mixin;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.rotgruengelb.hopperpots.HopperPots.BLOCK_TAG_HOPPER_SPECIAL_BLOCKS;
import static net.rotgruengelb.hopperpots.HopperPots.GAMERULE_HOPPER_SPECIAL_BLOCKS;

@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin implements BlockEntityProvider {

	@Inject(method = "insert", at = @At("HEAD"), cancellable = true)
	private static void insert(World world, BlockPos pos, BlockState state, Inventory inventory, CallbackInfoReturnable<Boolean> cir) {
		if (world.getGameRules().getBoolean(GAMERULE_HOPPER_SPECIAL_BLOCKS)) {
			if (specialInsert(world, pos, inventory)) {
				cir.setReturnValue(true);
			}
		}
	}

	@Unique
	private static boolean specialInsert(World world, BlockPos pos, Inventory inventory) {
		Inventory insert_inventory = getSpecialOutputInventory(world, pos);
		if (insert_inventory == null) {
			return false;
		}
		Direction direction = Direction.DOWN.getOpposite();
		if (HopperBlockEntity.isInventoryFull(insert_inventory, direction)) {
			return false;
		}
		for (int i = 0; i < inventory.size(); ++i) {
			if (inventory.getStack(i).isEmpty()) continue;
			ItemStack itemStack = inventory.getStack(i).copy();
			ItemStack insert_itemStack = HopperBlockEntity.transfer(inventory, insert_inventory, inventory.removeStack(i, 1), direction);
			if (insert_itemStack.isEmpty()) {
				insert_inventory.markDirty();
				return true;
			}
			inventory.setStack(i, itemStack);
		}
		return false;
	}

	@Unique
	@Nullable
	private static Inventory getSpecialOutputInventory(World world, BlockPos pos) {
		Direction direction = Direction.DOWN;
		if (world.getBlockState(pos.offset(direction)).isIn(BLOCK_TAG_HOPPER_SPECIAL_BLOCKS)) {
			return HopperBlockEntity.getInventoryAt(world, pos.offset(direction));
		}
		return null;
	}
}