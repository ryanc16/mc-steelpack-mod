package com.grouptwosoftworks.progressionplus.item.steel.armor;

import net.minecraft.world.item.ArmorItem;

import java.util.List;

public class SteelArmor {

	public static final SteelArmorItem.Helmet STEEL_ARMOR_HELMET_ITEM = new SteelArmorItem.Helmet();
	public static final SteelArmorItem.Chestplate STEEL_ARMOR_CHESTPLATE = new SteelArmorItem.Chestplate();
	public static final SteelArmorItem.Leggings STEEL_ARMOR_LEGGINGS_ITEM = new SteelArmorItem.Leggings();
	public static final SteelArmorItem.Boots STEEL_ARMOR_BOOTS_ITEM = new SteelArmorItem.Boots();

	public static final List<ArmorItem> STEEL_TIER_ARMOR = List.of(
		STEEL_ARMOR_HELMET_ITEM,
		STEEL_ARMOR_CHESTPLATE,
		STEEL_ARMOR_LEGGINGS_ITEM,
		STEEL_ARMOR_BOOTS_ITEM
	);
}
