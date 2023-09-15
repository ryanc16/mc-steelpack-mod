
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class DiamondTippedSwordItem extends SwordItem {
	public DiamondTippedSwordItem() {
		super(SteelpackModTiers.DIAMOND_TIPPED, 3, -2.4f, new Item.Properties());
	}
}
