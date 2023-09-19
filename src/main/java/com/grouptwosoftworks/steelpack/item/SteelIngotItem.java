package com.grouptwosoftworks.steelpack.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SteelIngotItem extends Item {
	public SteelIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
