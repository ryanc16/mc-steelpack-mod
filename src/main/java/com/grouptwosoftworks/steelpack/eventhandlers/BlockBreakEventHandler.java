package com.grouptwosoftworks.steelpack.eventhandlers;

import net.minecraftforge.event.level.BlockEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class BlockBreakEventHandler implements Consumer<BlockEvent.BreakEvent> {
	List<Consumer<BlockEvent.BreakEvent>> eventHandlers;

	public BlockBreakEventHandler() {
		eventHandlers = new LinkedList<>();
	}

	public BlockBreakEventHandler register(Consumer<BlockEvent.BreakEvent> handler) {
		eventHandlers.add(handler);
		return this;
	}

	@Override
	public void accept(BlockEvent.BreakEvent blockBreakEvent) {
		eventHandlers.forEach(handler -> handler.accept(blockBreakEvent));
	}
}
