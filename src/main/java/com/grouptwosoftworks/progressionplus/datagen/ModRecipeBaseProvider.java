package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.Constants;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public abstract class ModRecipeBaseProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeBaseProvider(PackOutput pOutput) {
        super(pOutput);
    }


    protected static String getModItemSaveName(ItemLike item) {
        return Constants.MODID + ":" + getItemName(item);
    }

    protected static void pickaxeRecipe(Consumer<FinishedRecipe> writer, PickaxeItem pickaxe, ItemLike material) {
        _pickaxeRecipe(pickaxe, material).save(writer, getModItemSaveName(material) + "_pickaxe_recipe");
    }
    protected static void pickaxeRecipe(Consumer<FinishedRecipe> writer, PickaxeItem pickaxe, ItemLike material, String group) {
        _pickaxeRecipe(pickaxe, material).group(group).save(writer, getModItemSaveName(material) + "_pickaxe_recipe");
    }
    private static ShapedRecipeBuilder _pickaxeRecipe(PickaxeItem pickaxe, ItemLike material) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
            .pattern("###")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', material)
            .define('S', Tags.Items.RODS_WOODEN)
            .unlockedBy(getHasName(material), has(material));
    }

    protected static void axeRecipe(Consumer<FinishedRecipe> writer, AxeItem axe, ItemLike material) {
        _axeRecipe(axe, material).save(writer, getModItemSaveName(material) + "_axe_recipe");
    }
    protected static void axeRecipe(Consumer<FinishedRecipe> writer, AxeItem axe, ItemLike material, String group) {
        _axeRecipe(axe, material).group(group).save(writer, getModItemSaveName(material) + "_axe_recipe");
    }
    private static ShapedRecipeBuilder _axeRecipe(AxeItem axe, ItemLike material) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
            .pattern("## ")
            .pattern("#S ")
            .pattern(" S ")
            .define('#', material)
            .define('S', Tags.Items.RODS_WOODEN)
            .unlockedBy(getHasName(material), has(material));
    }

    protected static void shovelRecipe(Consumer<FinishedRecipe> writer, ShovelItem shovel, ItemLike material) {
        _shovelRecipe(shovel, material).save(writer, getModItemSaveName(material) + "_shovel_recipe");
    }
    protected static void shovelRecipe(Consumer<FinishedRecipe> writer, ShovelItem shovel, ItemLike material, String group) {
        _shovelRecipe(shovel, material).group(group).save(writer, getModItemSaveName(material) + "_shovel_recipe");
    }
    private static ShapedRecipeBuilder _shovelRecipe(ShovelItem shovel, ItemLike material) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
            .pattern("#")
            .pattern("S")
            .pattern("S")
            .define('#', material)
            .define('S', Tags.Items.RODS_WOODEN)
            .unlockedBy(getHasName(material), has(material));
    }

    protected static void hoeRecipe(Consumer<FinishedRecipe> writer, HoeItem hoe, ItemLike material) {
        _hoeRecipe(hoe, material).save(writer, getModItemSaveName(material) + "_hoe_recipe");
    }
    protected static void hoeRecipe(Consumer<FinishedRecipe> writer, HoeItem hoe, ItemLike material, String group) {
        _hoeRecipe(hoe, material).group(group).save(writer, getModItemSaveName(material) + "_hoe_recipe");
    }
    private static ShapedRecipeBuilder _hoeRecipe(HoeItem hoe, ItemLike material) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
            .pattern("## ")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', material)
            .define('S', Tags.Items.RODS_WOODEN)
            .unlockedBy(getHasName(material), has(material));
    }

    protected static void swordRecipe(Consumer<FinishedRecipe> writer, SwordItem sword, ItemLike material) {
        _swordRecipe(sword, material).save(writer, getModItemSaveName(material) + "_sword_recipe");
    }
    protected static void swordRecipe(Consumer<FinishedRecipe> writer, SwordItem sword, ItemLike material, String group) {
        _swordRecipe(sword, material).group(group).save(writer, getModItemSaveName(material) + "_sword_recipe");
    }
    private static ShapedRecipeBuilder _swordRecipe(SwordItem sword, ItemLike material) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
            .pattern("#")
            .pattern("#")
            .pattern("S")
            .define('#', material)
            .define('S', Tags.Items.RODS_WOODEN)
            .unlockedBy(getHasName(material), has(material));
    }


    protected static void helmetRecipe(Consumer<FinishedRecipe> writer, ArmorItem armor, ItemLike material) {
        _helmetRecipe(armor, material).save(writer, getModItemSaveName(material) + "_helmet_recipe");
    }
    protected static void helmetRecipe(Consumer<FinishedRecipe> writer, ArmorItem armor, ItemLike material, String group) {
        _helmetRecipe(armor, material).group(group).save(writer, getModItemSaveName(material) + "_helmet_recipe");
    }
    private static ShapedRecipeBuilder _helmetRecipe(ArmorItem armor, ItemLike material) {
        return _armorRecipe(armor, material)
            .pattern("###")
            .pattern("# #");
    }

    protected static void chestplateRecipe(Consumer<FinishedRecipe> writer, ArmorItem armor, ItemLike material) {
        _chestplateRecipe(armor, material).save(writer, getModItemSaveName(material) + "_chestplate_recipe");
    }
    protected static void chestplateRecipe(Consumer<FinishedRecipe> writer, ArmorItem armor, ItemLike material, String group) {
        _chestplateRecipe(armor, material).group(group).save(writer, getModItemSaveName(material) + "_chestplate_recipe");
    }
    private static ShapedRecipeBuilder _chestplateRecipe(ArmorItem armor, ItemLike material) {
        return _armorRecipe(armor, material)
            .pattern("# #")
            .pattern("###")
            .pattern("###");
    }

    protected static void leggingsRecipe(Consumer<FinishedRecipe> writer, ArmorItem armor, ItemLike material) {
        _leggingsRecipe(armor, material).save(writer, getModItemSaveName(material) + "_leggings_recipe");
    }
    protected static void leggingsRecipe(Consumer<FinishedRecipe> writer, ArmorItem armor, ItemLike material, String group) {
        _leggingsRecipe(armor, material).group(group).save(writer, getModItemSaveName(material) + "_leggings_recipe");
    }
    private static ShapedRecipeBuilder _leggingsRecipe(ArmorItem armor, ItemLike material) {
        return _armorRecipe(armor, material)
            .pattern("###")
            .pattern("# #")
            .pattern("# #");
    }

    protected static void bootsRecipe(Consumer<FinishedRecipe> writer, ArmorItem armor, ItemLike material) {
        _bootsRecipe(armor, material).save(writer, getModItemSaveName(material) + "_boots_recipe");
    }
    protected static void bootsRecipe(Consumer<FinishedRecipe> writer, ArmorItem armor, ItemLike material, String group) {
        _bootsRecipe(armor, material).group(group).save(writer, getModItemSaveName(material) + "_boots_recipe");
    }
    private static ShapedRecipeBuilder _bootsRecipe(ArmorItem armor, ItemLike material) {
        return _armorRecipe(armor, material)
            .pattern("# #")
            .pattern("# #");
    }

    private static ShapedRecipeBuilder _armorRecipe(ArmorItem armor, ItemLike material) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armor)
            .define('#', material)
            .unlockedBy(getHasName(material), has(material));
    }


    // NOTE: Needed until Forge fixes the problem with the namespaces ending up in "minecraft"

    // deviates slightly from parent
    protected static String getConversionRecipeName(ItemLike pResult, ItemLike pIngredient) {
        return getItemName(pResult) + "_from_" + getItemName(pIngredient) + "_recipe";
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int pResultCount) {
        SingleItemRecipeBuilder.stonecutting(
            Ingredient.of(pMaterial),
            pCategory,
            pResult,
            pResultCount
        )
        .unlockedBy(getHasName(pMaterial), has(pMaterial))
        .save(pFinishedRecipeConsumer, Constants.MODID + ":" + getConversionRecipeName(pResult, pMaterial) + "_stonecutting_recipe");
    }

    // deviates slightly from parent
    protected static void packedBlockStorageRecipes(
            Consumer<FinishedRecipe> writer,
            RecipeCategory unpackedCategory, ItemLike unpacked,
            RecipeCategory packedCategory, ItemLike packed,
            String unpackedGroup, String packedGroup
    ) {

        // unpacked item
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9)
            .group(unpackedGroup)
            .requires(packed)
            .unlockedBy(getHasName(unpacked), has(packed))
            .save(writer, Constants.MODID + ":" + getConversionRecipeName(unpacked, packed));

        // packed item (block)
        ShapedRecipeBuilder.shaped(packedCategory, packed)
            .group(packedGroup)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', unpacked)
            .unlockedBy(getHasName(packed), has(unpacked))
            .save(writer, Constants.MODID + ":" + getConversionRecipeName(packed, unpacked));
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> writer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTIme, String group) {
        oreCooking(writer, RecipeSerializer.SMELTING_RECIPE, ingredients, category, result, experience, cookingTIme, group, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> writer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(writer, RecipeSerializer.BLASTING_RECIPE, ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> writer, RecipeSerializer<? extends AbstractCookingRecipe> cookingSerializer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String recipeName) {
        for(ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(
                Ingredient.of(itemlike), category, result, experience, cookingTime, cookingSerializer
            )
            .group(group).unlockedBy(getHasName(itemlike), has(itemlike))
            .save(writer,  Constants.MODID + ":" + getItemName(result) + recipeName + "_" + getItemName(itemlike));
        }
    }
}
