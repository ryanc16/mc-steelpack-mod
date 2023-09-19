package com.grouptwosoftworks.progressionplus.utils;

import com.grouptwosoftworks.progressionplus.item.Upgradeable;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;

import java.util.Optional;

public class ItemUpgradeUtils {
	private ItemUpgradeUtils() {}

	/**
	 * This will attempt to locate the item that was being upgraded from the ingredients input slots.
	 *
	 * @param containerMenu The open visual of the upgrading menu, which contains the input, output, and inventory slots
	 * @return An Optional containing the Upgradeable item if it was found
	 */
	public static Optional<ItemStack> getUpgradedIngredientItem(AbstractContainerMenu containerMenu) {
		if (containerMenu instanceof ItemCombinerMenu combinerMenu) {
			var resultSlotIndex = combinerMenu.getResultSlot();
			// find the output slot index, and look through the container's slots
			// starting at the beginning, until the output slot is reached. Those
			// should all be ingredient slots,
			for (int i = 0; i < resultSlotIndex; i++) {
				var inputItemStack = containerMenu.getSlot(i).getItem();
				if (inputItemStack.getItem() instanceof Upgradeable upgradeableItem && upgradeableItem instanceof TieredItem) {
					return Optional.of(inputItemStack);
				}
			}
		}
		return Optional.empty();
	}
}
