
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

public class DiamondTippedPickaxeItem extends PickaxeItem {
	public DiamondTippedPickaxeItem() {
		super(SteelpackModTiers.DIAMOND_TIPPED, 1, -2.8f, new Item.Properties());
	}
}
