package com.grouptwosoftworks.progressionplus.item.steel.weapons;

import com.grouptwosoftworks.progressionplus.tiers.ProgressionPlusTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

/**
 * SteelWeapon classes
 */
public class SteelWeaponItem {

	/**
	 * The SteelSwordItem
	 */
	public static class SteelSwordItem extends SwordItem {
		private final static int BASE_ATTACK_DAMAGE = 3;
		private final static float ATTACK_SPEED_MODIFIER = -2.4f;
		public SteelSwordItem() {
			super(ProgressionPlusTiers.STEEL_SWORD_TIER, BASE_ATTACK_DAMAGE, ATTACK_SPEED_MODIFIER, new Item.Properties());
		}
	}
}
