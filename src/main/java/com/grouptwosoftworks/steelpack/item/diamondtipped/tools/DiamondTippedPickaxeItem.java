package com.grouptwosoftworks.steelpack.item.diamondtipped.tools;

import com.grouptwosoftworks.steelpack.item.steel.tools.SteelTools;
import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;

/**
 * The DiamondTippedPickaxe item. It can be downgraded to the SteelPickaxe item.
 */
public class DiamondTippedPickaxeItem extends PickaxeItem implements DiamondTippedToolItem {

	private static final int ATTACK_DAMAGE_BASELINE = 1;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -2.8f;
	private final DiamondTippedToolItemImpl impl;

	public DiamondTippedPickaxeItem() {
		super(SteelpackModTiers.DIAMOND_TIPPED, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
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
		return impl.downgrade(selfItemStack, SteelTools.STEEL_PICKAXE_ITEM);
	}
}
