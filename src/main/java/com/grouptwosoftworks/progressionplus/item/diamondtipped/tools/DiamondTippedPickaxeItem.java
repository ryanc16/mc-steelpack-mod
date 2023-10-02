package com.grouptwosoftworks.progressionplus.item.diamondtipped.tools;

import com.grouptwosoftworks.progressionplus.item.steel.tools.SteelTools;
import com.grouptwosoftworks.progressionplus.tiers.ProgressionPlusTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * The DiamondTippedPickaxe item. It can be downgraded to the SteelPickaxe item.
 */
public class DiamondTippedPickaxeItem extends PickaxeItem implements DiamondTippedToolItem {
	private static final int ATTACK_DAMAGE_BASELINE = 1;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -2.8f;

	public DiamondTippedPickaxeItem() {
		super(ProgressionPlusTiers.DIAMOND_TIPPED_TIER, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
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
		return downgrade(selfItemStack, SteelTools.STEEL_PICKAXE_ITEM);
	}
}
