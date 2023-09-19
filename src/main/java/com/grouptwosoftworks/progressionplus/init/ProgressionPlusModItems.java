
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.grouptwosoftworks.progressionplus.init;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.item.diamondtipped.tools.DiamondTippedTools;
import com.grouptwosoftworks.progressionplus.item.smithingtemplates.DiamondTippedUpgradeTemplateItem;
import com.grouptwosoftworks.progressionplus.item.steel.armor.SteelArmor;
import com.grouptwosoftworks.progressionplus.item.steel.SteelIngotItem;
import com.grouptwosoftworks.progressionplus.item.steel.tools.SteelTools;
import com.grouptwosoftworks.progressionplus.item.steel.weapons.SteelWeapons;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registry and static access reference to registered items
 */
public class ProgressionPlusModItems {
	private ProgressionPlusModItems() {}

	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);
	public static final RegistryObject<Item> STEEL_INGOT = REGISTRY.register("steel_ingot", () -> new SteelIngotItem());
	public static final RegistryObject<Item> STEEL_ARMOR_HELMET = REGISTRY.register("steel_armor_helmet", () -> SteelArmor.STEEL_ARMOR_HELMET_ITEM);
	public static final RegistryObject<Item> STEEL_ARMOR_CHESTPLATE = REGISTRY.register("steel_armor_chestplate", () -> SteelArmor.STEEL_ARMOR_CHESTPLATE);
	public static final RegistryObject<Item> STEEL_ARMOR_LEGGINGS = REGISTRY.register("steel_armor_leggings", () -> SteelArmor.STEEL_ARMOR_LEGGINGS_ITEM);
	public static final RegistryObject<Item> STEEL_ARMOR_BOOTS = REGISTRY.register("steel_armor_boots", () -> SteelArmor.STEEL_ARMOR_BOOTS_ITEM);
	public static final RegistryObject<Item> STEEL_AXE = REGISTRY.register("steel_axe", () -> SteelTools.STEEL_AXE_ITEM);
	public static final RegistryObject<Item> STEEL_PICKAXE = REGISTRY.register("steel_pickaxe", () -> SteelTools.STEEL_PICKAXE_ITEM);
	public static final RegistryObject<Item> STEEL_SWORD = REGISTRY.register("steel_sword", () -> SteelWeapons.STEEL_SWORD_ITEM);
	public static final RegistryObject<Item> STEEL_SHOVEL = REGISTRY.register("steel_shovel", () -> SteelTools.STEEL_SHOVEL_ITEM);
	public static final RegistryObject<Item> STEEL_HOE = REGISTRY.register("steel_hoe", () -> SteelTools.STEEL_HOE_ITEM);
	public static final RegistryObject<Item> STEEL_BLOCK = block(ProgressionPlusModBlocks.STEEL_BLOCK);
	public static final RegistryObject<Item> DIAMOND_TIPPED_PICKAXE = REGISTRY.register("diamond_tipped_pickaxe", () -> DiamondTippedTools.DIAMOND_TIPPED_PICKAXE_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_AXE = REGISTRY.register("diamond_tipped_axe", () -> DiamondTippedTools.DIAMOND_TIPPED_AXE_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_SHOVEL = REGISTRY.register("diamond_tipped_shovel", () -> DiamondTippedTools.DIAMOND_TIPPED_SHOVEL_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_HOE = REGISTRY.register("diamond_tipped_hoe", () -> DiamondTippedTools.DIAMOND_TIPPED_HOE_ITEM);
	public static final RegistryObject<Item> DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM = REGISTRY.register("diamond_tipped_upgrade_smithing_template", () -> new DiamondTippedUpgradeTemplateItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
