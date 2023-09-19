package com.grouptwosoftworks.steelpack.item;

import com.grouptwosoftworks.steelpack.tiers.SteelTier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class SteelWeaponItem {

	public static class SteelSwordItem extends SwordItem {
		public SteelSwordItem() {
			super(new SteelSwordTier(), 3, -2.4f, new Item.Properties());
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
