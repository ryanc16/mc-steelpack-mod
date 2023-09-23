package com.grouptwosoftworks.progressionplus.tiers;

import net.minecraft.world.item.Tier;

/**
 * A barrel-like export of static instances of all Tiers.
 */
public final class ToolTiers {
	private ToolTiers() {}
	public static final Tier STEEL = new SteelToolTier();
	public static final Tier DIAMOND_TIPPED = new DiamondTippedToolTier();
}
