package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ProgressionPlusModBlocks.STEEL_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
