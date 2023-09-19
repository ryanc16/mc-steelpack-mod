package com.grouptwosoftworks.progressionplus.item.diamondtipped.tools;

import net.minecraft.world.item.TieredItem;

import java.util.List;

/**
 * A barrel-like export of static instances of all DiamondTippedTools
 */
public class DiamondTippedTools {

	public static final DiamondTippedAxeItem DIAMOND_TIPPED_AXE_ITEM = new DiamondTippedAxeItem();
	public static final DiamondTippedHoeItem DIAMOND_TIPPED_HOE_ITEM = new DiamondTippedHoeItem();
	public static final DiamondTippedPickaxeItem DIAMOND_TIPPED_PICKAXE_ITEM = new DiamondTippedPickaxeItem();
	public static final DiamondTippedShovelItem DIAMOND_TIPPED_SHOVEL_ITEM = new DiamondTippedShovelItem();

	public static final List<TieredItem> DIAMOND_TIPPED_TOOLS = List.of(
		DIAMOND_TIPPED_AXE_ITEM,
		DIAMOND_TIPPED_HOE_ITEM,
		DIAMOND_TIPPED_PICKAXE_ITEM,
		DIAMOND_TIPPED_SHOVEL_ITEM
	);
}
