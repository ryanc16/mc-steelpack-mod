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
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ProgressionPlusModBlocks.BLOCKS_REGISTRY.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
