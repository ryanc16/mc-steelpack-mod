
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.grouptwosoftworks.steelpack.init;

import com.grouptwosoftworks.steelpack.SteelpackMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SteelpackModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SteelpackMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(SteelpackModBlocks.STEEL_BLOCK.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(SteelpackModItems.STEEL_ARMOR_HELMET.get());
			tabData.accept(SteelpackModItems.STEEL_ARMOR_CHESTPLATE.get());
			tabData.accept(SteelpackModItems.STEEL_ARMOR_LEGGINGS.get());
			tabData.accept(SteelpackModItems.STEEL_ARMOR_BOOTS.get());
			tabData.accept(SteelpackModItems.STEEL_SWORD.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(SteelpackModItems.STEEL_INGOT.get());
			tabData.accept(SteelpackModItems.DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(SteelpackModItems.STEEL_AXE.get());
			tabData.accept(SteelpackModItems.STEEL_PICKAXE.get());
			tabData.accept(SteelpackModItems.STEEL_SHOVEL.get());
			tabData.accept(SteelpackModItems.STEEL_HOE.get());
			tabData.accept(SteelpackModItems.DIAMOND_TIPPED_PICKAXE.get());
			tabData.accept(SteelpackModItems.DIAMOND_TIPPED_AXE.get());
			tabData.accept(SteelpackModItems.DIAMOND_TIPPED_SHOVEL.get());
			tabData.accept(SteelpackModItems.DIAMOND_TIPPED_HOE.get());
		}
	}
}
