package com.grouptwosoftworks.progressionplus.item.steel.weapons;

import net.minecraft.world.item.TieredItem;

import java.util.List;

/**
 * A barrel-like export of static instances of all SteelWeapons.
 */
public class SteelWeapons {
	public static final SteelWeaponItem.SteelSwordItem STEEL_SWORD_ITEM = new SteelWeaponItem.SteelSwordItem();

	public static final List<TieredItem> STEEL_TIER_WEAPONS = List.of(
		STEEL_SWORD_ITEM
	);
}
