package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModBlocks;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;


public class ModRecipeProvider extends ModRecipeBaseProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        // #region STEEL
        var STEEL_INGOT = ProgressionPlusModItems.STEEL_INGOT.get();
        var steelGroup = "steel";

        packedBlockStorageRecipes(writer,
            RecipeCategory.MISC, STEEL_INGOT,
            RecipeCategory.BUILDING_BLOCKS, ProgressionPlusModBlocks.STEEL_BLOCK.get(),
            steelGroup, steelGroup
        );

        oreBlasting(writer,
            List.of(Items.IRON_INGOT),
            RecipeCategory.MISC,
            STEEL_INGOT,
            1, 100, steelGroup
        );

        // #region STEEL TOOLS
        var STEEL_SWORD = ProgressionPlusModItems.STEEL_SWORD.get();
        var STEEL_PICKAXE = ProgressionPlusModItems.STEEL_PICKAXE.get();
        var STEEL_AXE = ProgressionPlusModItems.STEEL_AXE.get();
        var STEEL_SHOVEL = ProgressionPlusModItems.STEEL_SHOVEL.get();
        var STEEL_HOE = ProgressionPlusModItems.STEEL_HOE.get();

        swordRecipe(writer, STEEL_SWORD, STEEL_INGOT, steelGroup);
        pickaxeRecipe(writer, STEEL_PICKAXE, STEEL_INGOT, steelGroup);
        axeRecipe(writer, STEEL_AXE, STEEL_INGOT, steelGroup);
        shovelRecipe(writer, STEEL_SHOVEL, STEEL_INGOT, steelGroup);
        hoeRecipe(writer, STEEL_HOE, STEEL_INGOT, steelGroup);
        // #endregion STEEL TOOLS

        // #region STEEL ARMOR
        var STEEL_ARMOR_HELMET = ProgressionPlusModItems.STEEL_ARMOR_HELMET.get();
        var STEEL_ARMOR_CHESTPLATE = ProgressionPlusModItems.STEEL_ARMOR_CHESTPLATE.get();
        var STEEL_ARMOR_LEGGINGS = ProgressionPlusModItems.STEEL_ARMOR_LEGGINGS.get();
        var STEEL_ARMOR_BOOTS = ProgressionPlusModItems.STEEL_ARMOR_BOOTS.get();

        helmetRecipe(writer, STEEL_ARMOR_HELMET, STEEL_INGOT, steelGroup);
        chestplateRecipe(writer, STEEL_ARMOR_CHESTPLATE, STEEL_INGOT, steelGroup);
        leggingsRecipe(writer, STEEL_ARMOR_LEGGINGS, STEEL_INGOT, steelGroup);
        bootsRecipe(writer, STEEL_ARMOR_BOOTS, STEEL_INGOT, steelGroup);
        // #endregion STEEL ARMOR
        // #endregion STEEL

        // #region DIAMOND TIPPED
        var DIAMOND_FRAGMENT = ProgressionPlusModItems.DIAMOND_FRAGMENT.get();
        var DIAMOND_DUST = ProgressionPlusModItems.DIAMOND_DUST.get();

        var DIAMOND_TIPPED_PICKAXE = ProgressionPlusModItems.DIAMOND_TIPPED_PICKAXE.get();
        var DIAMOND_TIPPED_AXE = ProgressionPlusModItems.DIAMOND_TIPPED_AXE.get();
        var DIAMOND_TIPPED_SHOVEL = ProgressionPlusModItems.DIAMOND_TIPPED_SHOVEL.get();
        var DIAMOND_TIPPED_HOE = ProgressionPlusModItems.DIAMOND_TIPPED_HOE.get();

        stonecutterResultFromBase(writer, RecipeCategory.MISC, DIAMOND_FRAGMENT, Items.DIAMOND, 3);
        stonecutterResultFromBase(writer, RecipeCategory.MISC, DIAMOND_DUST, DIAMOND_FRAGMENT, 3);

        var DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM = ProgressionPlusModItems.DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM.get();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM, 2)
            .pattern("#S#")
            .pattern("#C#")
            .pattern("###")
            .define('S', DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM)
            .define('C', DIAMOND_FRAGMENT)
            .define('#', STEEL_INGOT)
            .showNotification(true)
            .unlockedBy(getHasName(DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM), has(DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM))
            .save(writer, getModItemSaveName(DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM) + "_copy_recipe");

        upgradeToDiamondTippedRecipe(writer, STEEL_PICKAXE, DIAMOND_TIPPED_PICKAXE);
        upgradeToDiamondTippedRecipe(writer, STEEL_AXE, DIAMOND_TIPPED_AXE);
        upgradeToDiamondTippedRecipe(writer, STEEL_SHOVEL, DIAMOND_TIPPED_SHOVEL);
        upgradeToDiamondTippedRecipe(writer, STEEL_HOE, DIAMOND_TIPPED_HOE);
        // #endregion DIAMOND TIPPED

        // Alternate Netherite Upgrade: DIAMOND_TIPPED => NETHERITE
        alternateUpgradeToNetheriteRecipe(writer, DIAMOND_TIPPED_PICKAXE, Items.NETHERITE_PICKAXE);
        alternateUpgradeToNetheriteRecipe(writer, DIAMOND_TIPPED_AXE, Items.NETHERITE_AXE);
        alternateUpgradeToNetheriteRecipe(writer, DIAMOND_TIPPED_SHOVEL, Items.NETHERITE_SHOVEL);
        alternateUpgradeToNetheriteRecipe(writer, DIAMOND_TIPPED_HOE, Items.NETHERITE_HOE);
    }


    private void upgradeToDiamondTippedRecipe(Consumer<FinishedRecipe> writer, Item itemToUpgrade, Item upgradeResult) {
        final Item upgradeMaterial = ProgressionPlusModItems.DIAMOND_FRAGMENT.get();
        SmithingTransformRecipeBuilder.smithing(
            Ingredient.of(ProgressionPlusModItems.DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM.get()),
            Ingredient.of(itemToUpgrade),
            Ingredient.of(upgradeMaterial),
            RecipeCategory.TOOLS,
            upgradeResult
        )
        .unlocks(getHasName(upgradeMaterial), has(upgradeMaterial))
        .save(writer,  getModItemSaveName(upgradeResult) + "_smithing_alt_recipe");
    }

    private void alternateUpgradeToNetheriteRecipe(Consumer<FinishedRecipe> writer, Item itemToUpgrade, Item upgradeResult) {
        final Item upgradeMaterial = Items.NETHERITE_INGOT;
        SmithingTransformRecipeBuilder.smithing(
            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
            Ingredient.of(itemToUpgrade),
            Ingredient.of(upgradeMaterial),
            RecipeCategory.TOOLS,
            upgradeResult
        )
        .unlocks(getHasName(upgradeMaterial), has(upgradeMaterial))
        .save(writer, getModItemSaveName(upgradeResult) + "_smithing_alt_recipe");
    }
}
