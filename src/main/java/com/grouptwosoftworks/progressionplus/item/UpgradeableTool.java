package com.grouptwosoftworks.progressionplus.item;

import net.minecraft.world.item.Tier;

public interface UpgradeableTool extends Upgradeable {

	/**
	 * Get the upgraded tool's tier.
	 *
	 * @return The next tier.
	 */
	Tier getNextTier();
}
