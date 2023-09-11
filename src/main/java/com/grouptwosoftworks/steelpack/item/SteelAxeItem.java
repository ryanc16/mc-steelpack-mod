
package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class SteelAxeItem extends AxeItem {
	public SteelAxeItem() {
		super(SteelpackModTiers.STEEL, 5.5f, -2.0f, new Item.Properties());
	}
}
