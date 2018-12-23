package org.ctp.enchantmentsolution.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.inventory.ConfigInventory;
import org.ctp.enchantmentsolution.inventory.InventoryData;

public class InventoryClose implements Listener{

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event){
		Player player = (Player) event.getPlayer();
		InventoryData inv = EnchantmentSolution.getInventory(player);
		if(inv != null) {
			if(inv instanceof ConfigInventory) {
				if(!((ConfigInventory)inv).isChat() && inv.getInventory().equals(event.getInventory())){
					inv.close(true);
				}
			} else if(inv.getInventory().equals(event.getInventory())) {
				inv.close(true);
			}
		}
	}
	
}
