package com.grouptwosoftworks.progressionplus.item.diamondtipped.tools;

import com.grouptwosoftworks.progressionplus.item.steel.tools.SteelTools;
import com.grouptwosoftworks.progressionplus.tiers.ToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * The DiamondTippedShovel item. It can be downgraded to the SteelShovel item.
 */
public class DiamondTippedShovelItem extends ShovelItem implements DiamondTippedToolItem {
	private static final float ATTACK_DAMAGE_BASELINE = 1.5f;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -3.0f;

	public DiamondTippedShovelItem() {
		super(ToolTiers.DIAMOND_TIPPED, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
	}

	@Override
	public void onCraftedBy(ItemStack pickedUpItemStack, Level level, Player player) {
		onCraftedBy(pickedUpItemStack, player);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		appendPreviousDamageHoverText(itemstack, list);
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public ItemStack downgrade(ItemStack selfItemStack) {
		return downgrade(selfItemStack, SteelTools.STEEL_SHOVEL_ITEM);
	}
}