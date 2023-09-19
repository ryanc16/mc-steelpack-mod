/**
 * The code of this mod element is always locked.
 * <p>
 * You can register new events in this class too.
 * <p>
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside com.grouptwosoftworks.steelpack as this package is managed by MCreator.
 * <p>
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 * <p>
 * This class will be added in the mod root package.
 */
package com.grouptwosoftworks.steelpack.tiers;

import com.grouptwosoftworks.steelpack.init.SteelpackModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class SteelTier implements Tier {

	@Override
	public int getLevel() {
		return 2;
	}

	@Override
	public int getUses() {
		return 500;
	}

	@Override
	public float getSpeed() {
		return 7f;
	}

	@Override
	public float getAttackDamageBonus() {
		return 2.5f;
	}

	@Override
	public int getEnchantmentValue() {
		return 12;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(new ItemStack(SteelpackModItems.STEEL_INGOT.get()));
	}
}
