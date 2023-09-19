package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;

/**
 * SteelToolItem classes
 */
public class SteelToolItems {

	/**
	 * The SteelAxe item. It can be upgraded to a DiamondTippedAxe item.
	 */
	public static class SteelAxe extends AxeItem implements SteelToolItem {
		public SteelAxe() {
			super(SteelpackModTiers.STEEL, 5.5f, -2.0f, new Item.Properties());
		}
	}

	/**
	 * The SteelHoe item. It can be upgraded to a DiamondTippedHoe item.
	 */
	public static class SteelHoeItem extends HoeItem implements SteelToolItem {
		public SteelHoeItem() {
			super(SteelpackModTiers.STEEL, -2, -0.5f, new Item.Properties());
		}
	}

	/**
	 * The SteelPickaxe item. It can be upgraded to a DiamondTippedPickaxe item.
	 */
	public static class SteelPickaxeItem extends PickaxeItem implements SteelToolItem {
		public SteelPickaxeItem() {
			super(SteelpackModTiers.STEEL, 1, -2.8f, new Item.Properties());
		}
	}

	/**
	 * The SteelShovel item. It can be upgraded to a DiamondTippedShovel item.
	 */
	public static class SteelShovelItem extends ShovelItem implements SteelToolItem {
		public SteelShovelItem() {
			super(SteelpackModTiers.STEEL, 1.5f, -3.0f, new Item.Properties());
		}
	}
}
