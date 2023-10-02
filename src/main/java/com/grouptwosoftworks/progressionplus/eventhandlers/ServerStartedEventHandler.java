package com.grouptwosoftworks.progressionplus.eventhandlers;

import com.grouptwosoftworks.progressionplus.init.RecipeCache;
import com.grouptwosoftworks.progressionplus.utils.recipes.ModRecipeUpdater;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;


public class ServerStartedEventHandler {

	private static final List<ModRecipeUpdater.RecipeUpdater<? extends Recipe<?>>> RECIPE_UPDATERS = List.of(
		ModRecipeUpdater.RecipeUpdaters.LOGS_TO_PLANKS
	);

	@SubscribeEvent
	public void onServerStarted(ServerStartedEvent event) {
		MinecraftServer server = event.getServer();
		if (RECIPE_UPDATERS.size() > 0) {
			ModRecipeUpdater.updateRecipes(server, RECIPE_UPDATERS);
		}
		RecipeCache.initialize(server);
	}
}
