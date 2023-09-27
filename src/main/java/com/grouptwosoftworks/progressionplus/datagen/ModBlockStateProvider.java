package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.Constants;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
