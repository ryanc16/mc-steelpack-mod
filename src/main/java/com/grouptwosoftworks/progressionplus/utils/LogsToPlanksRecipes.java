package com.grouptwosoftworks.progressionplus.utils;

import com.google.gson.Gson;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.crafting.conditions.ICondition;

public class LogsToPlanksRecipes {

    public static Recipe<?>[] getNewRecipes(LevelAccessor level, ICondition.IContext context, Recipe<?>[] oldRecipes) {
        Recipe<?>[] newRecipes = new Recipe<?>[oldRecipes.length];

        // Look through all recipes, create modified planks recipes
        for (int i = 0; i < oldRecipes.length; i++) {
            var oldRecipe = oldRecipes[i];

            // if it isn't a planks recipe, keep it, we need to maintain all of them
            if (oldRecipe.getGroup().matches("planks") == false) {
                newRecipes[i] = oldRecipe;
                continue;
            }

            // resulting planks item as ItemStack
            var planksItemStack = oldRecipe.getResultItem(level.registryAccess());
            // ex: turn "dark_oak_planks" into "dark_oak"
            var materialName = StringUtils.splitAndTake(planksItemStack.getItem().toString(), "_", -1);

            TagKey<Item> logTag = null;
            ItemStack logItemStack = oldRecipe.getIngredients().get(0).getItems()[0];

            // find the tag the represents the input logs possible for the planks
            // tags are used because multiple blocks of that tag can produce the same planks
            for (var ing: oldRecipe.getIngredients()) {
                for (var item: ing.getItems()) {
                    var _logTag = item.getTags().filter(tag -> {
                        var locationPath = tag.location().getPath();
                        // input tag must match the planks material name & be a type of "wood"
                        // most are "logs", nether wood are "stems", and newly added bamboo planks use "block"
                        return locationPath.contains(materialName) && (
                                locationPath.contains("logs") || locationPath.contains("stems") || locationPath.contains("block")
                        );
                    }).findFirst(); // find first matching tag

                    // desired log-like tag found, skip remaining tags
                    if (_logTag.isPresent()) {
                        logTag = _logTag.get();
                        break;
                    }
                }
                // found an instance of a log-like tag, it should be duplicated across any ingredient
                if (logTag != null) break;
            }

            var ingredients = new ModShapelessRecipeDto.Ingredient[] {
                (logTag != null)
                    ? ModShapelessRecipeDto.Ingredient.withTag(getFullTagName(logTag))
                    // could not find any matching tag, use the first item instead
                    // should never happen with vanilla blocks
                    : ModShapelessRecipeDto.Ingredient.withItem(getFullItemId(logItemStack)),

                ModShapelessRecipeDto.Ingredient.withTag("minecraft:axes")
            };

            // Map it to a serializable class
            ModShapelessRecipeDto mapped = new ModShapelessRecipeDto(
                "building",
                oldRecipe.getGroup(),
                ingredients,
                getFullItemId(planksItemStack),
                planksItemStack.getCount()
            );

            // construct a new recipe from Json
            // TODO: find a better way to construct a new or copied Recipe
            var jsonObject = new Gson().toJsonTree(mapped).getAsJsonObject();
            newRecipes[i] = RecipeManager.fromJson(oldRecipe.getId(), jsonObject, context);
        }

        // var newRecipe = ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, oldRecipeResult.getItem(), oldRecipeResult.getCount())
        //    .requires(oldRecipe.getIngredients().get(0))
        //    .requires(ItemTags.AXES)
        //    .group(oldRecipe.getGroup());

        return newRecipes;
    }

    private static String getFullTagName(TagKey tag) {
        return tag.location().getNamespace() + ":" + tag.location().getPath();
    };

    private static String getFullItemId(ItemStack itemStack) {
        return itemStack.getItem().getCreatorModId(itemStack) + ":" + itemStack.getItem().toString();
    }

}
