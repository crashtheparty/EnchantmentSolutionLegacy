package org.ctp.enchantmentsolution.nms.abilities;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.listeners.abilities.MagmaWalkerListener;

public class MagmaWalkerListener_v4 {
	
	@SuppressWarnings("deprecation")
	public void onPlayerMove(PlayerMoveEvent event){
		if(!DefaultEnchantments.isEnabled(DefaultEnchantments.MAGMA_WALKER)) return;
		Player player = event.getPlayer();
		Location loc = player.getLocation();
		if(player.isFlying() || player.isGliding() || player.isInsideVehicle() || !(player.isOnGround())){
			return;
		}
		ItemStack boots = player.getInventory().getBoots();
		if(event.getTo().getX() != loc.getX() && event.getTo().getZ() != loc.getZ()){
			if(boots != null){
				if(Enchantments.hasEnchantment(boots, DefaultEnchantments.MAGMA_WALKER)){
					int radius = 2 + Enchantments.getLevel(boots, DefaultEnchantments.MAGMA_WALKER);
					for(int x = -radius; x <= radius; x++){
						for(int z = -radius; z <= radius; z++){
							Location lavaLoc = new Location(loc.getWorld(), loc.getBlockX() + x, loc.getBlockY() - 1, loc.getBlockZ() + z);
							Block lava = lavaLoc.getBlock();
							Location aboveLoc = new Location(loc.getWorld(), loc.getBlockX() + x, loc.getBlockY(), loc.getBlockZ() + z);
							if(aboveLoc.getBlock().getType().equals(Material.STATIONARY_LAVA) || aboveLoc.getBlock().getType().equals(Material.LAVA)){
								continue;
							}
							if((lava.getType().equals(Material.STATIONARY_LAVA) || lava.getType().equals(Material.LAVA)) && lava.getData() == 0){
								lava.setMetadata("MagmaWalker", new FixedMetadataValue(EnchantmentSolution.getPlugin(), new Integer(4)));
								lava.setType(Material.MAGMA);
								MagmaWalkerListener.BLOCKS.add(lava);
							}else if(lava.getType().equals(Material.MAGMA)){
								List<MetadataValue> values = lava.getMetadata("MagmaWalker");
								if(values != null){
									for(MetadataValue value : values){
										if(value.asInt() > 0){
											lava.setMetadata("MagmaWalker", new FixedMetadataValue(EnchantmentSolution.getPlugin(), new Integer(4)));
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
	
	public void onEntityDamage(EntityDamageEvent event) {
		if(!DefaultEnchantments.isEnabled(DefaultEnchantments.MAGMA_WALKER)) return;
		if(event.getCause().equals(DamageCause.HOT_FLOOR)) {
			Entity entity = event.getEntity();
			if(entity instanceof LivingEntity) {
				LivingEntity player = (LivingEntity) entity;
				ItemStack boots = player.getEquipment().getBoots();
				if(boots != null && Enchantments.hasEnchantment(boots, DefaultEnchantments.MAGMA_WALKER)) {
					event.setCancelled(true);
				}
			}
		}
	}
}
