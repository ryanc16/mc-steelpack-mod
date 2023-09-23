package com.grouptwosoftworks.progressionplus.item.diamondtipped.tools;

import com.grouptwosoftworks.progressionplus.item.steel.tools.SteelTools;
import com.grouptwosoftworks.progressionplus.tiers.ToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * The DiamondTippedAxe item. It can be downgraded to a SteelAxe item.
 */
public class DiamondTippedAxeItem extends AxeItem implements DiamondTippedToolItem {
	private static final float ATTACK_DAMAGE_BASELINE = 5f;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -3.0f;

	public DiamondTippedAxeItem() {
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
		return downgrade(selfItemStack, SteelTools.STEEL_AXE_ITEM);
	}
}
