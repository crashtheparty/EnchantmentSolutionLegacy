package org.ctp.enchantmentsolution.listeners.abilities;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;

public class EnchantmentListener implements Listener{

	protected boolean canRun(Enchantment enchantment, Event event) {
		if(!DefaultEnchantments.isEnabled(enchantment)) return false;
		if(event instanceof Cancellable) {
			if(((Cancellable) event).isCancelled()) return false;
		}
		return true;
	}
	
	protected boolean canRun(Event event, boolean all, Enchantment...enchantments) {
		if(event instanceof Cancellable) {
			if(((Cancellable) event).isCancelled()) {
				return false;
			}
		}
		if(all) {
			for(Enchantment enchantment : enchantments) {
				if(!DefaultEnchantments.isEnabled(enchantment)) all = false;
			}
			if(!all) {
				return false;
			}
		} else {
			for(Enchantment enchantment : enchantments) {
				if(DefaultEnchantments.isEnabled(enchantment)) return true;
			}
			return false;
		}
		return true;
	}
	
	protected void damageItem(HumanEntity player, ItemStack item) {
		damageItem(player, item, 1.0D, 1.0D);
	}
	
	protected void damageItem(HumanEntity player, ItemStack item, double damage) {
		damageItem(player, item, damage, 1.0D);
	}
	
	protected void damageItem(HumanEntity player, ItemStack item, double damage, double extraChance) {
		if (player.getGameMode().equals(GameMode.CREATIVE) || player.getGameMode().equals(GameMode.SPECTATOR))
			return;
		int numBreaks = 0;
		int unbreaking = Enchantments.getLevel(item, Enchantment.DURABILITY);
		for(int i = 0; i < damage; i++) {
			double chance = (1.0D) / (unbreaking + extraChance);
			double random = Math.random();
			if(chance > random) {
				numBreaks ++;
			}
		};
		if (numBreaks > 0) {
			item.setDurability((short) (item.getDurability() + numBreaks));
			if(item.getDurability() > item.getType().getMaxDurability()) {
				player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
				player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
				if(player instanceof Player) {
					Player p = (Player) player;
					p.incrementStatistic(Statistic.BREAK_ITEM, item.getType());
				}
			}
		}
	}
	
}
