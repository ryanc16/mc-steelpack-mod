package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

public class DiamondTippedItem {
    public static final Logger LOGGER = LogUtils.getLogger();

    public static class DiamondTippedAxeItem extends AxeItem implements ItemUpgradeUtils.IUpgradableItem, ItemDowngradeUtils.IDowngradableItem {
        private int _steelDamage = 0;

        public DiamondTippedAxeItem() {
            super(SteelpackModTiers.DIAMOND_TIPPED, 5f, -3.0f, new Item.Properties());
        }

        @Override
        public int getSubItemDamage() { return _steelDamage; }

        @Override
        public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
            _steelDamage = ItemUpgradeUtils.getDamageOfUpgradableIngredient(player);
        }

        @Override
        public void onItemWillDowngrade(Player player, ItemStack upgradedItemStack) {
            ItemDowngradeUtils.givePlayerDowngradedItem(player, upgradedItemStack, getSubItemDamage(), SteelTools.STEEL_AXE_ITEM);
        }
    }

    public static class DiamondTippedHoeItem extends HoeItem implements ItemUpgradeUtils.IUpgradableItem, ItemDowngradeUtils.IDowngradableItem {
        private int _steelDamage = 0;

        public DiamondTippedHoeItem() {
            super(SteelpackModTiers.DIAMOND_TIPPED, -3, 0.0f, new Item.Properties());
        }

        @Override
        public int getSubItemDamage() { return _steelDamage; }

        @Override
        public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
            _steelDamage = ItemUpgradeUtils.getDamageOfUpgradableIngredient(player);
        }

        @Override
        public void onItemWillDowngrade(Player player, ItemStack upgradedItemStack) {
            ItemDowngradeUtils.givePlayerDowngradedItem(player, upgradedItemStack, getSubItemDamage(), SteelTools.STEEL_HOE_ITEM);
        }
    }

    public static class DiamondTippedPickaxeItem extends PickaxeItem implements ItemUpgradeUtils.IUpgradableItem, ItemDowngradeUtils.IDowngradableItem {
        private int _steelDamage = 0;

        public DiamondTippedPickaxeItem() {
            super(SteelpackModTiers.DIAMOND_TIPPED, 1, -2.8f, new Item.Properties());
        }

        @Override
        public int getSubItemDamage() { return _steelDamage; }

        @Override
        public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
            _steelDamage = ItemUpgradeUtils.getDamageOfUpgradableIngredient(player);
        }

        @Override
        public void onItemWillDowngrade(Player player, ItemStack upgradedItemStack) {
            ItemDowngradeUtils.givePlayerDowngradedItem(player, upgradedItemStack, getSubItemDamage(), SteelTools.STEEL_PICKAXE_ITEM);
        }
    }

    public static class DiamondTippedShovelItem extends ShovelItem implements ItemUpgradeUtils.IUpgradableItem, ItemDowngradeUtils.IDowngradableItem {
        private int _steelDamage = 0;

        public DiamondTippedShovelItem() {
            super(SteelpackModTiers.DIAMOND_TIPPED, 1.5f, -3.0f, new Item.Properties());
        }

        @Override
        public int getSubItemDamage() { return _steelDamage; }

        @Override
        public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
            _steelDamage = ItemUpgradeUtils.getDamageOfUpgradableIngredient(player);
        }

        @Override
        public void onItemWillDowngrade(Player player, ItemStack upgradedItemStack) {
            ItemDowngradeUtils.givePlayerDowngradedItem(player, upgradedItemStack, getSubItemDamage(), SteelTools.STEEL_SHOVEL_ITEM);
        }
    }
}
