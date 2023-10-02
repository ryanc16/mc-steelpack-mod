package com.grouptwosoftworks.progressionplus.item.steel.tools;

import com.grouptwosoftworks.progressionplus.tiers.ProgressionPlusTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;


/**
 * The SteelAxe item. It can be upgraded to a DiamondTippedAxe item.
 */
public class SteelAxeItem extends AxeItem implements SteelToolItem {
	private static final float ATTACK_DAMAGE_BASELINE = 5.5f;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -2.0f;

	public SteelAxeItem() {
		super(ProgressionPlusTiers.STEEL_TIER, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
	}
}
