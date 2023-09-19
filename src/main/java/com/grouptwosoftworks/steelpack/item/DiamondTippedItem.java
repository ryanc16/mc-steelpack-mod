package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import com.grouptwosoftworks.steelpack.utils.ItemDowngradeUtils;
import com.grouptwosoftworks.steelpack.utils.ItemUpgradeUtils;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

import java.util.Optional;

public class DiamondTippedItem {
	public static final Logger LOGGER = LogUtils.getLogger();

	public static class DiamondTippedAxeItem extends AxeItem implements Downgradeable {
		private int damageOfItemUpgraded = 0;

		public DiamondTippedAxeItem() {
			super(SteelpackModTiers.DIAMOND_TIPPED, 5f, -3.0f, new Item.Properties());
		}

		@Override
		public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
			var smithingMenu = ((SmithingMenu) player.containerMenu);
			Optional<ItemStack> upgradedItem = ItemUpgradeUtils.getUpgradedItem(smithingMenu);
			upgradedItem.ifPresent(stack -> damageOfItemUpgraded = stack.getDamageValue());
		}

		@Override
		public ItemStack downgrade(ItemStack upgradedItemStack) {
			return ItemDowngradeUtils.downgradeItem(upgradedItemStack, damageOfItemUpgraded, SteelTools.STEEL_AXE_ITEM);
		}
	}

	public static class DiamondTippedHoeItem extends HoeItem implements Downgradeable {
		private int _steelDamage = 0;

		public DiamondTippedHoeItem() {
			super(SteelpackModTiers.DIAMOND_TIPPED, -3, 0.0f, new Item.Properties());
		}

		@Override
		public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
			var smithingMenu = ((SmithingMenu) player.containerMenu);
			Optional<ItemStack> upgradedItem = ItemUpgradeUtils.getUpgradedItem(smithingMenu);
			upgradedItem.ifPresent(stack -> _steelDamage = stack.getDamageValue());
		}

		@Override
		public ItemStack downgrade(ItemStack upgradedItemStack) {
			return ItemDowngradeUtils.downgradeItem(upgradedItemStack, _steelDamage, SteelTools.STEEL_HOE_ITEM);
		}
	}

	public static class DiamondTippedPickaxeItem extends PickaxeItem implements Downgradeable {
		private int _steelDamage = 0;

		public DiamondTippedPickaxeItem() {
			super(SteelpackModTiers.DIAMOND_TIPPED, 1, -2.8f, new Item.Properties());
		}

		@Override
		public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
			var smithingMenu = ((SmithingMenu) player.containerMenu);
			Optional<ItemStack> upgradedItem = ItemUpgradeUtils.getUpgradedItem(smithingMenu);
			upgradedItem.ifPresent(stack -> _steelDamage = stack.getDamageValue());
		}

		@Override
		public ItemStack downgrade(ItemStack upgradedItemStack) {
			return ItemDowngradeUtils.downgradeItem(upgradedItemStack, _steelDamage, SteelTools.STEEL_PICKAXE_ITEM);
		}
	}

	public static class DiamondTippedShovelItem extends ShovelItem implements Downgradeable {
		private int _steelDamage = 0;

		public DiamondTippedShovelItem() {
			super(SteelpackModTiers.DIAMOND_TIPPED, 1.5f, -3.0f, new Item.Properties());
		}

		@Override
		public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
			var smithingMenu = ((SmithingMenu) player.containerMenu);
			Optional<ItemStack> upgradedItem = ItemUpgradeUtils.getUpgradedItem(smithingMenu);
			upgradedItem.ifPresent(stack -> _steelDamage = stack.getDamageValue());
		}

		@Override
		public ItemStack downgrade(ItemStack upgradedItemStack) {
			return ItemDowngradeUtils.downgradeItem(upgradedItemStack, _steelDamage, SteelTools.STEEL_SHOVEL_ITEM);
		}
	}
}
