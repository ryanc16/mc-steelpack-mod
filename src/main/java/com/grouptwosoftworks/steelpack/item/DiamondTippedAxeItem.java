
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class DiamondTippedAxeItem extends AxeItem {
	public DiamondTippedAxeItem() {
		super(SteelpackModTiers.DIAMOND_TIPPED, 5f, -3.0f, new Item.Properties());
	}
}
