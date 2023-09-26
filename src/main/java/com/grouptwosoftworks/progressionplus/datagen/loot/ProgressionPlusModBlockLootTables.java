package com.grouptwosoftworks.progressionplus.datagen.loot;

import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ProgressionPlusModBlockLootTables extends BlockLootSubProvider {

    public ProgressionPlusModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ProgressionPlusModBlocks.BLOCKS_REGISTRY.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
