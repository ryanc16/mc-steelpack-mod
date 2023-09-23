package com.grouptwosoftworks.progressionplus.item.diamond;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class DiamondDustItem extends Item {
    public DiamondDustItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        MutableComponent translated = Component.translatable("item.progressionplus.diamond_dust.tool_tip_description");
        list.add(translated.withStyle(ChatFormatting.GRAY));

        super.appendHoverText(itemstack, world, list, flag);
    }
}
