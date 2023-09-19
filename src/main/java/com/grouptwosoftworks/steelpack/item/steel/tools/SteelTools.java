package com.grouptwosoftworks.steelpack.item.steel.tools;

import net.minecraft.world.item.TieredItem;

import java.util.List;

/**
 * A barrel-like export of static instances of all SteelTools.
 */
public class SteelTools {

	public static final SteelToolItems.SteelAxe STEEL_AXE_ITEM = new SteelToolItems.SteelAxe();
	public static final SteelToolItems.SteelHoeItem STEEL_HOE_ITEM = new SteelToolItems.SteelHoeItem();
	public static final SteelToolItems.SteelPickaxeItem STEEL_PICKAXE_ITEM = new SteelToolItems.SteelPickaxeItem();
	public static final SteelToolItems.SteelShovelItem STEEL_SHOVEL_ITEM = new SteelToolItems.SteelShovelItem();

	public static final List<TieredItem> STEEL_TIER_TOOLS = List.of(
		STEEL_AXE_ITEM,
		STEEL_HOE_ITEM,
		STEEL_PICKAXE_ITEM,
		STEEL_SHOVEL_ITEM
	);
}
