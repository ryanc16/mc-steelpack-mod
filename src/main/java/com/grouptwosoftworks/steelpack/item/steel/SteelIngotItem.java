package com.grouptwosoftworks.steelpack.item.steel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

/**
 * The steel ingot definition
 */
public class SteelIngotItem extends Item implements SteelItem {
	public SteelIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
