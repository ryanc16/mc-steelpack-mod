package com.grouptwosoftworks.steelpack.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class DiamondTippedUpgradeTemplateItem extends SmithingTemplateItem {
	public DiamondTippedUpgradeTemplateItem() {
		/**
		 * @param appliesTo
		 * @param ingredients
		 * @param upgradeDescription
		 * @param baseSlotDescription
		 * @param additionsSlotDescription
		 * @param baseSlotEmptyIcons
		 * @param additionalSlotEmptyIcons
		 */
		super(
			Component.translatable("item.steelpack.smithing_template.diamond_tipped_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
			Component.translatable("item.steelpack.smithing_template.diamond_tipped_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
			Component.translatable("upgrade.steelpack.diamond_tipped_upgrade").withStyle(ChatFormatting.GRAY),
			Component.translatable("item.steelpack.smithing_template.diamond_tipped_upgrade.base_slot_description"),
			Component.translatable("item.steelpack.smithing_template.diamond_tipped_upgrade.additions_slot_description"),
			List.of(new ResourceLocation("item/empty_slot_axe"), new ResourceLocation("item/empty_slot_hoe"), new ResourceLocation("item/empty_slot_pickaxe"), new ResourceLocation("item/empty_slot_shovel")),
			List.of(new ResourceLocation("item/empty_slot_diamond"))
		);
	}
}
