package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;

public class SteelToolItem {

	public static class SteelAxe extends AxeItem implements Upgradeable {
		public SteelAxe() {
			super(SteelpackModTiers.STEEL, 5.5f, -2.0f, new Item.Properties());
		}
	}

	public static class SteelHoeItem extends HoeItem implements Upgradeable {
		public SteelHoeItem() {
			super(SteelpackModTiers.STEEL, -2, -0.5f, new Item.Properties());
		}
	}

	public static class SteelPickaxeItem extends PickaxeItem implements Upgradeable {
		public SteelPickaxeItem() {
			super(SteelpackModTiers.STEEL, 1, -2.8f, new Item.Properties());
		}
	}

	public static class SteelShovelItem extends ShovelItem implements Upgradeable {
		public SteelShovelItem() {
			super(SteelpackModTiers.STEEL, 1.5f, -3.0f, new Item.Properties());
		}
	}
}
