package com.grouptwosoftworks.progressionplus.eventhandlers;

import com.grouptwosoftworks.progressionplus.Constants;
import com.grouptwosoftworks.progressionplus.item.Downgradeable;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * The ItemDowngradeEventHandler aims to identify when a downgradeable tool item incurs a use
 * due to the player breaking a block with it, and if the tool item meets the criteria for being downgraded,
 * the tool item is downgraded to its lesser tool item version and given back to the player in place
 * of its former upgraded version.
 */
@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ItemDowngradeEventHandler {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent blockBreakEvent) {
		// handle only once on server side or if the item is downgradeable
		if (blockBreakEvent.getLevel().isClientSide()) {
			return;
		}

		var player = blockBreakEvent.getPlayer(); // player from blockBreakEvent
		var itemStack = player.getMainHandItem(); // item stack being used
		// check to make sure the item is downgradeable, and it meets the criteria for it to be downgraded
		if (itemStack.getItem() instanceof Downgradeable downgradeableItem && downgradeableItem.shouldDowngrade(itemStack)) {
			// make sure the existing item breaks by setting its damage to the max damage for that particular item
			itemStack.setDamageValue(itemStack.getMaxDamage());
			// perform the downgrade
			var downgradedItem = downgradeableItem.downgrade(itemStack);
			// having restored the item to the downgraded version,
			// subtract 1 use from its previous value, because the action
			// of breaking the block will carry through to the new item further
			// down in the subsequent internal update chain.
			downgradedItem.setDamageValue(downgradedItem.getDamageValue() - 1);
			player.setItemInHand(InteractionHand.MAIN_HAND, downgradedItem);
		}
	}
}
