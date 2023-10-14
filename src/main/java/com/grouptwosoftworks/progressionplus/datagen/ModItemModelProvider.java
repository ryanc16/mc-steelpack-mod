package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ModItemModelBaseProvider {
    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ProgressionPlusModItems.STEEL_INGOT);

        handheldItem(ProgressionPlusModItems.STEEL_SWORD);
        handheldItem(ProgressionPlusModItems.STEEL_PICKAXE);
        handheldItem(ProgressionPlusModItems.STEEL_AXE);
        handheldItem(ProgressionPlusModItems.STEEL_SHOVEL);
        handheldItem(ProgressionPlusModItems.STEEL_HOE);

        trimmedArmorItem(ProgressionPlusModItems.STEEL_ARMOR_HELMET);
        trimmedArmorItem(ProgressionPlusModItems.STEEL_ARMOR_CHESTPLATE);
        trimmedArmorItem(ProgressionPlusModItems.STEEL_ARMOR_LEGGINGS);
        trimmedArmorItem(ProgressionPlusModItems.STEEL_ARMOR_BOOTS);

        simpleItem(ProgressionPlusModItems.DIAMOND_FRAGMENT);
        simpleItem(ProgressionPlusModItems.DIAMOND_DUST);
        simpleItem(ProgressionPlusModItems.DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM);

        handheldItem(ProgressionPlusModItems.DIAMOND_TIPPED_PICKAXE);
        handheldItem(ProgressionPlusModItems.DIAMOND_TIPPED_AXE);
        handheldItem(ProgressionPlusModItems.DIAMOND_TIPPED_SHOVEL);
        handheldItem(ProgressionPlusModItems.DIAMOND_TIPPED_HOE);

    }

}
