
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

public class SteelHoeItem extends HoeItem {
	public SteelHoeItem() {
		super(SteelpackModTiers.STEEL, -2, -0.5f, new Item.Properties());
	}
}
