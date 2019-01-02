package org.ctp.enchantmentsolution.listeners.abilities;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;

import org.bukkit.ChatColor;

@SuppressWarnings("deprecation")
public class FishingListener implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerFish(PlayerFishEvent event) {
		if(event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
			Item item = (Item)event.getCaught();
			ItemStack caught = item.getItemStack();
			Player player = event.getPlayer();
			ItemStack rod = player.getInventory().getItemInMainHand();
			if(Enchantments.hasEnchantment(rod, DefaultEnchantments.FRIED)) {
				if(DefaultEnchantments.isEnabled(DefaultEnchantments.FRIED)) {
					if(Bukkit.getPluginManager().isPluginEnabled("mcMMO")) {
						if(caught.getType().equals(Material.RAW_FISH) && (caught.getData().getData() == 0 || caught.getData().getData() == 1)) {
							ItemMeta caughtMeta = caught.getItemMeta();
							caughtMeta.setDisplayName(ChatColor.RED + "CookedFish");
							caught.setItemMeta(caughtMeta);
						}
					} else {
						if(caught.getType().equals(Material.RAW_FISH) && (caught.getData().getData() == 0 || caught.getData().getData() == 1)) {
							caught.setType(Material.COOKED_FISH);
						}
					}
				}
			}
			if(Enchantments.hasEnchantment(rod, DefaultEnchantments.ANGLER)) {
				if(DefaultEnchantments.isEnabled(DefaultEnchantments.ANGLER)) {
					if(caught.getType().equals(Material.RAW_FISH) || caught.getType().equals(Material.COOKED_FISH)) {
						caught.setAmount(1 + Enchantments.getLevel(rod, DefaultEnchantments.ANGLER));
					}
				}
			}
			((Item) event.getCaught()).setItemStack(caught);
		}
	}
	
	@EventHandler
	public void onEntityPickupItem(PlayerPickupItemEvent event) {
		if(!DefaultEnchantments.isEnabled(DefaultEnchantments.FRIED)) return;
		Item item = event.getItem();
		ItemStack items = item.getItemStack();
		ItemMeta meta = items.getItemMeta();
		if(items.getType().equals(Material.RAW_FISH) && meta.getDisplayName() != null && meta.getDisplayName().equals(ChatColor.RED + "CookedFish")) {
			meta.setDisplayName("");
			items.setItemMeta(meta);
			items.setType(Material.COOKED_FISH);
		}
	}
}
