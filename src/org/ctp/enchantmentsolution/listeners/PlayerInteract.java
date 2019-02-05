package org.ctp.enchantmentsolution.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.ctp.enchantmentsolution.nms.Version;
import org.ctp.enchantmentsolution.nms.listeners.PlayerInteract_v1;
import org.ctp.enchantmentsolution.nms.listeners.PlayerInteract_v2;

public class PlayerInteract implements Listener{
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if(Version.VERSION_NUMBER == 1) {
			PlayerInteract_v1 interact = new PlayerInteract_v1();
			interact.onPlayerInteract(event);
		} else {
			PlayerInteract_v2 interact = new PlayerInteract_v2();
			interact.onPlayerInteract(event);
		}
	}

}
