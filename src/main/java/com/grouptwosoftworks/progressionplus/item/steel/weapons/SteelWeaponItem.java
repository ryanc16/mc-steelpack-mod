package com.grouptwosoftworks.progressionplus.item.steel.weapons;

import com.grouptwosoftworks.progressionplus.tiers.SteelTier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

/**
 * SteelWeapon classes
 */
public class SteelWeaponItem {

	public static class SteelSwordItem extends SwordItem {
		private final static int BASE_ATTACK_DAMAGE = 3;
		private final static float ATTACK_SPEED_MODIFIER = -2.4f;
		public SteelSwordItem() {
			super(new SteelSwordTier(), BASE_ATTACK_DAMAGE, ATTACK_SPEED_MODIFIER, new Item.Properties());
		}

		private static final class SteelSwordTier extends SteelTier {
			@Override
			public float getSpeed() {
				return Tiers.DIAMOND.getSpeed();
			}

			@Override
			public float getAttackDamageBonus() {
				return Tiers.DIAMOND.getAttackDamageBonus();
			}
		}
	}
}
