
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.grouptwosoftworks.steelpack.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import com.grouptwosoftworks.steelpack.item.SteelSwordItem;
import com.grouptwosoftworks.steelpack.item.SteelShovelItem;
import com.grouptwosoftworks.steelpack.item.SteelPickaxeItem;
import com.grouptwosoftworks.steelpack.item.SteelIngotItem;
import com.grouptwosoftworks.steelpack.item.SteelHoeItem;
import com.grouptwosoftworks.steelpack.item.SteelBlockItem;
import com.grouptwosoftworks.steelpack.item.SteelAxeItem;
import com.grouptwosoftworks.steelpack.item.SteelArmorItem;
import com.grouptwosoftworks.steelpack.SteelpackMod;

public class SteelpackModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SteelpackMod.MODID);
	public static final RegistryObject<Item> STEEL_INGOT = REGISTRY.register("steel_ingot", () -> new SteelIngotItem());
	public static final RegistryObject<Item> STEEL_ARMOR_HELMET = REGISTRY.register("steel_armor_helmet", () -> new SteelArmorItem.Helmet());
	public static final RegistryObject<Item> STEEL_ARMOR_CHESTPLATE = REGISTRY.register("steel_armor_chestplate", () -> new SteelArmorItem.Chestplate());
	public static final RegistryObject<Item> STEEL_ARMOR_LEGGINGS = REGISTRY.register("steel_armor_leggings", () -> new SteelArmorItem.Leggings());
	public static final RegistryObject<Item> STEEL_ARMOR_BOOTS = REGISTRY.register("steel_armor_boots", () -> new SteelArmorItem.Boots());
	public static final RegistryObject<Item> STEEL_AXE = REGISTRY.register("steel_axe", () -> new SteelAxeItem());
	public static final RegistryObject<Item> STEEL_PICKAXE = REGISTRY.register("steel_pickaxe", () -> new SteelPickaxeItem());
	public static final RegistryObject<Item> STEEL_SWORD = REGISTRY.register("steel_sword", () -> new SteelSwordItem());
	public static final RegistryObject<Item> STEEL_SHOVEL = REGISTRY.register("steel_shovel", () -> new SteelShovelItem());
	public static final RegistryObject<Item> STEEL_HOE = REGISTRY.register("steel_hoe", () -> new SteelHoeItem());
	public static final RegistryObject<Item> STEEL_BLOCK = REGISTRY.register("steel_block", () -> new SteelBlockItem());
}
