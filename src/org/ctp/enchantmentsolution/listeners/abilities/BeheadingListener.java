package org.ctp.enchantmentsolution.listeners.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;

@SuppressWarnings("deprecation")
public class BeheadingListener implements Listener{

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		if(!DefaultEnchantments.isEnabled(DefaultEnchantments.BEHEADING)) return;
		Entity entity = event.getEntity();
		Player killer = event.getEntity().getKiller();
		if(killer != null){
			if(Enchantments.hasEnchantment(killer.getInventory().getItemInMainHand(), DefaultEnchantments.BEHEADING)){
				double chance = Enchantments.getLevel(killer.getInventory().getItemInMainHand(), DefaultEnchantments.BEHEADING) * .05;
				double random = Math.random();
				if(chance > random){
					if(entity instanceof Skeleton){
						ItemStack skull = new ItemStack(Material.SKULL_ITEM);
						if(((Skeleton) entity).getSkeletonType().equals(SkeletonType.WITHER)){
							skull.setDurability((short) 1);
						}
						event.getDrops().add(skull);
					}else if(entity instanceof Zombie){
						ItemStack skull = new ItemStack(Material.SKULL_ITEM);
						skull.setDurability((short) 2);
						event.getDrops().add(skull);
					}else if(entity instanceof Creeper){
						ItemStack skull = new ItemStack(Material.SKULL_ITEM);
						skull.setDurability((short) 4);
						event.getDrops().add(skull);
					}else if(entity instanceof Player){
						ItemStack skull = new ItemStack(Material.SKULL_ITEM);
						skull.setDurability((short) 3);
						SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
						skullMeta.setOwner(((Player) entity).getName());
						skullMeta.setDisplayName(ChatColor.DARK_RED + ((Player) entity).getName() + "'s Skull");
						event.getDrops().add(skull);
					}else if(entity instanceof EnderDragon){
						ItemStack skull = new ItemStack(Material.SKULL_ITEM);
						skull.setDurability((short) 5);
						event.getDrops().add(skull);
					}
				}
			}
		}
	}
}
