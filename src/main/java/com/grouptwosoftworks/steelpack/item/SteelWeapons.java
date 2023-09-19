package com.grouptwosoftworks.steelpack.item;

import net.minecraft.world.item.TieredItem;

import java.util.List;

public class SteelWeapons {

	public static final SteelWeaponItem.SteelSwordItem STEEL_SWORD_ITEM = new SteelWeaponItem.SteelSwordItem();

	public static final List<TieredItem> STEEL_TIER_WEAPONS = List.of(
		STEEL_SWORD_ITEM
	);
}
