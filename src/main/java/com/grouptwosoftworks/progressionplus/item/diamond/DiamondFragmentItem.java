package com.grouptwosoftworks.progressionplus.item.diamond;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;

public class DiamondFragmentItem extends Item {
    public DiamondFragmentItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        String translated = Component.translatable("item.progressionplus.diamond_fragment.tool_tip_description").getString();
        Arrays.stream(translated.split("\n"))
            .map(text -> Component.literal(text).withStyle(ChatFormatting.GRAY))
            .forEach(list::add);

        super.appendHoverText(itemstack, world, list, flag);
    }
}
