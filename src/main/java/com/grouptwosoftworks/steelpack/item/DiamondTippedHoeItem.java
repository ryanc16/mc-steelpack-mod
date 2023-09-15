
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

public class DiamondTippedHoeItem extends HoeItem {
	public DiamondTippedHoeItem() {
		super(SteelpackModTiers.DIAMOND_TIPPED, -3, 0.0f, new Item.Properties());
	}
}
