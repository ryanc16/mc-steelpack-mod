package com.grouptwosoftworks.progressionplus.item.diamondtipped.tools;

import com.grouptwosoftworks.progressionplus.item.steel.tools.SteelTools;
import com.grouptwosoftworks.progressionplus.tiers.ToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * The DiamondTippedHoe item. It can be downgraded to the SteelHoe item.
 */
public class DiamondTippedHoeItem extends HoeItem implements DiamondTippedToolItem {

	private static final int ATTACK_DAMAGE_BASELINE = -3;
	private static final float HARVEST_EFFICIENCY_MODIFIER = 0.0f;
	private final DiamondTippedToolItemImpl impl;

	public DiamondTippedHoeItem() {
		super(ToolTiers.DIAMOND_TIPPED, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
		impl = new DiamondTippedToolItemImpl();
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		impl.appendPreviousDamageHoverText(itemstack, list);
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
		impl.onCraftedBy(player, itemStack);
	}

	@Override
	public boolean shouldDowngrade(ItemStack selfItemStack) {
		return impl.shouldDowngrade(selfItemStack);
	}

	@Override
	public ItemStack downgrade(ItemStack selfItemStack) {
		return impl.downgrade(selfItemStack, SteelTools.STEEL_HOE_ITEM);
	}
}
