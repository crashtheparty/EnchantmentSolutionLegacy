package org.ctp.enchantmentsolution.nms;

import org.bukkit.event.block.BlockBreakEvent;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.listeners.abilities.mcmmo.McMMOClassicHandler;

public class McMMO {
	
	public static void handleMcMMO(BlockBreakEvent event) {
		switch(EnchantmentSolution.getMcMMOType()) {
		case "Classic":
			McMMOClassicHandler.handleMcMMO(event);
			break;
		}
	}
	
}
