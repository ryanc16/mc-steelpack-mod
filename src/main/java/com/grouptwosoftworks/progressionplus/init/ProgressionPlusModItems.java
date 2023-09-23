
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.grouptwosoftworks.progressionplus.init;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.item.diamond.DiamondDustItem;
import com.grouptwosoftworks.progressionplus.item.diamond.DiamondFragmentItem;
import com.grouptwosoftworks.progressionplus.item.diamondtipped.tools.DiamondTippedTools;
import com.grouptwosoftworks.progressionplus.item.smithingtemplates.DiamondTippedUpgradeTemplateItem;
import com.grouptwosoftworks.progressionplus.item.steel.armor.SteelArmor;
import com.grouptwosoftworks.progressionplus.item.steel.SteelIngotItem;
import com.grouptwosoftworks.progressionplus.item.steel.tools.SteelTools;
import com.grouptwosoftworks.progressionplus.item.steel.weapons.SteelWeapons;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registry and static access reference to registered items
 */
public class ProgressionPlusModItems {
	private ProgressionPlusModItems() {}
	public static final DeferredRegister<Item> ITEMS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);


	public static final RegistryObject<Item> STEEL_INGOT = ITEMS_REGISTRY.register("steel_ingot", () -> new SteelIngotItem());
	public static final RegistryObject<Item> STEEL_ARMOR_HELMET = ITEMS_REGISTRY.register("steel_armor_helmet", () -> SteelArmor.STEEL_ARMOR_HELMET_ITEM);
	public static final RegistryObject<Item> STEEL_ARMOR_CHESTPLATE = ITEMS_REGISTRY.register("steel_armor_chestplate", () -> SteelArmor.STEEL_ARMOR_CHESTPLATE);
	public static final RegistryObject<Item> STEEL_ARMOR_LEGGINGS = ITEMS_REGISTRY.register("steel_armor_leggings", () -> SteelArmor.STEEL_ARMOR_LEGGINGS_ITEM);
	public static final RegistryObject<Item> STEEL_ARMOR_BOOTS = ITEMS_REGISTRY.register("steel_armor_boots", () -> SteelArmor.STEEL_ARMOR_BOOTS_ITEM);
	public static final RegistryObject<Item> STEEL_AXE = ITEMS_REGISTRY.register("steel_axe", () -> SteelTools.STEEL_AXE_ITEM);
	public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS_REGISTRY.register("steel_pickaxe", () -> SteelTools.STEEL_PICKAXE_ITEM);
	public static final RegistryObject<Item> STEEL_SWORD = ITEMS_REGISTRY.register("steel_sword", () -> SteelWeapons.STEEL_SWORD_ITEM);
	public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS_REGISTRY.register("steel_shovel", () -> SteelTools.STEEL_SHOVEL_ITEM);
	public static final RegistryObject<Item> STEEL_HOE = ITEMS_REGISTRY.register("steel_hoe", () -> SteelTools.STEEL_HOE_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_PICKAXE = ITEMS_REGISTRY.register("diamond_tipped_pickaxe", () -> DiamondTippedTools.DIAMOND_TIPPED_PICKAXE_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_AXE = ITEMS_REGISTRY.register("diamond_tipped_axe", () -> DiamondTippedTools.DIAMOND_TIPPED_AXE_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_SHOVEL = ITEMS_REGISTRY.register("diamond_tipped_shovel", () -> DiamondTippedTools.DIAMOND_TIPPED_SHOVEL_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_HOE = ITEMS_REGISTRY.register("diamond_tipped_hoe", () -> DiamondTippedTools.DIAMOND_TIPPED_HOE_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM = ITEMS_REGISTRY.register("diamond_tipped_upgrade_smithing_template", () -> new DiamondTippedUpgradeTemplateItem());
	public static final RegistryObject<Item> DIAMOND_FRAGMENT = ITEMS_REGISTRY.register("diamond_fragment", () -> new DiamondFragmentItem());
	public static final RegistryObject<Item> DIAMOND_DUST = ITEMS_REGISTRY.register("diamond_dust", () -> new DiamondDustItem());

}
