package com.grouptwosoftworks.steelpack.item.steel.tools;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

/**
 * The SteelShovel item. It can be upgraded to a DiamondTippedShovel item.
 */
public class SteelShovelItem extends ShovelItem implements SteelToolItem {
	private static final float ATTACK_DAMAGE_BASELINE = 1.5f;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -3.0f;
	private final SteelToolItemImpl impl;

	public SteelShovelItem() {
		super(SteelpackModTiers.STEEL, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
		impl = new SteelToolItemImpl();
	}
}
