package com.grouptwosoftworks.progressionplus.datagen;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.loot.SwapLogLootModifier;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Constants.MODID);
    }

    @Override
    protected void start() {
        add("planks_from_logs", new SwapLogLootModifier(
                buildPlanksFromLogsPredicate()
        ));

    }

    private LootItemCondition[] buildPlanksFromLogsPredicate() {
        return new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(
                        LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().flags(
                                EntityFlagsPredicate.Builder.flags()
                                        .setCrouching(true)
                                        .setSprinting(false)
                                        .setSwimming(false)
                                        .build()
                        ).build()
                ).build(),

                LootItemEntityPropertyCondition.hasProperties(
                        LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().equipment(
                                EntityEquipmentPredicate.Builder.equipment().mainhand(
                                        ItemPredicate.Builder.item().of(
                                                ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("minecraft:axes"))
                                        ).build()
                                ).build()
                        ).build()
                ).build(),
        };
    }
}
