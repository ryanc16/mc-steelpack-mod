package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(
            PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(packOutput, completableFuture, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ProgressionPlusModBlocks.STEEL_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ProgressionPlusModBlocks.STEEL_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
