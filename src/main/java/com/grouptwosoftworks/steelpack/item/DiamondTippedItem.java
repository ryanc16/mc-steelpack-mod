package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;

public class DiamondTippedItem {

    public static class DiamondTippedAxeItem extends AxeItem {
        public DiamondTippedAxeItem() {
            super(SteelpackModTiers.DIAMOND_TIPPED, 5f, -3.0f, new Item.Properties());
        }
    }

    public static class DiamondTippedHoeItem extends HoeItem {
        public DiamondTippedHoeItem() {
            super(SteelpackModTiers.DIAMOND_TIPPED, -3, 0.0f, new Item.Properties());
        }
    }

    public static class DiamondTippedPickaxeItem extends PickaxeItem {
        public DiamondTippedPickaxeItem() {
            super(SteelpackModTiers.DIAMOND_TIPPED, 1, -2.8f, new Item.Properties());
        }
    }

    public static class DiamondTippedShovelItem extends ShovelItem {
        public DiamondTippedShovelItem() {
            super(SteelpackModTiers.DIAMOND_TIPPED, 1.5f, -3.0f, new Item.Properties());
        }
    }
}
