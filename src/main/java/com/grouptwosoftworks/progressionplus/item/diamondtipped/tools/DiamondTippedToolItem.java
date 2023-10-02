package com.grouptwosoftworks.progressionplus.item.diamondtipped.tools;

import com.grouptwosoftworks.progressionplus.item.DowngradeableTool;
import com.grouptwosoftworks.progressionplus.item.ToolItemTags;
import com.grouptwosoftworks.progressionplus.item.diamondtipped.DiamondTippedItem;
import com.grouptwosoftworks.progressionplus.item.steel.tools.SteelToolItem;
import com.grouptwosoftworks.progressionplus.tiers.ProgressionPlusTiers;
import com.grouptwosoftworks.progressionplus.utils.ItemUpgradeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import java.util.List;

/**
 * Common interface for all DiamondTippedToolItems. DiamondTippedTools are downgradeable.
 */
public interface DiamondTippedToolItem extends DiamondTippedItem, DowngradeableTool {

	/**
	 * This is the common onCraftedBy implementation between all DiamondTippedToolItems.
	 *
	 * @param player The player that crafted the item.
	 * @param pickedUpItemStack The ItemStack that was picked up when it was crafted.
	 */
	default void onCraftedBy(ItemStack pickedUpItemStack, Player player) {
		ItemUpgradeUtils.getUpgradedIngredientItem(player.containerMenu)
			.ifPresent(inputIngredientStack -> {
				pickedUpItemStack.getOrCreateTag().putInt(ToolItemTags.PREVIOUS_TOOL_DAMAGE, inputIngredientStack.getDamageValue());
				pickedUpItemStack.setDamageValue(0); // reset the item's number of uses
			});
	}

	/**
	 * This is the common shouldDowngrade implementation between all DiamondTippedItem tools.
	 *
	 * @param selfItemStack The ItemStack in question to determined if it meets the criteria to downgrade.
	 * @return true if the itemstack meets the criteria to be downgraded.
	 */
	default boolean shouldDowngrade(ItemStack selfItemStack) {
		var damage = selfItemStack.getDamageValue(); // damage to item
		var maxDamage = selfItemStack.getMaxDamage(); // max damage to item allowed

		// If item is about to break
		return damage >= maxDamage - 1;
	}

	/**
	 * This is the common downgrade implementation between all DiamondTippedItem tools.
	 *
	 * @param upgradedItemStack The current upgraded item to downgrade.
	 * @param downgradeTo The item type to downgrade to.
	 * @return The downgraded item stack.
	 */
	default ItemStack downgrade(ItemStack upgradedItemStack, SteelToolItem downgradeTo) {
		final int stackSizeOfOne = 1;
		var downgradeItemStack = new ItemStack(downgradeTo, stackSizeOfOne);
		var copiedTags = upgradedItemStack.getOrCreateTag().copy();
		downgradeItemStack.setTag(copiedTags);
		downgradeItemStack.getItem().setDamage(downgradeItemStack, getPreviousItemDamage(upgradedItemStack));
		return downgradeItemStack;
	}

	/**
	 * Retrieve the damage value of the item prior to it being upgraded.
	 * Hopefully the item hasn't been upgraded more than once!
	 *
	 * @param selfItemStack The current item stack of the upgraded item.
	 * @return The damage value of the item before it was upgraded.
	 */
	default int getPreviousItemDamage(ItemStack selfItemStack) {
		return selfItemStack.getOrCreateTag().getInt(ToolItemTags.PREVIOUS_TOOL_DAMAGE);
	}

	/**
	 * Get the previous tier, which is Steel.
	 *
	 * @return SteelToolTier
	 */
	@Override
	default Tier getPreviousTier() {
		return ProgressionPlusTiers.STEEL_TIER;
	}

	/**
	 * Add to the tooltip the previous tool and its health of its max health.
	 *
	 * @param itemStack The item stack to get the previous tools damage.
	 * @param toolTipComponentList Existing tooltip component, which can add more display items.
	 */
	default void appendPreviousDamageHoverText(ItemStack itemStack, List<Component> toolTipComponentList) {
		var hasPreviousToolDamage = itemStack.getOrCreateTag().contains(ToolItemTags.PREVIOUS_TOOL_DAMAGE);
		if (hasPreviousToolDamage) {
			String formattedTooltip = getPreviousToolTooltipText(itemStack);
			toolTipComponentList.add(Component.literal(formattedTooltip).withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC));
		}
	}
}
