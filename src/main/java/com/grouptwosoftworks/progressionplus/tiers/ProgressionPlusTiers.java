package com.grouptwosoftworks.progressionplus.tiers;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModItems;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModTags;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;
import java.util.Map;

/**
 * A barrel-like export of static instances of all Tiers.
 */
public final class ProgressionPlusTiers {
	private ProgressionPlusTiers() {}

	public static final Tier STEEL_TIER = TierSortingRegistry.registerTier(
			new ForgeTier(
				2, 500, 7f, 2.5f, 12,
				ProgressionPlusModTags.Blocks.NEEDS_STEEL_TOOL,
				() -> Ingredient.of(ProgressionPlusModItems.STEEL_INGOT.get())
			),
			new ResourceLocation(Constants.MODID, "steel"),
			List.of(Tiers.IRON),
			List.of(Tiers.DIAMOND, Tiers.NETHERITE)
	);

	public static final Tier STEEL_SWORD_TIER = TierSortingRegistry.registerTier(
			new ForgeTier(
					2, 500, 8f, 3f, 12,
					ProgressionPlusModTags.Blocks.NEEDS_STEEL_TOOL,
					() -> Ingredient.of(ProgressionPlusModItems.STEEL_INGOT.get())
			),
			new ResourceLocation(Constants.MODID, "steel_weapon"),
			List.of(Tiers.IRON),
			List.of(Tiers.DIAMOND, Tiers.NETHERITE)
	);

	public static final Tier DIAMOND_TIPPED_TIER = TierSortingRegistry.registerTier(
			new ForgeTier(
					3, 500, 8f, 3f, 12,
					ProgressionPlusModTags.Blocks.NEEDS_STEEL_TOOL,
					() -> Ingredient.of(ProgressionPlusModItems.DIAMOND_FRAGMENT.get())
			),
			new ResourceLocation(Constants.MODID, "diamond_tipped"),
			List.of(Tiers.IRON, STEEL_TIER),
			List.of(Tiers.NETHERITE)
	);

	public static Map<Tier, MutableComponent> TIER_NAME_KEYS = Map.of(
		STEEL_TIER, Component.translatable("tier.progressionplus.steel.name"),
		STEEL_SWORD_TIER, Component.translatable("tier.progressionplus.steel.name"),
		DIAMOND_TIPPED_TIER, Component.translatable("tier.progressionplus.diamond_tipped.name")
	);
}
