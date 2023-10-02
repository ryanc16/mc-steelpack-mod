package com.grouptwosoftworks.progressionplus.utils.recipes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;

import java.util.List;

public class ModShapelessRecipeDto {
	public final String type;
	public final String id;
	public final String category;
	public final String group;

	public final List<JsonElement> ingredients;

	public final RecipeResult result;

	public ModShapelessRecipeDto(ResourceLocation id, String group, CraftingBookCategory category, ItemStack resultItemStack, NonNullList<Ingredient> ingredients) {
		this(new ShapelessRecipe(id, group, category, resultItemStack, ingredients));
	}

	public ModShapelessRecipeDto(ShapelessRecipe shapelessRecipe) {
		type = shapelessRecipe.getType().toString();
		id = shapelessRecipe.getId().toString();
		group = shapelessRecipe.getGroup();
		category = shapelessRecipe.category().getSerializedName();
		ingredients = shapelessRecipe.getIngredients().stream().map(Ingredient::toJson).toList();
		result = new RecipeResult(shapelessRecipe.getResultItem(null));
	}

	public ShapelessRecipe build(ICondition.IContext context) {
		// construct a new recipe from Json
		// TODO: find a better way to construct a new or copied Recipe
		var jsonObject = new Gson().toJsonTree(this).getAsJsonObject();
		return ShapelessRecipe.Serializer.SHAPELESS_RECIPE.fromJson(new ResourceLocation(id), jsonObject, context);
	}

	public static class RecipeResult {
		public final String item;
		public final int count;

		public RecipeResult(ItemStack item) {
			this.item = getFullItemId(item);
			count = item.getCount();
		}
	}

	private static String getFullItemId(ItemStack itemStack) {
		return itemStack.getItem().getCreatorModId(itemStack) + ":" + itemStack.getItem();
	}

	private static String getFullTagName(TagKey<?> tag) {
		return tag.location().getNamespace() + ":" + tag.location().getPath();
	}


}
