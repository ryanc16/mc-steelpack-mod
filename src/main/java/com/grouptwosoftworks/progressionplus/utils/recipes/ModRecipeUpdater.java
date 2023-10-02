package com.grouptwosoftworks.progressionplus.utils.recipes;

import com.grouptwosoftworks.progressionplus.utils.StringUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Utility used to modify and update existing recipes
 */
public class ModRecipeUpdater {

	public static Set<Recipe<?>> updateRecipes(MinecraftServer server, List<RecipeUpdater<? extends Recipe<?>>> recipeUpdaters) {
		final RecipeManager recipeManager = server.getRecipeManager();
		final var recipes = (Set<Recipe<?>>) recipeManager.getRecipes();
		final var context = server.getServerResources().managers().getConditionContext();
		final var registryAccess = server.registryAccess();

		Iterator<Recipe<?>> oldRecipesItr = recipes.iterator();
		Set<Recipe<?>> newRecipesSet = new HashSet<>();
		// Look through all recipes, create modified planks recipes
		while (oldRecipesItr.hasNext()) {
			final var oldRecipe = oldRecipesItr.next();
			// recipe result item stack
			final var resultItemStack = oldRecipe.getResultItem(registryAccess);
			var updaterMatch = recipeUpdaters.stream()
				.filter(ru -> ru.isMatch(oldRecipe, resultItemStack))
				.map(ru -> (RecipeUpdater<Recipe<?>>) ru)
				.findFirst();
			if (updaterMatch.isEmpty()) {
				continue;
			}

			var newRecipe = updaterMatch.get().createRecipe(oldRecipe, resultItemStack, context);
			oldRecipesItr.remove();
			newRecipesSet.add(newRecipe);
		}
		recipes.addAll(newRecipesSet);
		recipeManager.replaceRecipes(recipes);
		return recipes;
	}

	/**
	 * Defines an interface that can be used with the ModRecipeUpdater utility to make changes to a recipe.
	 *
	 * @param <R>
	 */
	public interface RecipeUpdater<R extends Recipe<?>> {

		boolean isMatch(Recipe<?> oldRecipe, ItemStack resultItemStack);

		Recipe<?> createRecipe(R oldRecipe, ItemStack resultItemStack, ICondition.IContext context);
	}

	public static class RecipeUpdaters {
		/**
		 * RecipeUpdater use to replace log-like recipes so that they also require an axe in order to obtain planks.
		 */
		public static final RecipeUpdater<ShapelessRecipe> LOGS_TO_PLANKS = new RecipeUpdater<>() {
			@Override
			public boolean isMatch(Recipe<?> oldRecipe, ItemStack resultItemStack) {
				if ((oldRecipe instanceof ShapelessRecipe && oldRecipe.getGroup().matches("planks")) == false) {
					return false;
				}
				// ex: turn "dark_oak_planks" into "dark_oak"
				final String materialName = StringUtils.splitAndTake(resultItemStack.getItem().toString(), "_", -1);
				Predicate<TagKey<?>> tagFilter = tag -> {
					var locationPath = tag.location().getPath();
					// input tag must match the planks material name & be a type of "wood"
					// most are "logs", nether wood are "stems", and newly added bamboo planks use "block"
					return locationPath.contains(materialName) && (
						locationPath.contains("logs") || locationPath.contains("stems") || locationPath.contains("block")
					);
				};
				// find the tag the represents the input logs possible for the planks
				// tags are used because multiple blocks of that tag can produce the same planks
				return oldRecipe.getIngredients()
					.stream()
					.flatMap(ing -> Arrays.stream(ing.getItems()))
					.flatMap(ItemStack::getTags)
					.anyMatch(tagFilter); // find first matching tag. if it exists and return true. if no match found return false.
			}

			@Override
			public ShapelessRecipe createRecipe(ShapelessRecipe oldRecipe, ItemStack resultItemStack, ICondition.IContext context) {
				var axesTag = new TagKey<>(Registries.ITEM, new ResourceLocation("minecraft", "axes"));
				oldRecipe.getIngredients().add(Ingredient.of(axesTag));
				ModShapelessRecipeDto newRecipe = new ModShapelessRecipeDto(oldRecipe);
				return newRecipe.build(context);
			}

		};
	}

}
