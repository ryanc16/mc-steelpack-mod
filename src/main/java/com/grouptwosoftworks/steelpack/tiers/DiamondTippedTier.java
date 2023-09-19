package com.grouptwosoftworks.steelpack.tiers;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

public class DiamondTippedTier implements Tier {
	@Override
	public int getUses() {
		return SteelpackModTiers.STEEL.getUses();
	}

	@Override
	public float getSpeed() {
		return Tiers.DIAMOND.getSpeed();
	}

	@Override
	public float getAttackDamageBonus() {
		return Tiers.DIAMOND.getAttackDamageBonus();
	}

	@Override
	public int getLevel() {
		return Tiers.DIAMOND.getLevel();
	}

	@Override
	public int getEnchantmentValue() {
		return SteelpackModTiers.STEEL.getEnchantmentValue();
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Tiers.DIAMOND.getRepairIngredient();
	}
}
