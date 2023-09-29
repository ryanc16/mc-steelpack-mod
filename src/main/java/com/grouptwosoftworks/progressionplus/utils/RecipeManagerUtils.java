package com.grouptwosoftworks.progressionplus.utils;

import com.google.gson.Gson;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.crafting.conditions.ICondition;

public class RecipeManagerUtils {


    public static Recipe<?>[] modifyLogsToPlanksRecipes(LevelAccessor level, ICondition.IContext context, Recipe<?>[] oldRecipes) {
        Recipe<?>[] newRecipes = new Recipe<?>[oldRecipes.length];

        for (int i = 0; i < oldRecipes.length; i++) {
            var oldRecipe = oldRecipes[i];
            if (oldRecipe.getGroup().matches("planks") == false) {
                newRecipes[i] = oldRecipe;
                continue;
            }

            var result = oldRecipe.getResultItem(level.registryAccess());
            var materialName = StringUtils.splitAndTake(result.getItem().toString(), "_", -1);

            TagKey<Item> logTag = null;
            ItemStack logItem = null;

            // find the tag the represents the input logs possible for the planks
            // tags are used because multiple blocks of that tag can produce the same planks
            for (var ing: oldRecipe.getIngredients()) {
                for (var item: ing.getItems()) {
                    var tags = item.getTags();
                    var _logTag = tags.filter(tag -> {
                        var locationPath = tag.location().getPath();
                        // input tag must match the planks material name & be a type of "wood"
                        // most are "logs", nether wood are "stems", and newly added bamboo planks use "block"
                        return locationPath.contains(materialName) && (
                                locationPath.contains("logs") || locationPath.contains("stems") || locationPath.contains("block")
                        );
                    }).findFirst();

                    if (_logTag.isPresent()) {
                        logTag = _logTag.get();
                        break;
                    }
                }
                if (logTag != null) break;
            }

            // could not find any matching tag, use the first item instead
            // should never happen with vanilla blocks
            if (logTag == null) {
                logItem = oldRecipe.getIngredients().get(0).getItems()[0];
            }

            var ingredients = new ModShapelessRecipeDto.Ingredient[] {
                (logTag != null)
                    ? ModShapelessRecipeDto.Ingredient.withTag(getFullTagName(logTag))
                    : ModShapelessRecipeDto.Ingredient.withItem(getFullItemId(logItem)),

                ModShapelessRecipeDto.Ingredient.withTag("minecraft:axes")
            };

            ModShapelessRecipeDto mapped = new ModShapelessRecipeDto(
                    "building",
                    oldRecipe.getGroup(),
                    ingredients,
                    getFullItemId(result),
                    result.getCount()
            );

            var jsonObject = new Gson().toJsonTree(mapped).getAsJsonObject();
            newRecipes[i] = RecipeManager.fromJson(oldRecipe.getId(), jsonObject, context);
        }

////			var newRecipe = ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, oldRecipeResult.getItem(), oldRecipeResult.getCount())
////			.requires(oldRecipe.getIngredients().get(0))
////			.requires(ItemTags.AXES)
////			.group(oldRecipe.getGroup());

        return newRecipes;
    }

    private static String getFullTagName(TagKey tag) {
        return tag.location().getNamespace() + ":" + tag.location().getPath();
    };

    private static String getFullItemId(ItemStack itemStack) {
        return itemStack.getItem().getCreatorModId(itemStack) + ":" + itemStack.getItem().toString();
    }

}
