package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.loot.SwapLogLootModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ProgressionPlusModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ProgressionPlusModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Constants.MODID);
    }

    @Override
    protected void start() {
        add("planks_from_axe_logs", new SwapLogLootModifier(
                new LootItemCondition[] {
                    // should be any log, and player was crouching, or some other thing like damage type
                    LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_LOG).build()
                }
        ));

    }
}
