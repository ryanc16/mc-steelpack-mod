package com.grouptwosoftworks.steelpack.item;

import net.minecraft.world.item.ItemStack;

public interface Downgradeable {

	ItemStack downgrade(ItemStack upgradedItemStack);
}
