package org.ctp.enchantmentsolution.listeners.abilities;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;

public class FishingListener extends EnchantmentListener{
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerFish(PlayerFishEvent event) {
		if(event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
			Item item = (Item)event.getCaught();
			ItemStack caught = item.getItemStack();
			Player player = event.getPlayer();
			ItemStack rod = player.getInventory().getItemInMainHand();
			if(Enchantments.hasEnchantment(rod, DefaultEnchantments.FRIED)) {
				if(canRun(DefaultEnchantments.FRIED, event)) {
					if(caught.getType().equals(Material.RAW_FISH) && (caught.getData().getData() == 0 || caught.getData().getData() == 1)) {
						caught.setType(Material.COOKED_FISH);
					}else if(caught.getType().equals(Material.RAW_FISH) && (caught.getData().getData() == 0 || caught.getData().getData() == 1)) {
						caught.setType(Material.COOKED_FISH);
					}
				}
			}
			if(Enchantments.hasEnchantment(rod, DefaultEnchantments.ANGLER)) {
				if(canRun(DefaultEnchantments.ANGLER, event)) {
					if(caught.getType().equals(Material.RAW_FISH) || caught.getType().equals(Material.COOKED_FISH)) {
						caught.setAmount(1 + Enchantments.getLevel(rod, DefaultEnchantments.ANGLER));
					}
				}
			}
			((Item) event.getCaught()).setItemStack(caught);
		}
	}
}
