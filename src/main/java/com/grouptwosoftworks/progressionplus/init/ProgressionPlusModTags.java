package com.grouptwosoftworks.progressionplus.init;

import com.grouptwosoftworks.progressionplus.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ProgressionPlusModTags {
    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Constants.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {

        public static final TagKey<Block> NEEDS_STEEL_TOOL = tag("needs_steel_tool");

        public static final TagKey<Block> NEEDS_DIAMOND_TOOL = BlockTags.NEEDS_DIAMOND_TOOL;

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Constants.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
