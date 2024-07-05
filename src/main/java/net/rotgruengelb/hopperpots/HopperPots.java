package net.rotgruengelb.hopperpots;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HopperPots implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("hopperpots");
	public static final GameRules.Key<GameRules.BooleanRule> GAMERULE_HOPPER_SPECIAL_BLOCKS = GameRuleRegistry.register("hopperSpecialBlocks", net.minecraft.world.GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
	public static final TagKey<Block> BLOCK_TAG_HOPPER_SPECIAL_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "hopper_special_blocks"));

	@Override
	public void onInitialize() {
		LOGGER.debug("HopperPots says hi!");
	}
}