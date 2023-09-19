package com.grouptwosoftworks.steelpack.item.steel.tools;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

/**
 * The SteelAxe item. It can be upgraded to a DiamondTippedAxe item.
 */
public class SteelAxeItem extends AxeItem implements SteelToolItem {
	private static final float ATTACK_DAMAGE_BASELINE = 5.5f;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -2.0f;
	private final SteelToolItemImpl impl;

	public SteelAxeItem() {
		super(SteelpackModTiers.STEEL, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
		impl = new SteelToolItemImpl();
	}
}
