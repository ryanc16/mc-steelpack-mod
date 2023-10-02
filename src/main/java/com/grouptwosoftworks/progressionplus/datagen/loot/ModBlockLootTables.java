package com.grouptwosoftworks.progressionplus.datagen.loot;

import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ProgressionPlusModBlocks.STEEL_BLOCK.get());

        // adds an ore block that drops with silk touch, or item that drops without
//        this.add(
//                ProgressionPlusModBlocks.STEEL_BLOCK.get(),
//                block -> createOreDrop(
//                        ProgressionPlusModBlocks.STEEL_BLOCK.get(), // silk touch
//                        ProgressionPlusModItems.STEEL_INGOT.get() // no silk touch
//                )
//        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ProgressionPlusModBlocks.BLOCKS_REGISTRY.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
