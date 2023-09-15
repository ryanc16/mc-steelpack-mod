
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class DiamondTippedShovelItem extends ShovelItem {
	public DiamondTippedShovelItem() {
		super(SteelpackModTiers.DIAMOND_TIPPED, 1.5f, -3.0f, new Item.Properties());
	}
}
