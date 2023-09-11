
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class SteelPickaxeItem extends PickaxeItem {
	public SteelPickaxeItem() {
		super(SteelpackModTiers.STEEL, 1, -2.8f, new Item.Properties());
	}
}
