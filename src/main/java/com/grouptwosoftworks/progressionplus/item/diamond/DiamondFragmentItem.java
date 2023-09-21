package com.grouptwosoftworks.progressionplus.item.diamond;

import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class DiamondFragmentItem extends Item {
    public DiamondFragmentItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        var translated = Component.translatable("item.progressionplus.diamond_fragment.tool_tip_description").getString();
        for (String part: translated.split("\n")) {
            list.add(Component.literal(part).withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(itemstack, world, list, flag);
    }
}
