package com.grouptwosoftworks.progressionplus.item.steel.tools;

import com.grouptwosoftworks.progressionplus.tiers.ToolTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

/**
 * The SteelHoe item. It can be upgraded to a DiamondTippedHoe item.
 */
public class SteelHoeItem extends HoeItem implements SteelToolItem {
	private static final int ATTACK_DAMAGE_BASELINE = -2;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -0.5f;
	private final SteelToolItemImpl impl;

	public SteelHoeItem() {
		super(ToolTiers.STEEL, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
		impl = new SteelToolItemImpl();
	}
}