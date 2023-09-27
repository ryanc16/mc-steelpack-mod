package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModBlocks;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ProgressionPlusModBlocks.STEEL_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ProgressionPlusModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ProgressionPlusModItems.STEEL_INGOT.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ProgressionPlusModItems.STEEL_INGOT.get(), 9)
                .requires(ProgressionPlusModBlocks.STEEL_BLOCK.get())
                .unlockedBy("has_steel_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ProgressionPlusModBlocks.STEEL_BLOCK.get()).build()))
                .save(pWriter);
    }
}
