package com.grouptwosoftworks.progressionplus.item;

import com.grouptwosoftworks.progressionplus.tiers.NamedTier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public interface DowngradeableTool extends Downgradeable {

	/**
	 * Generate the tooltip text for the previous downgraded version of the tool.
	 * @param itemStack The current tool's item stack.
	 * @return A formatted string to use for tooltip text.
	 */
	default String getPreviousToolTooltipText(ItemStack itemStack) {
		int previousItemDamage = itemStack.getOrCreateTag().getInt(ToolItemTags.PREVIOUS_TOOL_DAMAGE);
		NamedTier previousTier = (NamedTier) getPreviousTier();
		String previousToolName = previousTier.getName();
		int previousTierMaxHealth = previousTier.getUses();
		int previousItemHealth = previousTier.getUses() - previousItemDamage;

		return String.format(
			"%s HP: %d/%d",
			previousToolName,
			previousItemHealth,
			previousTierMaxHealth
		);
	}

	/**
	 * Get the previous downgraded tool tier
	 * @return The tools previous tier
	 */
	Tier getPreviousTier();
}
