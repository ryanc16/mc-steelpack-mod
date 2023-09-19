
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.grouptwosoftworks.progressionplus.init;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.block.SteelBlockBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registry and static access reference to registered blocks
 */
public class ProgressionPlusModBlocks {
	private ProgressionPlusModBlocks() {}

	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MODID);
	public static final RegistryObject<Block> STEEL_BLOCK = REGISTRY.register("steel_block", () -> new SteelBlockBlock());
}
