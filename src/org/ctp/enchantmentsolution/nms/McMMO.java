package org.ctp.enchantmentsolution.nms;

import org.bukkit.entity.Entity;
import org.bukkit.event.block.BlockBreakEvent;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.listeners.abilities.support.McMMOClassicHandler;

public class McMMO {
	
	public static void handleMcMMO(BlockBreakEvent event) {
		switch(EnchantmentSolution.getPlugin().getMcMMOType()) {
		case "Classic":
			McMMOClassicHandler.handleMcMMO(event);
			break;
		}
	}

	public static void customName(Entity e) {
		switch(EnchantmentSolution.getPlugin().getMcMMOType()) {
		case "Classic":
			McMMOClassicHandler.customName(e);
			break;
		}
	}
	
}
