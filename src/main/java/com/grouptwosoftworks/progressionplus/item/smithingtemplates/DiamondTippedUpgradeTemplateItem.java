package com.grouptwosoftworks.progressionplus.item.smithingtemplates;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
			Component.translatable("item.progressionplus.smithing_template.diamond_tipped_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
			Component.translatable("item.progressionplus.smithing_template.diamond_tipped_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
			Component.translatable("upgrade.progressionplus.diamond_tipped_upgrade").withStyle(ChatFormatting.GRAY),
			Component.translatable("item.progressionplus.smithing_template.diamond_tipped_upgrade.base_slot_description"),
			Component.translatable("item.progressionplus.smithing_template.diamond_tipped_upgrade.additions_slot_description"),
			Stream.of("item/empty_slot_axe", "item/empty_slot_hoe", "item/empty_slot_pickaxe", "item/empty_slot_shovel").map(ResourceLocation::new).collect(Collectors.toList()),
			List.of(new ResourceLocation("item/empty_slot_diamond"))
		);
	}
}
