package com.grouptwosoftworks.progressionplus.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class SwapLogLootModifier extends LootModifier {

    public static final Supplier<Codec<SwapLogLootModifier>> CODEC = Suppliers.memoize(
        () -> RecordCodecBuilder.create(instance -> codecStart(instance)
                .apply(instance, SwapLogLootModifier::new))
    );


    public SwapLogLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

        var lootTableId = context.getQueriedLootTableId();
        if (lootTableId.getPath().matches("blocks/\\w+_log") == false) {
            return generatedLoot;
        }

        for (LootItemCondition condition: this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        var recipeManager = context.getLevel().getRecipeManager();
        var allCrafting = recipeManager.getAllRecipesFor(RecipeType.CRAFTING);
        var logRecipes = allCrafting.stream().filter(rec -> rec.getGroup().matches("planks")).toList();

        for (int i = 0; i < generatedLoot.size(); i++) {
            var itemStack = generatedLoot.get(i);
            if (itemStack.is(ItemTags.LOGS) == false) continue;

            var match = logRecipes.stream().filter(rec ->
                rec.getIngredients().stream().anyMatch(ingredient -> ingredient.test(itemStack))
            ).findFirst();

            if (match.isPresent()) {
                generatedLoot.set(i, match.get().getResultItem(context.getLevel().registryAccess()));
            }
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
