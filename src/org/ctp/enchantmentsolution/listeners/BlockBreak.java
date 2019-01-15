package org.ctp.enchantmentsolution.listeners;

import java.util.logging.Level;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.ctp.enchantmentsolution.listeners.abilities.MagmaWalkerListener;
import org.ctp.enchantmentsolution.listeners.abilities.VoidWalkerListener;
import org.ctp.enchantmentsolution.utils.ChatUtils;

public class BlockBreak implements Listener{

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		ChatUtils.sendToConsole(Level.INFO, event.getBlock().getType().name());
		if(VoidWalkerListener.BLOCKS.contains(event.getBlock())) {
			event.setCancelled(true);
		}
		if(MagmaWalkerListener.BLOCKS.contains(event.getBlock())) {
			event.setCancelled(true);
		}
	}
}
