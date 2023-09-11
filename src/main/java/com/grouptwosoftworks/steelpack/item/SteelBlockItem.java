
package com.grouptwosoftworks.steelpack.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SteelBlockItem extends Item {
	public SteelBlockItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
