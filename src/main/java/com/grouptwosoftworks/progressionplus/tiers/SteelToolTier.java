package com.grouptwosoftworks.progressionplus.tiers;

import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModItems;
import com.grouptwosoftworks.progressionplus.item.steel.Steel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * The SteelToolTier specifies the tier values for SteelTools.
 * It is currently mostly balanced between that of Iron and Diamond tiers.
 */
public class SteelToolTier implements Steel, NamedTier {

	/**
	 * Uses the resource string to get the Steel tier name.
	 *
	 * @return the steel tier name.
	 */
	@Override
	public String getName() {
		return Component.translatable("tier.progressionplus.steel.name").getString();
	}

	/**
	 * Get the maximum number of uses for a SteelToolTier item,
	 * which is currently 500; 2x that of Iron.
	 *
	 * @return The maximum number of uses for this tier.
	 */
	@Override
	public int getUses() {
		return 500;
	}

	/**
	 * Get the speed (harvest efficiency) for a SteelToolTier item,
	 * which is currently 7; greater than Iron, but less than Diamond.
	 *
	 * @return The speed (harvest efficiency) for this tier.
	 */
	@Override
	public float getSpeed() {
		return 7f;
	}

	/**
	 * Get the attack damage bonus value for a SteelToolTier item,
	 * which is currently 2.5; greater than Iron, but less than Diamond.
	 *
	 * @return The attack damage bonus for this tier.
	 */
	@Override
	public float getAttackDamageBonus() {
		return 2.5f;
	}

	/**
	 * Get the level (harvest level) for a SteelToolTier item,
	 * which is currently that of Iron.
	 *
	 * @return The level (harvest level) for this tier.
	 */
	@Override
	public int getLevel() {
		return Tiers.IRON.getLevel();
	}

	/**
	 * Get the enchantment value for a SteelToolTier item,
	 * which is currently 12; grater than Diamond, but less than Iron.
	 *
	 * @return The enchantment value for this tier.
	 */
	@Override
	public int getEnchantmentValue() {
		return 12;
	}

	/**
	 * Get the required ingredient used to repair items for a SteelToolTier item,
	 * which is Steel Ingots.
	 *
	 * @return The ingredient used to repair items in this tier.
	 */
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(ProgressionPlusModItems.STEEL_INGOT.get());
	}
}
