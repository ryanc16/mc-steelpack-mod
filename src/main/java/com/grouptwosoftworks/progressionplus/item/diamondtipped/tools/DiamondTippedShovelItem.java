package com.grouptwosoftworks.progressionplus.item.diamondtipped.tools;

import com.grouptwosoftworks.progressionplus.item.steel.tools.SteelTools;
import com.grouptwosoftworks.progressionplus.tiers.ToolTiers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;

/**
 * The DiamondTippedShovel item. It can be downgraded to the SteelShovel item.
 */
public class DiamondTippedShovelItem extends ShovelItem implements DiamondTippedToolItem {

	private static final float ATTACK_DAMAGE_BASELINE = 1.5f;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -3.0f;
	private final DiamondTippedToolItemImpl impl;

	public DiamondTippedShovelItem() {
		super(ToolTiers.DIAMOND_TIPPED, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
		impl = new DiamondTippedToolItemImpl();
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
		return impl.downgrade(selfItemStack, SteelTools.STEEL_SHOVEL_ITEM);
	}
}