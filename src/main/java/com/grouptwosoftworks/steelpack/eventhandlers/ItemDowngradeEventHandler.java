package com.grouptwosoftworks.steelpack.eventhandlers;

import com.grouptwosoftworks.steelpack.item.Downgradeable;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.event.level.BlockEvent;

import java.util.function.Consumer;

public class ItemDowngradeEventHandler implements Consumer<BlockEvent.BreakEvent> {
	@Override
	public void accept(BlockEvent.BreakEvent blockBreakEvent) {
		// handle only once on server side or if the item is downgradeable
		if (blockBreakEvent.getLevel().isClientSide()) {
			return;
		}

		var player = blockBreakEvent.getPlayer(); // player from blockBreakEvent
		var itemStack = player.getMainHandItem(); // item being used
		var item = itemStack.getItem();
		if (item instanceof Downgradeable downgradeableItem) {
			var damage = item.getDamage(itemStack); // damage to item
			var maxDamage = item.getMaxDamage(itemStack); // max damage to item allowed

			// If item is about to break
			if (damage >= maxDamage - 1) {
				item.setDamage(itemStack, maxDamage); // make sure it will break
				// handle downgrade
				var downgradedItem = downgradeableItem.downgrade(itemStack);
				player.setItemInHand(InteractionHand.MAIN_HAND, downgradedItem);
			}
		}
	}
}
