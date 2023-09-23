package com.grouptwosoftworks.progressionplus.tiers;

import net.minecraft.world.item.Tier;

public interface NamedTier extends Tier {

	/**
	 * Get the name of the tier
	 * @return String name of the tier
	 */
	String getName();
}
