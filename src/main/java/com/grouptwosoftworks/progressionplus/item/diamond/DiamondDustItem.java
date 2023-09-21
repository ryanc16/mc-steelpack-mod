package com.grouptwosoftworks.progressionplus.item.diamond;

import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class DiamondDustItem extends Item {
    public DiamondDustItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        list.add(
                Component.translatable("item.progressionplus.diamond_dust.tool_tip_description")
                        .withStyle(ChatFormatting.GRAY)
        );

        super.appendHoverText(itemstack, world, list, flag);
    }
}
