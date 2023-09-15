
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.grouptwosoftworks.steelpack.init;

import com.grouptwosoftworks.steelpack.SteelpackMod;
import com.grouptwosoftworks.steelpack.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
	public static final RegistryObject<Item> STEEL_BLOCK = block(SteelpackModBlocks.STEEL_BLOCK);
	public static final RegistryObject<Item> DIAMOND_TIPPED_PICKAXE = REGISTRY.register("diamond_tipped_pickaxe", () -> new DiamondTippedPickaxeItem());
	public static final RegistryObject<Item> DIAMOND_TIPPED_AXE = REGISTRY.register("diamond_tipped_axe", () -> new DiamondTippedAxeItem());
	public static final RegistryObject<Item> DIAMOND_TIPPED_SWORD = REGISTRY.register("diamond_tipped_sword", () -> new DiamondTippedSwordItem());
	public static final RegistryObject<Item> DIAMOND_TIPPED_SHOVEL = REGISTRY.register("diamond_tipped_shovel", () -> new DiamondTippedShovelItem());
	public static final RegistryObject<Item> DIAMOND_TIPPED_HOE = REGISTRY.register("diamond_tipped_hoe", () -> new DiamondTippedHoeItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
