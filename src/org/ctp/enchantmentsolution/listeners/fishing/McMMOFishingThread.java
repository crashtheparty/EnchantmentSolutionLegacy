package org.ctp.enchantmentsolution.listeners.fishing;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.listeners.fishing.mcmmo.McMMOFishingListener;

public class McMMOFishingThread implements Runnable{

	private Player player;
	private ItemStack item;
	private int run = 3, scheduler, xp;
	private McMMOFishingListener listener;
	
	public McMMOFishingThread(Player player, ItemStack item, int xp, McMMOFishingListener listener) {
		this.player = player;
		this.item = item;
		this.xp = xp;
		this.listener = listener;
	}

	@Override
	public void run() {
		if(run <= 0) {
			listener.remove(this);
		}
		run --;
	}
	
	public int getScheduler() {
		return scheduler;
	}
	
	public void setScheduler(int s) {
		scheduler = s;
	}

	public ItemStack getItem() {
		return item;
	}

	public Player getPlayer() {
		return player;
	}

	public int getXp() {
		return xp;
	}
}
