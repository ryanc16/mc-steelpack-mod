package com.grouptwosoftworks.progressionplus.init;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.*;

public class RecipeCache {
    private RecipeCache(){}
    private static List<CraftingRecipe> PLANKS_CRAFTING_RECIPES_LAST_CALCULATED = List.of();
    private static Map<String, ItemStack> LOGS_TO_PLANKS_MAP = new HashMap<String, ItemStack>();

    public static List<CraftingRecipe> getLastCalculatedPlanksCraftingRecipes() {
        return new ArrayList<CraftingRecipe>(PLANKS_CRAFTING_RECIPES_LAST_CALCULATED);
    }

    public static Optional<ItemStack> getPlanksOfLog(ItemStack itemStack) {
        var match = RecipeCache.LOGS_TO_PLANKS_MAP.get(itemStack.getItem().toString());
        return Optional.of(match);
    }

    public static void calculatePlanksCraftingRecipes(RecipeManager recipeManager, RegistryAccess registryAccess) {
        var allCrafting = recipeManager.getAllRecipesFor(RecipeType.CRAFTING);
        PLANKS_CRAFTING_RECIPES_LAST_CALCULATED = allCrafting.stream().filter(rec -> rec.getGroup().matches("planks")).toList();

        LOGS_TO_PLANKS_MAP.clear();
        for(var recipe: PLANKS_CRAFTING_RECIPES_LAST_CALCULATED) {
            ItemStack planks = recipe.getResultItem(registryAccess);

            var logsOfWoodType = recipe.getIngredients().get(0).getItems();
            for (var logOfType: logsOfWoodType) {
                LOGS_TO_PLANKS_MAP.put(logOfType.getItem().toString(), planks);
            }
        }
    }
}
