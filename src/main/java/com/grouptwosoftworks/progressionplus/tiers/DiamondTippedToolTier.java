package com.grouptwosoftworks.progressionplus.tiers;

import com.grouptwosoftworks.progressionplus.item.diamondtipped.DiamondTipped;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * The DiamondTippedToolTier specifies the tier values for DiamondTippedTools.
 * It is currently a combination between Steel and Diamond tiers.
 */
public class DiamondTippedToolTier implements DiamondTipped, Tier {
	/**
	 * Get the maximum number of uses for a DiamondTippedToolTier item,
	 * which is currently that of Steel.
	 *
	 * @return The maximum number of uses for this tier.
	 */
	@Override
	public int getUses() {
		return ToolTiers.STEEL.getUses();
	}

	/**
	 * Get the speed (harvest efficiency) for a DiamondTippedToolTier item,
	 * which is currently that of Diamond.
	 *
	 * @return The speed (harvest efficiency) for this tier.
	 */
	@Override
	public float getSpeed() {
		return Tiers.DIAMOND.getSpeed();
	}

	/**
	 * Get the attack damage bonus value for a DiamondTippedToolTier item,
	 * which is currently that of Diamond.
	 *
	 * @return The attack damage bonus for this tier.
	 */
	@Override
	public float getAttackDamageBonus() {
		return Tiers.DIAMOND.getAttackDamageBonus();
	}

	/**
	 * Get the level (harvest level) for a DiamondTippedToolTier item,
	 * which is currently that of Diamond.
	 *
	 * @return The level (harvest level) for this tier.
	 */
	@Override
	public int getLevel() {
		return Tiers.DIAMOND.getLevel();
	}

	/**
	 * Get the enchantment value for a DiamondTippedToolTier item,
	 * which is currently that of Steel.
	 *
	 * @return The enchantment value for this tier.
	 */
	@Override
	public int getEnchantmentValue() {
		return ToolTiers.STEEL.getEnchantmentValue();
	}

	/**
	 * Get the required ingredient used to repair items for a DiamondTippedToolTier item,
	 * which is currently that of Diamond.
	 *
	 * @return The ingredient used to repair items in this tier.
	 */
	@Override
	public Ingredient getRepairIngredient() {
		return Tiers.DIAMOND.getRepairIngredient();
	}
}
