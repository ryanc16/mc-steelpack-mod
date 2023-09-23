package com.grouptwosoftworks.progressionplus.item.steel.tools;

import com.grouptwosoftworks.progressionplus.tiers.ToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;

/**
 * The SteelPickaxe item. It can be upgraded to a DiamondTippedPickaxe item.
 */
public class SteelPickaxeItem extends PickaxeItem implements SteelToolItem {
	private static final int ATTACK_DAMAGE_BASELINE = 1;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -2.8f;

	public SteelPickaxeItem() {
		super(ToolTiers.STEEL, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
	}
}