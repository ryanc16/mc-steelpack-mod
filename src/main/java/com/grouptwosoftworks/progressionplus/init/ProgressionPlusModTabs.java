package com.grouptwosoftworks.progressionplus.init;

import com.grouptwosoftworks.progressionplus.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * EventBusSubscriber for the CreativeModeTabContents event so custom items can be added to available items
 */
@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ProgressionPlusModTabs {
	public ProgressionPlusModTabs() {}

	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MODID);

	public static final Map<ResourceKey<CreativeModeTab>, Set<Consumer<BuildCreativeModeTabContentsEvent>>> tabTypeRegistry = Map.of(
		CreativeModeTabs.BUILDING_BLOCKS, Set.of(ProgressionPlusModTabs::acceptSteelBlocks),
		CreativeModeTabs.COMBAT, Set.of(ProgressionPlusModTabs::acceptSteelArmor, ProgressionPlusModTabs::acceptSteelWeapons),
		CreativeModeTabs.INGREDIENTS, Set.of(ProgressionPlusModTabs::acceptSteelIngredients, ProgressionPlusModTabs::acceptDiamondIngredients),
		CreativeModeTabs.TOOLS_AND_UTILITIES, Set.of(ProgressionPlusModTabs::acceptSteelTools, ProgressionPlusModTabs::acceptDiamondTippedTools)
	);

	public static final RegistryObject<CreativeModeTab> MOD_ITEMS_TAB = CREATIVE_TABS_REGISTRY.register("mod_items_tab", ProgressionPlusModTabs::creativeModeTabBuilder);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		tabTypeRegistry.getOrDefault(tabData.getTabKey(), Set.of()).forEach(action -> action.accept(tabData));
	}


	private static void acceptSteelIngredients(CreativeModeTab.Output tabData) {
		tabData.accept(ProgressionPlusModItems.STEEL_INGOT.get());
	}

	private static void acceptSteelBlocks(CreativeModeTab.Output tabData) {
		tabData.accept(ProgressionPlusModBlocks.STEEL_BLOCK.get().asItem());
	}

	private static void acceptSteelTools(CreativeModeTab.Output tabData) {
		tabData.accept(ProgressionPlusModItems.STEEL_AXE.get());
		tabData.accept(ProgressionPlusModItems.STEEL_PICKAXE.get());
		tabData.accept(ProgressionPlusModItems.STEEL_SHOVEL.get());
		tabData.accept(ProgressionPlusModItems.STEEL_HOE.get());
	}

	private static void acceptSteelWeapons(CreativeModeTab.Output tabData) {
		tabData.accept(ProgressionPlusModItems.STEEL_SWORD.get());
	}

	private static void acceptSteelArmor(CreativeModeTab.Output tabData) {
		tabData.accept(ProgressionPlusModItems.STEEL_ARMOR_HELMET.get());
		tabData.accept(ProgressionPlusModItems.STEEL_ARMOR_CHESTPLATE.get());
		tabData.accept(ProgressionPlusModItems.STEEL_ARMOR_LEGGINGS.get());
		tabData.accept(ProgressionPlusModItems.STEEL_ARMOR_BOOTS.get());
	}

	private static void acceptDiamondIngredients(CreativeModeTab.Output tabData) {
		tabData.accept(ProgressionPlusModItems.DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM.get());
		tabData.accept(ProgressionPlusModItems.DIAMOND_FRAGMENT.get());
		tabData.accept(ProgressionPlusModItems.DIAMOND_DUST.get());
	}

	private static void acceptDiamondTippedTools(CreativeModeTab.Output tabData) {
		tabData.accept(ProgressionPlusModItems.DIAMOND_TIPPED_PICKAXE.get());
		tabData.accept(ProgressionPlusModItems.DIAMOND_TIPPED_AXE.get());
		tabData.accept(ProgressionPlusModItems.DIAMOND_TIPPED_SHOVEL.get());
		tabData.accept(ProgressionPlusModItems.DIAMOND_TIPPED_HOE.get());
	}

	private static CreativeModeTab creativeModeTabBuilder() {
		return CreativeModeTab.builder()
			.icon(() -> new ItemStack(ProgressionPlusModItems.DIAMOND_TIPPED_UPGRADE_SMITHING_TEMPLATE_ITEM.get()))
			.title(Component.translatable("creativetab.mod_items_tab"))
			.displayItems((params, output) -> {
				// Steel Sub Mod
				acceptSteelIngredients(output);
				acceptSteelBlocks(output);
				acceptSteelTools(output);
				acceptSteelWeapons(output);
				acceptSteelArmor(output);

				// Diamond Tipped Sub Mod
				acceptDiamondIngredients(output);
				acceptDiamondTippedTools(output);
			}).build();
	}

}
