package org.ctp.enchantmentsolution.nms.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.ctp.enchantmentsolution.nms.ChestPopulateNMS;

public class ChestLoot_v1 {

	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Block block = event.getClickedBlock();
			if(block != null) {
				if(block.getType() == Material.CHEST) {
					if(ChestPopulateNMS.isLootChest(block)) {
						ChestPopulateNMS.populateChest(block);
					}
				}
			}
		}
	}
}
