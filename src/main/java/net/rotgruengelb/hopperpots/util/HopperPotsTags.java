package net.rotgruengelb.hopperpots.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class HopperPotsTags {

	public static class Blocks {

		public static final TagKey<Block> HOPPER_SPECIAL_BLOCKS = of("c", "hopper_special_blocks");

		private static TagKey<Block> of(String namespace, String id) {
			return TagKey.of(RegistryKeys.BLOCK, new Identifier(namespace, id));
		}
	}
}
