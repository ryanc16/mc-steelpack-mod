package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.datagen.loot.ProgressionPlusModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ProgressionPlusModLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ProgressionPlusModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
