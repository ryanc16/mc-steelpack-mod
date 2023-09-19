package com.grouptwosoftworks.progressionplus.item;

import net.minecraft.world.item.ItemStack;

/**
 * An interface to represent a downgradable item
 */
public interface Downgradeable {

	/**
	 * Determines if the criteria is met to downgrade the implementing item.
	 *
	 * @param selfItemStack The item stack wrapping this item
	 * @return true if the item's criteria is met to downgrade.
	 */
	boolean shouldDowngrade(ItemStack selfItemStack);

	/**
	 * Performs the downgrade process of the item to its lesser.
	 *
	 * @param selfItemStack The item stack wrapping this item.
	 * @return The new downgraded ItemStack.
	 */
	ItemStack downgrade(ItemStack selfItemStack);

}
