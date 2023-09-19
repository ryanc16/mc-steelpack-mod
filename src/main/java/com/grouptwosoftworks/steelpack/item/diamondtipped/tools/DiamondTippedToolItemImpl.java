package com.grouptwosoftworks.steelpack.item.diamondtipped.tools;

import com.grouptwosoftworks.steelpack.item.steel.tools.SteelToolItem;
import com.grouptwosoftworks.steelpack.utils.ItemUpgradeUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * Includes package protected implementation for all DiamondTippedTools.
 */
class DiamondTippedToolItemImpl {
	private final static int STACK_SIZE_OF_ONE = 1;
	private static final String PREVIOUS_TOOL_DAMAGE = "steelpack:previous_tool_damage";
	protected DiamondTippedToolItemImpl() {}

	/**
	 * This is the common onCraftedBy implementation between all DiamondTippedToolItems.
	 *
	 * @param player The player that crafted the item.
	 * @param pickedUpItemStack The ItemStack that was picked up when it was crafted.
	 */
	protected void onCraftedBy(Player player, ItemStack pickedUpItemStack) {
		ItemUpgradeUtils.getUpgradedIngredientItem(player.containerMenu)
			.ifPresent(inputIngredientStack -> {
				pickedUpItemStack.getOrCreateTag().putInt(PREVIOUS_TOOL_DAMAGE, inputIngredientStack.getDamageValue());
				pickedUpItemStack.setDamageValue(0); // reset the item's number of uses
			});
	};

	/**
	 * This is the common shouldDowngrade implementation between all DiamondTippedItem tools.
	 *
	 * @param selfItemStack The ItemStack in question to determined if it meets the criteria to downgrade.
	 * @return true if the itemstack meets the criteria to be downgraded.
	 */
	protected boolean shouldDowngrade(ItemStack selfItemStack) {
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
	protected ItemStack downgrade(ItemStack upgradedItemStack, SteelToolItem downgradeTo) {
		var downgradeItemStack = new ItemStack(downgradeTo, STACK_SIZE_OF_ONE);
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
	private int getPreviousItemDamage(ItemStack selfItemStack) {
		return selfItemStack.getOrCreateTag().getInt(PREVIOUS_TOOL_DAMAGE);
	}
}
