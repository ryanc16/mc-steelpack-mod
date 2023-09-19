package com.grouptwosoftworks.steelpack.utils;

import com.grouptwosoftworks.steelpack.item.Upgradeable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;

public class ItemDowngradeUtils {
	private ItemDowngradeUtils() {
	}

	public static <UpgradeableTieredItem extends TieredItem & Upgradeable> ItemStack downgradeItem(ItemStack upgradedItemStack, int subItemDamage, UpgradeableTieredItem downgradeItemDef) {
		final int itemCount = 1;
		var downgradeItemStack = new ItemStack(downgradeItemDef, itemCount);
		var copiedTags = upgradedItemStack.getOrCreateTag().copy();
		downgradeItemStack.setTag(copiedTags);
		downgradeItemStack.getItem().setDamage(downgradeItemStack, subItemDamage);
		return downgradeItemStack;
	}
}
