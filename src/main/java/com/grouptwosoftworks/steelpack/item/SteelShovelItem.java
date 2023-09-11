
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class SteelShovelItem extends ShovelItem {
	public SteelShovelItem() {
		super(SteelpackModTiers.STEEL, 1.5f, -3.0f, new Item.Properties());
	}
}
