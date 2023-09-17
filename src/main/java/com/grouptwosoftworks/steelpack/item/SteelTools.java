package com.grouptwosoftworks.steelpack.item;

import net.minecraft.world.item.TieredItem;

import java.util.List;

public class SteelTools {

    public static final SteelToolItem.SteelAxeItem STEEL_AXE_ITEM = new SteelToolItem.SteelAxeItem();
    public static final SteelToolItem.SteelHoeItem STEEL_HOE_ITEM = new SteelToolItem.SteelHoeItem();
    public static final SteelToolItem.SteelPickaxeItem STEEL_PICKAXE_ITEM = new SteelToolItem.SteelPickaxeItem();
    public static final SteelToolItem.SteelShovelItem STEEL_SHOVEL_ITEM = new SteelToolItem.SteelShovelItem();

    public static final List<TieredItem> STEEL_TIER_TOOLS = List.of(
            STEEL_AXE_ITEM,
            STEEL_HOE_ITEM,
            STEEL_PICKAXE_ITEM,
            STEEL_SHOVEL_ITEM
    );
}
