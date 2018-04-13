package org.ctp.enchantmentsolution.listeners.abilities;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.nms.Version;
import org.ctp.enchantmentsolution.nms.listeners.abilities.MagmaWalkerListener_v4;
import org.ctp.enchantmentsolution.utils.LocationUtils;

public class MagmaWalkerListener implements Listener, Runnable{
	
	public static List<Block> BLOCKS = new ArrayList<Block>();

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		if(Version.VERSION_NUMBER >= 4) {
			MagmaWalkerListener_v4 listener = new MagmaWalkerListener_v4();
			listener.onPlayerMove(event);
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if(Version.VERSION_NUMBER >= 4) {
			MagmaWalkerListener_v4 listener = new MagmaWalkerListener_v4();
			listener.onEntityDamage(event);
		}
	}

	@Override
	public void run() {
		for(int i = BLOCKS.size() - 1; i >= 0; i--){
			Block block = BLOCKS.get(i);
			List<MetadataValue> values = block.getMetadata("MagmaWalker");
			if(values != null){
				for(MetadataValue value : values){
					if(value.asInt() > 0){
						boolean update = true;
						for(Player player : Bukkit.getOnlinePlayers()){
							if(!DefaultEnchantments.isEnabled(DefaultEnchantments.MAGMA_WALKER)) continue;
							ItemStack boots = player.getInventory().getBoots();
							if(boots != null){
								update = false;
								if(Enchantments.hasEnchantment(boots, DefaultEnchantments.MAGMA_WALKER)){
									int radius = 2 + Enchantments.getLevel(boots, DefaultEnchantments.MAGMA_WALKER);
									Location locMin = new Location(player.getWorld(), player.getLocation().getBlockX() - radius, player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ() - radius);
									Location locMax = new Location(player.getWorld(), player.getLocation().getBlockX() + radius, player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ() + radius);
									if(!(LocationUtils.getIntersecting(locMin, locMax, block.getLocation(), block.getLocation()))){
										block.setMetadata("MagmaWalker", new FixedMetadataValue(EnchantmentSolution.PLUGIN, new Integer(value.asInt() - 1)));
									}
									BLOCKS.set(i, block);
								}
							}
						}
						if(update){
							block.setMetadata("MagmaWalker", new FixedMetadataValue(EnchantmentSolution.PLUGIN, new Integer(value.asInt() - 1)));
						}
					}else{
						block.removeMetadata("MagmaWalker", EnchantmentSolution.PLUGIN);
						block.setType(Material.LAVA);
						BLOCKS.remove(i);
					}
				}
			}else{
				block.setType(Material.LAVA);
				BLOCKS.remove(i);
			}
		}
	}
}
