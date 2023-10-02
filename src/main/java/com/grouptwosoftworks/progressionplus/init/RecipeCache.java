package com.grouptwosoftworks.progressionplus.init;

import net.minecraft.core.RegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RecipeCache {
    private RecipeCache() {}

    private static final Map<RecipeGrouping<?, ?>, List<Recipe<? extends Container>>> CRAFTING_RECIPES_LAST_CALCULATED = new HashMap<>();
    private static final Map<String, ItemStack> INGREDIENT_TO_RESULT_MAP = new HashMap<>();
    private static RecipeManager recipeManager;

    public static <C extends Container, T extends Recipe<C>, R extends RecipeType<T>> List<T> getLastCalculatedRecipes(R type, String group) {
        var grouping = new RecipeGrouping<>(type, group);
        return (List<T>) List.copyOf(CRAFTING_RECIPES_LAST_CALCULATED.get(grouping));
    }

    public static List<CraftingRecipe> getLastCalculatedCraftingRecipe(String group) {
        var grouping = new RecipeGrouping<>(RecipeType.CRAFTING, group);
        return CRAFTING_RECIPES_LAST_CALCULATED.get(grouping).stream().map(r -> (CraftingRecipe) r).toList();
    }

    public static Optional<ItemStack> getResultForIngredient(ItemStack ingredient) {
        if (RecipeCache.INGREDIENT_TO_RESULT_MAP.containsKey(ingredient.getItem().toString())) {
            ItemStack result = RecipeCache.INGREDIENT_TO_RESULT_MAP.get(ingredient.getItem().toString());
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }

    public static void initialize(MinecraftServer server) {
        RecipeCache.recipeManager = server.getRecipeManager();
        List<RecipeGrouping<?, ?>> recipeOutputGroupsToCache = List.of(new RecipeGrouping<>(RecipeType.CRAFTING, "planks"));
        INGREDIENT_TO_RESULT_MAP.clear();
        for (RecipeGrouping<?, ?> grouping : recipeOutputGroupsToCache) {
            initializeRecipesForGroup(grouping, server.registryAccess());
        }
    }

    private static void initializeRecipesForGroup(RecipeGrouping<?, ?> grouping, RegistryAccess registryAccess) {
        var cachedResult = cacheRecipeForGroup(grouping);
        INGREDIENT_TO_RESULT_MAP.remove(grouping.group);
        for (var recipe : cachedResult) {
            ItemStack resultItem = recipe.getResultItem(registryAccess);

            var inputIngredient = recipe.getIngredients().get(0).getItems();
            for (var ing : inputIngredient) {
                INGREDIENT_TO_RESULT_MAP.put(ing.getItem().toString(), resultItem);
            }
        }
    }

    private static List<Recipe<? extends Container>> cacheRecipeForGroup(RecipeGrouping<?, ?> grouping) {
        var recipesByType = RecipeCache.recipeManager.getAllRecipesFor(grouping.type);
        var resultRecipes = recipesByType.stream().filter(rec -> rec.getGroup().matches(grouping.group)).toList();
        CRAFTING_RECIPES_LAST_CALCULATED.put(grouping, (List<Recipe<? extends Container>>) resultRecipes);
        return (List<Recipe<? extends Container>>) resultRecipes;
    }

    private record RecipeGrouping<C extends Container, T extends Recipe<C>>(RecipeType<T> type, String group) {}
}
