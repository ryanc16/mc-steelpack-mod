package com.grouptwosoftworks.progressionplus.utils;

public class ModShapelessRecipeDto {
    public String type = "minecraft:crafting_shapeless";
    public String category;
    public String group;

    public Ingredient[] ingredients;

    public Result result;

    public ModShapelessRecipeDto(String category, String group, Ingredient[] ingredients, String result, int resultCount) {
        this.category = category;
        this.group = group;
        this.ingredients = ingredients;
        this.result = new Result(result, resultCount);
    }

    public static class Ingredient {
        public static Ingredient withTag(String tag) {
            var ingredient = new Ingredient();
            ingredient.tag = tag;
            return ingredient;
        }

        public static Ingredient withItem(String item) {
            var ingredient = new Ingredient();
            ingredient.item = item;
            return ingredient;
        }

        public String item;
        public String tag;
    }

    public class Result {
        public Result(String item, int count) {
            this.item = item;
            this.count = count;
        }
        public int count;
        public String item;
    }
}
