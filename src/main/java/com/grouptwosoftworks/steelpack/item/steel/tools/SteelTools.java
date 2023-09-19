package com.grouptwosoftworks.steelpack.item.steel.tools;

import net.minecraft.world.item.TieredItem;

import java.util.List;

/**
 * A barrel-like export of static instances of all SteelTools.
 */
public class SteelTools {

	public static final SteelAxeItem STEEL_AXE_ITEM = new SteelAxeItem();
	public static final SteelHoeItem STEEL_HOE_ITEM = new SteelHoeItem();
	public static final SteelPickaxeItem STEEL_PICKAXE_ITEM = new SteelPickaxeItem();
	public static final SteelShovelItem STEEL_SHOVEL_ITEM = new SteelShovelItem();

	public static final List<TieredItem> STEEL_TIER_TOOLS = List.of(
		STEEL_AXE_ITEM,
		STEEL_HOE_ITEM,
		STEEL_PICKAXE_ITEM,
		STEEL_SHOVEL_ITEM
	);
}
