package com.grouptwosoftworks.steelpack.utils;

import com.grouptwosoftworks.steelpack.item.Upgradeable;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;

import java.util.Optional;

public class ItemUpgradeUtils {
	private ItemUpgradeUtils() {
	}

	public static Optional<ItemStack> getUpgradedItem(SmithingMenu smithingMenu) {
		var resultSlotIndex = smithingMenu.getResultSlot();
		for (int i = 0; i < resultSlotIndex; i++) {
			var inputItemStack = smithingMenu.getSlot(i).getItem();
			if (inputItemStack.getItem() instanceof Upgradeable upgradeableItem && upgradeableItem instanceof TieredItem) {
				return Optional.of(inputItemStack);
			}
		}
		return Optional.empty();
	}
}
