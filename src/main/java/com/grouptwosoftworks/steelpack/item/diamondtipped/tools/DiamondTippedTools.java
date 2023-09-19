package com.grouptwosoftworks.steelpack.item.diamondtipped.tools;

import net.minecraft.world.item.TieredItem;

import java.util.List;

/**
 * A barrel-like export of static instances of all DiamondTippedTools
 */
public class DiamondTippedTools {

	public static final DiamondTippedToolItems.DiamondTippedAxeItem DIAMOND_TIPPED_AXE_ITEM = new DiamondTippedToolItems.DiamondTippedAxeItem();
	public static final DiamondTippedToolItems.DiamondTippedHoeItem DIAMOND_TIPPED_HOE_ITEM = new DiamondTippedToolItems.DiamondTippedHoeItem();
	public static final DiamondTippedToolItems.DiamondTippedPickaxeItem DIAMOND_TIPPED_PICKAXE_ITEM = new DiamondTippedToolItems.DiamondTippedPickaxeItem();
	public static final DiamondTippedToolItems.DiamondTippedShovelItem DIAMOND_TIPPED_SHOVEL_ITEM = new DiamondTippedToolItems.DiamondTippedShovelItem();

	public static final List<TieredItem> DIAMOND_TIPPED_TOOLS = List.of(
		DIAMOND_TIPPED_AXE_ITEM,
		DIAMOND_TIPPED_HOE_ITEM,
		DIAMOND_TIPPED_PICKAXE_ITEM,
		DIAMOND_TIPPED_SHOVEL_ITEM
	);
}
