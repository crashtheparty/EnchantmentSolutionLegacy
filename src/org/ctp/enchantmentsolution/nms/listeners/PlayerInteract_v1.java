package org.ctp.enchantmentsolution.nms.listeners;

import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.inventory.Anvil;
import org.ctp.enchantmentsolution.inventory.EnchantmentTable;
import org.ctp.enchantmentsolution.inventory.InventoryData;

public class PlayerInteract_v1 {

	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Block block = event.getClickedBlock();
			if(block.getType().equals(Material.ENCHANTMENT_TABLE)){
				Bukkit.getScheduler().scheduleSyncDelayedTask(EnchantmentSolution.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) return;
						Player player = event.getPlayer();
						InventoryData inv = EnchantmentSolution.getPlugin().getInventory(player);
						if(inv == null) {
							inv = new EnchantmentTable(player, block);
							EnchantmentSolution.getPlugin().addInventory(inv);
						} else if (!(inv instanceof EnchantmentTable)) {
							inv.close(true);
							inv = new EnchantmentTable(player, block);
							EnchantmentSolution.getPlugin().addInventory(inv);
						}
						inv.setInventory(null);
					}
					
				}, 1l);
			}
			if(block.getType().equals(Material.ANVIL)){
				Bukkit.getScheduler().scheduleSyncDelayedTask(EnchantmentSolution.getPlugin(), new Runnable() {
					public void run() {
						if(event.isCancelled()) return;
						Player player = event.getPlayer();
						InventoryData inv = EnchantmentSolution.getPlugin().getInventory(player);
						if(inv == null || !(inv instanceof Anvil)) {
							inv = new Anvil(player, block);
							EnchantmentSolution.getPlugin().addInventory(inv);
						} else if (!(inv instanceof Anvil)) {
							inv.close(true);
							inv = new Anvil(player, block);
							EnchantmentSolution.getPlugin().addInventory(inv);
						}
						inv.setInventory(null);
					}
					
				}, 1l);
			}
		}
	}
}
