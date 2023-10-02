package com.grouptwosoftworks.progressionplus.item;

import com.grouptwosoftworks.progressionplus.tiers.ProgressionPlusTiers;
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

		Tier previousTier = getPreviousTier();
		var previousToolName = ProgressionPlusTiers.TIER_NAME_KEYS.getOrDefault(previousTier, null);
		int previousTierMaxHealth = previousTier.getUses();
		int previousItemHealth = previousTier.getUses() - previousItemDamage;

		return String.format(
			"%s HP: %d/%d",
			previousToolName.getString(),
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
