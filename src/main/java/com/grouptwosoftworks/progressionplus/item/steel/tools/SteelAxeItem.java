package com.grouptwosoftworks.progressionplus.item.steel.tools;

import com.grouptwosoftworks.progressionplus.tiers.ToolTiers;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;


/**
 * The SteelAxe item. It can be upgraded to a DiamondTippedAxe item.
 */
public class SteelAxeItem extends AxeItem implements SteelToolItem {
	private static final float ATTACK_DAMAGE_BASELINE = 5.5f;
	private static final float HARVEST_EFFICIENCY_MODIFIER = -2.0f;

	public SteelAxeItem() {
		super(ToolTiers.STEEL, ATTACK_DAMAGE_BASELINE, HARVEST_EFFICIENCY_MODIFIER, new Item.Properties());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {


		var player = context.getPlayer();
		if (player == null) {
			return super.useOn(context);
		}

		var level = context.getLevel();
		var positionClicked = context.getClickedPos();
		var blockState = level.getBlockState(positionClicked);
		var isALog = blockState.is(BlockTags.LOGS);

		if (isALog == false) {
			return super.useOn(context);
		}
		// Block is a Log, Player is populated

		var block = blockState.getBlock();

		// Client Side
		if (level.isClientSide()) {
			if (player.isCrouching()) {
				blockState.attack(level, positionClicked, player);
				return InteractionResult.SUCCESS;
			}
			return super.useOn(context);
		}

		// Server Side
		if (player.isCrouching()) {
			// Server Side, Player is using our new custom action
			// var progress = blockState.getDestroyProgress(player, level, positionClicked);
			blockState.attack(level, positionClicked, player);

			// var event = new PlayerEvent.BreakSpeed(player, blockState, this.speed, positionClicked);
			// MinecraftForge.EVENT_BUS.post(event);

			return InteractionResult.SUCCESS;
		}

		// Server Side, Player is using normal use action
		return super.useOn(context);
	}
}
