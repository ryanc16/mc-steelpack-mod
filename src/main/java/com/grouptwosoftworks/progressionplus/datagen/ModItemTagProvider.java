package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModItems;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(
            PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
            CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(packOutput, future, completableFuture, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Add Item Tags

        for (var pair: tagToItemsMap) {
            var tagKey = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation(pair.getFirst()));
            for (var registryItem: pair.getSecond()) {
                this.tag(tagKey).add(registryItem.get());
            }
        }
    }

    @Override
    public String getName() {
        return "Item Tags";
    }

    private List<Pair<String, List<RegistryObject<? extends Item>>>> tagToItemsMap = List.of(
            Pair.of("minecraft:swords", List.copyOf(ProgressionPlusModItems.SWORDS)),
            Pair.of("minecraft:axes", List.copyOf(ProgressionPlusModItems.AXES)),
            Pair.of("minecraft:pickaxes", List.copyOf(ProgressionPlusModItems.PICKAXES)),
            Pair.of("minecraft:shovels", List.copyOf(ProgressionPlusModItems.SHOVELS)),
            Pair.of("minecraft:hoes", List.copyOf(ProgressionPlusModItems.HOES)),

            Pair.of("progressionplus:swords", List.copyOf(ProgressionPlusModItems.SWORDS)),
            Pair.of("progressionplus:axes", List.copyOf(ProgressionPlusModItems.AXES)),
            Pair.of("progressionplus:pickaxes", List.copyOf(ProgressionPlusModItems.PICKAXES)),
            Pair.of("progressionplus:shovels", List.copyOf(ProgressionPlusModItems.SHOVELS)),
            Pair.of("progressionplus:hoes", List.copyOf(ProgressionPlusModItems.HOES))
    );
}
