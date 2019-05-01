package org.ctp.enchantmentsolution.listeners;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.listeners.abilities.MagmaWalkerListener;
import org.ctp.enchantmentsolution.listeners.abilities.VoidWalkerListener;

public class BlockListener implements Listener{

	private static List<Material> SHULKER_BOXES = Arrays.asList(Material.BLACK_SHULKER_BOX, Material.BLUE_SHULKER_BOX, Material.BROWN_SHULKER_BOX,
			Material.CYAN_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GREEN_SHULKER_BOX, Material.LIGHT_BLUE_SHULKER_BOX, Material.LIME_SHULKER_BOX,
			Material.MAGENTA_SHULKER_BOX, Material.ORANGE_SHULKER_BOX, Material.PINK_SHULKER_BOX, Material.PURPLE_SHULKER_BOX, Material.RED_SHULKER_BOX,
			Material.SILVER_SHULKER_BOX, Material.WHITE_SHULKER_BOX, Material.YELLOW_SHULKER_BOX);
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if(VoidWalkerListener.BLOCKS.contains(event.getBlock())) {
			event.setCancelled(true);
		}
		if(MagmaWalkerListener.BLOCKS.contains(event.getBlock())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if(SHULKER_BOXES.contains(event.getItemInHand().getType())) {
			ItemMeta meta = event.getItemInHand().getItemMeta();
			if(meta != null) {
				String name = meta.getDisplayName();
				if(name != null && !name.equals("")) {
					event.getBlockPlaced().setMetadata("shulker_name", new FixedMetadataValue(EnchantmentSolution.getPlugin(), name));
				}
			}
		}
	}
}
