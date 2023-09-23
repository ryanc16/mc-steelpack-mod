package com.grouptwosoftworks.progressionplus.init;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.block.SteelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * Registry and static access reference to registered blocks
 */
public final class ProgressionPlusModBlocks {
	private ProgressionPlusModBlocks() {}
	public static final DeferredRegister<Block> BLOCKS_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MODID);


	public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block", () -> new SteelBlock());


	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> registeredBlock = BLOCKS_REGISTRY.register(name, block);
		registerBlockItem(name, registeredBlock);
		return registeredBlock;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
		return ProgressionPlusModItems.ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
