package com.grouptwosoftworks.steelpack.item;

import net.minecraft.world.item.TieredItem;

import java.util.List;

public class DiamondTippedTools {

	public static final DiamondTippedItem.DiamondTippedAxeItem DIAMOND_TIPPED_AXE_ITEM = new DiamondTippedItem.DiamondTippedAxeItem();
	public static final DiamondTippedItem.DiamondTippedHoeItem DIAMOND_TIPPED_HOE_ITEM = new DiamondTippedItem.DiamondTippedHoeItem();
	public static final DiamondTippedItem.DiamondTippedPickaxeItem DIAMOND_TIPPED_PICKAXE_ITEM = new DiamondTippedItem.DiamondTippedPickaxeItem();
	public static final DiamondTippedItem.DiamondTippedShovelItem DIAMOND_TIPPED_SHOVEL_ITEM = new DiamondTippedItem.DiamondTippedShovelItem();

	public static final List<TieredItem> DIAMOND_TIPPED_TOOLS = List.of(
		DIAMOND_TIPPED_AXE_ITEM,
		DIAMOND_TIPPED_HOE_ITEM,
		DIAMOND_TIPPED_PICKAXE_ITEM,
		DIAMOND_TIPPED_SHOVEL_ITEM
	);
}
