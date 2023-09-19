package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelpackModTiers;
import com.grouptwosoftworks.steelpack.utils.ItemUpgradeUtils;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

/**
 * DiamondTippedItem classes
 */
public class DiamondTippedToolItems {
	public static final Logger LOGGER = LogUtils.getLogger();

	public static final String PREVIOUS_TOOL_DAMAGE = "steelpack:previous_tool_damage";

	/**
	 * This is the common onCraftedBy implementation between all DiamondTippedToolItems tools.
	 *
	 * @param player The player that crafted the item.
	 * @param pickedUpItemStack The ItemStack that was picked up when it was crafted.
	 */
	private static void onCraftedBy(Player player, ItemStack pickedUpItemStack) {
		ItemUpgradeUtils.getUpgradedIngredientItem(player.containerMenu)
			.ifPresent(inputIngredientStack -> {
				pickedUpItemStack.getOrCreateTag().putInt(PREVIOUS_TOOL_DAMAGE, inputIngredientStack.getDamageValue());
				pickedUpItemStack.setDamageValue(0); // reset the item's number of uses
			});
	};

	/**
	 * This is the common shouldDowngrade implementation between all DiamondTippedItem tools.
	 *
	 * @param selfItemStack The ItemStack in question to determined if it meets the criteria to downgrade.
	 * @return true if the itemstack meets the criteria to be downgraded.
	 */
	private static boolean shouldDowngrade(ItemStack selfItemStack) {
		var damage = selfItemStack.getDamageValue(); // damage to item
		var maxDamage = selfItemStack.getMaxDamage(); // max damage to item allowed

		// If item is about to break
		return damage >= maxDamage - 1;
	}

	private final static int STACK_SIZE_OF_ONE = 1;

	/**
	 * This is the common downgrade implementation between all DiamondTippedItem tools.
	 *
	 * @param upgradedItemStack The current upgraded item to downgrade.
	 * @param downgradeTo The item type to downgrade to.
	 * @return
	 */
	public static ItemStack downgrade(ItemStack upgradedItemStack, SteelToolItem downgradeTo) {
		var downgradeItemStack = new ItemStack(downgradeTo, STACK_SIZE_OF_ONE);
		var copiedTags = upgradedItemStack.getOrCreateTag().copy();
		downgradeItemStack.setTag(copiedTags);
		downgradeItemStack.getItem().setDamage(downgradeItemStack, DiamondTippedToolItems.getPreviousItemDamage(upgradedItemStack));
		return downgradeItemStack;
	}

	/**
	 * Retrieve the damage value of the item prior to it being upgraded.
	 * Hopefully the item hasn't been upgraded more than once!
	 *
	 * @param selfItemStack The current item stack of the upgraded item.
	 * @return The damage value of the item before it was upgraded.
	 */
	public static int getPreviousItemDamage(ItemStack selfItemStack) {
		return selfItemStack.getOrCreateTag().getInt(PREVIOUS_TOOL_DAMAGE);
	}

	/**
	 * The DiamondTippedAxe item. It can be downgraded to a SteelAxe item.
	 */
	public static class DiamondTippedAxeItem extends AxeItem implements DiamondTippedToolItem {

		public DiamondTippedAxeItem() {
			super(SteelpackModTiers.DIAMOND_TIPPED, 5f, -3.0f, new Item.Properties());
		}

		@Override
		public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
			DiamondTippedToolItems.onCraftedBy(player, itemStack);
		}

		@Override
		public boolean shouldDowngrade(ItemStack selfItemStack) {
			return DiamondTippedToolItems.shouldDowngrade(selfItemStack);
		}

		@Override
		public ItemStack downgrade(ItemStack selfItemStack) {
			return DiamondTippedToolItems.downgrade(selfItemStack, SteelTools.STEEL_AXE_ITEM);
		}
	}

	/**
	 * The DiamondTippedHoe item. It can be downgraded to the SteelHoe item.
	 */
	public static class DiamondTippedHoeItem extends HoeItem implements DiamondTippedToolItem {

		public DiamondTippedHoeItem() {
			super(SteelpackModTiers.DIAMOND_TIPPED, -3, 0.0f, new Item.Properties());
		}

		@Override
		public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
			DiamondTippedToolItems.onCraftedBy(player, itemStack);
		}

		@Override
		public boolean shouldDowngrade(ItemStack selfItemStack) {
			return DiamondTippedToolItems.shouldDowngrade(selfItemStack);
		}

		@Override
		public ItemStack downgrade(ItemStack selfItemStack) {
			return DiamondTippedToolItems.downgrade(selfItemStack, SteelTools.STEEL_HOE_ITEM);
		}
	}

	/**
	 * The DiamondTippedPickaxe item. It can be downgraded to the SteelPickaxe item.
	 */
	public static class DiamondTippedPickaxeItem extends PickaxeItem implements DiamondTippedToolItem {

		public DiamondTippedPickaxeItem() {
			super(SteelpackModTiers.DIAMOND_TIPPED, 1, -2.8f, new Item.Properties());
		}

		@Override
		public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
			DiamondTippedToolItems.onCraftedBy(player, itemStack);
		}

		@Override
		public boolean shouldDowngrade(ItemStack selfItemStack) {
			return DiamondTippedToolItems.shouldDowngrade(selfItemStack);
		}

		@Override
		public ItemStack downgrade(ItemStack selfItemStack) {
			return DiamondTippedToolItems.downgrade(selfItemStack, SteelTools.STEEL_PICKAXE_ITEM);
		}
	}

	/**
	 * The DiamondTippedShovel item. It can be downgraded to the SteelShovel item.
	 */
	public static class DiamondTippedShovelItem extends ShovelItem implements DiamondTippedToolItem {

		public DiamondTippedShovelItem() {
			super(SteelpackModTiers.DIAMOND_TIPPED, 1.5f, -3.0f, new Item.Properties());
		}

		@Override
		public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
			DiamondTippedToolItems.onCraftedBy(player, itemStack);
		}

		@Override
		public boolean shouldDowngrade(ItemStack selfItemStack) {
			return DiamondTippedToolItems.shouldDowngrade(selfItemStack);
		}

		@Override
		public ItemStack downgrade(ItemStack selfItemStack) {
			return DiamondTippedToolItems.downgrade(selfItemStack, SteelTools.STEEL_SHOVEL_ITEM);
		}
	}
}
