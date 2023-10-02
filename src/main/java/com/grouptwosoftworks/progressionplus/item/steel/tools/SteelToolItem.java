package com.grouptwosoftworks.progressionplus.item.steel.tools;

import com.grouptwosoftworks.progressionplus.item.UpgradeableTool;
import com.grouptwosoftworks.progressionplus.item.steel.SteelItem;
import com.grouptwosoftworks.progressionplus.tiers.ProgressionPlusTiers;
import net.minecraft.world.item.Tier;

/**
 * The common interface for SteelToolItems. SteelTools are upgradeable.
 */
public interface SteelToolItem extends SteelItem, UpgradeableTool {

	/**
	 * Get the next tool's tier.
	 *
	 * @return DiamondTipped tier.
	 */
	@Override
	default Tier getNextTier() {
		return ProgressionPlusTiers.DIAMOND_TIPPED_TIER;
	}
}
