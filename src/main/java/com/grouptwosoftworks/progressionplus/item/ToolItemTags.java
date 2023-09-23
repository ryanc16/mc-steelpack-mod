package com.grouptwosoftworks.progressionplus.item;

import com.grouptwosoftworks.progressionplus.Constants;

/**
 * Tags related to tool items
 */
public final class ToolItemTags {
	private ToolItemTags() {}

	/** The tag key to identify the previous tool's damage */
	public static final String PREVIOUS_TOOL_DAMAGE = String.format("%s:previous_tool_damage", Constants.MODID);
}
