package org.ctp.enchantmentsolution.listeners.abilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.nms.abilities.MagmaWalkerListener_v4;

public class VoidWalkerListener extends EnchantmentListener implements Runnable{
	
	public static List<Block> BLOCKS = new ArrayList<Block>();
	private static List<VoidWalkerPlayer> HAS_VOID_WALKER = new ArrayList<VoidWalkerPlayer>();
	private static Map<Player, Integer> DELAYS = new HashMap<Player, Integer>();

	public static Map<Player, Integer> getDelays(){
		return DELAYS;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		if(!canRun(DefaultEnchantments.VOID_WALKER, event)) return;
		if(EnchantmentSolution.getPlugin().getBukkitVersion().getVersionNumber() >= 4) {
			MagmaWalkerListener_v4 listener = new MagmaWalkerListener_v4();
			listener.onPlayerMove(event);
		}
	}
	
	@Override
	public void run() {
		if(!DefaultEnchantments.isEnabled(DefaultEnchantments.VOID_WALKER)) return;
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(!contains(player)) {
				try {
					ItemStack helmet = player.getInventory().getHelmet();
					VoidWalkerPlayer voidWalkerPlayer = new VoidWalkerPlayer(player, helmet);
					HAS_VOID_WALKER.add(voidWalkerPlayer);
				} catch(Exception ex) { }
			}
		}
		for(int v = HAS_VOID_WALKER.size() - 1; v >= 0; v--) {
			VoidWalkerPlayer voidWalkerPlayer = HAS_VOID_WALKER.get(v);
			Player player = voidWalkerPlayer.getPlayer();
			if(player != null && Bukkit.getOnlinePlayers().contains(player)) {
				ItemStack boots = player.getInventory().getBoots();
				voidWalkerPlayer.setBoots(boots);
				if(voidWalkerPlayer.hasVoidWalker()) {
					if(DELAYS.containsKey(player)) {
						if (DELAYS.get(player) == null || DELAYS.get(player) - 1 <= 0) {
							DELAYS.remove(player);
						} else {
							DELAYS.put(player, DELAYS.get(player) - 1);
						}
					} else if(player.isSneaking()){
						DELAYS.put(player, 10);
						for(int i = BLOCKS.size() - 1; i >= 0; i--){
							Block block = BLOCKS.get(i);
							if(block.getLocation().getBlockY() > 1) {
								List<MetadataValue> values = block.getMetadata("VoidWalker");
								if(values != null){
									int radius = 1 + Enchantments.getLevel(boots, DefaultEnchantments.VOID_WALKER);
									List<Block> blocks = new ArrayList<Block>();
									for(int x = -radius; x <= radius; x++){
										for(int z = -radius; z <= radius; z++){
											if(Math.abs(x) + Math.abs(z) > radius + 1) continue;
											blocks.add(player.getLocation().getBlock().getRelative(x, -1, z));
										}
									}
									if(blocks.contains(block)) {
										block.setType(Material.AIR);
										BLOCKS.remove(i);
										Block lower = block.getRelative(BlockFace.DOWN);
										if((lower.getType().equals(Material.AIR))){
											lower.setMetadata("VoidWalker", new FixedMetadataValue(EnchantmentSolution.getPlugin(), new Integer(4)));
											lower.setType(Material.OBSIDIAN);
											BLOCKS.add(lower);
										}
									}
								}
							}
						}
					}
				}
			} else {
				HAS_VOID_WALKER.remove(voidWalkerPlayer);
			}
		}
	}
	
	private boolean contains(Player player) {
		for(VoidWalkerPlayer voidWalker : HAS_VOID_WALKER) {
			if(voidWalker.getPlayer().getUniqueId().equals(player.getUniqueId())) {
				return true;
			}
		}
		return false;
	}
	
	protected class VoidWalkerPlayer{
		
		private Player player;
		private ItemStack boots;
		
		public VoidWalkerPlayer(Player player, ItemStack boots) {
			this.player = player;
			this.setBoots(boots);
		}

		public Player getPlayer() {
			return player;
		}

		public ItemStack getBoots() {
			return boots;
		}
		
		public void setBoots(ItemStack boots) {
			this.boots = boots;
		}
		
		public boolean hasVoidWalker() {
			if(boots == null) {
				return false;
			}
			return Enchantments.hasEnchantment(boots, DefaultEnchantments.VOID_WALKER);
		}
		
	}
}
