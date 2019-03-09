package org.ctp.enchantmentsolution.nms.abilities;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.listeners.abilities.VoidWalkerListener;

public class VoidWalkerListener_v4 {

	public void onPlayerMove(PlayerMoveEvent event){
		if(!DefaultEnchantments.isEnabled(DefaultEnchantments.VOID_WALKER)) return;
		Player player = event.getPlayer();
		Location loc = player.getLocation();
		if(player.isFlying() || player.isGliding() || player.isInsideVehicle()){
			return;
		}
		ItemStack boots = player.getInventory().getBoots();
		if((event.getTo().getX() != loc.getX() && event.getTo().getZ() != loc.getZ()) && !(VoidWalkerListener.getDelays().get(player) != null 
				&& VoidWalkerListener.getDelays().get(player) > 7)){
			if(boots != null){
				if(Enchantments.hasEnchantment(boots, DefaultEnchantments.VOID_WALKER)){
					int radius = 1 + Enchantments.getLevel(boots, DefaultEnchantments.VOID_WALKER);
					for(int x = -radius; x <= radius; x++){
						for(int z = -radius; z <= radius; z++){
							if(Math.abs(x) + Math.abs(z) > radius + 1) continue;
							Location airLoc = new Location(loc.getWorld(), loc.getBlockX() + x, loc.getBlockY() - 1, loc.getBlockZ() + z);
							Block air = airLoc.getBlock();
							if((air.getType().equals(Material.AIR))){
								air.setMetadata("VoidWalker", new FixedMetadataValue(EnchantmentSolution.getPlugin(), new Integer(4)));
								air.setType(Material.OBSIDIAN);
								VoidWalkerListener.BLOCKS.add(air);
							}else if(air.getType().equals(Material.OBSIDIAN)){
								List<MetadataValue> values = air.getMetadata("VoidWalker");
								if(values != null){
									for(MetadataValue value : values){
										if(value.asInt() > 0){
											air.setMetadata("VoidWalker", new FixedMetadataValue(EnchantmentSolution.getPlugin(), new Integer(4)));
										}
									}
								}
							}
						}
					}
				}
			}
		} else if ((event.getTo().getBlockY() != loc.getBlockY())) {
			if(boots != null){
				if(Enchantments.hasEnchantment(boots, DefaultEnchantments.VOID_WALKER)){
					int radius = 1 + Enchantments.getLevel(boots, DefaultEnchantments.VOID_WALKER);
					for(int x = -radius; x <= radius; x++){
						for(int z = -radius; z <= radius; z++){
							if(Math.abs(x) + Math.abs(z) > radius + 1) continue;
							Location airLoc = new Location(loc.getWorld(), loc.getBlockX() + x, event.getTo().getBlockY() - 1, loc.getBlockZ() + z);
							Block air = airLoc.getBlock();
							if((air.getType().equals(Material.AIR))){
								air.setMetadata("VoidWalker", new FixedMetadataValue(EnchantmentSolution.getPlugin(), new Integer(4)));
								air.setType(Material.OBSIDIAN);
								VoidWalkerListener.BLOCKS.add(air);
							}else if(air.getType().equals(Material.OBSIDIAN)){
								List<MetadataValue> values = air.getMetadata("VoidWalker");
								if(values != null){
									for(MetadataValue value : values){
										if(value.asInt() > 0){
											air.setMetadata("VoidWalker", new FixedMetadataValue(EnchantmentSolution.getPlugin(), new Integer(4)));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
