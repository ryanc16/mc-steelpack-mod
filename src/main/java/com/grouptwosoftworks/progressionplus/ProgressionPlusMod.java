package com.grouptwosoftworks.progressionplus;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModBlocks;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModItems;
import com.grouptwosoftworks.progressionplus.init.ProgressionPlusModTabs;
import com.grouptwosoftworks.progressionplus.init.RecipeCache;
import com.grouptwosoftworks.progressionplus.loot.ProgressionPlusModLootModifiers;
import com.grouptwosoftworks.progressionplus.utils.ModShapelessRecipeDto;
import com.mojang.logging.LogUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod(Constants.MODID)
public class ProgressionPlusMod {
	public static final Logger LOGGER = LogUtils.getLogger();
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(Constants.MODID, Constants.MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public ProgressionPlusMod() {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ProgressionPlusModBlocks.BLOCKS_REGISTRY.register(bus);
		ProgressionPlusModItems.ITEMS_REGISTRY.register(bus);
		ProgressionPlusModTabs.CREATIVE_TABS_REGISTRY.register(bus);
		ProgressionPlusModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(bus);

	}

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}

	@SubscribeEvent
	public void onWorldLoad(LevelEvent.Load event) {
		var level = event.getLevel();

		if (level.isClientSide() == false) {
			var recipeManager = level.getServer().getRecipeManager();
			RecipeCache.calculatePlanksCraftingRecipes(recipeManager, level.registryAccess());
			replaceRecipes(level, recipeManager);
		}
	}

	private void replaceRecipes(LevelAccessor level, RecipeManager recipeManager) {

		var context = level.getServer().getServerResources().managers().getConditionContext();

		var oldRecipes = recipeManager.getRecipes().toArray( new Recipe<?>[0] );
		Recipe<?>[] newRecipesx = new Recipe<?>[oldRecipes.length];

		for (int i = 0; i < oldRecipes.length; i++) {
			var oldRecipe = oldRecipes[i];
			if (oldRecipe.getGroup().matches("planks") == false) {
				newRecipesx[i] = oldRecipe;
				continue;
			}

			var result = oldRecipe.getResultItem(level.registryAccess());
			var resultId = result.getItem().getCreatorModId(result) + ":" + result.getItem().toString();
			var count = result.getCount();

			var stringSplit = result.getItem().toString().split("_");
			var stringSplit2 = Arrays.copyOfRange(stringSplit, 0, stringSplit.length - 1);
			var materialName = String.join("_", stringSplit2);

			TagKey<Item> logTag = null;
			ItemStack logItem = null;
			for (var ing: oldRecipe.getIngredients()) {
				for (var item: ing.getItems()) {
					var tags = item.getTags();
					var _logTag = tags.filter(tag -> {
						var locationPath = tag.location().getPath();
						return locationPath.contains(materialName) && (
								locationPath.contains("logs") || locationPath.contains("stems") || locationPath.contains("block")
						);
					}).findFirst();

					if (_logTag.isPresent()) {
						logTag = _logTag.get();
						break;
					}
				}
				if (logTag != null) break;
			}

			if (logTag == null) {
				logItem = oldRecipe.getIngredients().get(0).getItems()[0];
			}

			var ingredients = new ModShapelessRecipeDto.Ingredient[2];
			if (logTag != null) {
				ingredients[0] = ModShapelessRecipeDto.Ingredient.withTag(getFullTagName(logTag));
			}
			else {
				ingredients[0] = ModShapelessRecipeDto.Ingredient.withItem(getFullItemName(logItem));
			}
			ingredients[1] = ModShapelessRecipeDto.Ingredient.withTag("minecraft:axes");

			ModShapelessRecipeDto mapped = new ModShapelessRecipeDto(
					"building",
					oldRecipe.getGroup(),
					ingredients,
					resultId,
					count
			);

			var gson = new Gson();
			var jsonString = gson.toJson(mapped);
			var jsonObject = JsonParser.parseString(jsonString)
					.getAsJsonObject();

			newRecipesx[i] = RecipeManager.fromJson(oldRecipe.getId(), jsonObject, context);
		}

////			var newRecipe = ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, oldRecipeResult.getItem(), oldRecipeResult.getCount())
////			.requires(oldRecipe.getIngredients().get(0))
////			.requires(ItemTags.AXES)
////			.group(oldRecipe.getGroup());

		recipeManager.replaceRecipes(Arrays.stream(newRecipesx).toList());
	}

	private String getFullTagName(TagKey tag) {
		return tag.location().getNamespace() + ":" + tag.location().getPath();
	};

	private String getFullItemName(ItemStack itemStack) {
		return itemStack.getItem().getCreatorModId(itemStack) + ":" + itemStack.getItem().toString();
	}

	@SubscribeEvent
	public void onContainerOpened(PlayerContainerEvent.Open containerEvent) {

	}

	@SubscribeEvent
	public void onPlayerUseItem(LivingEntityUseItemEvent.Finish event) {

	}
}
