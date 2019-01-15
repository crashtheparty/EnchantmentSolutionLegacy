package org.ctp.enchantmentsolution.listeners.abilities;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;

public class FlowerGiftListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(!DefaultEnchantments.isEnabled(DefaultEnchantments.FLOWER_GIFT)) return;
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (event.getHand() == EquipmentSlot.OFF_HAND) {
		        return; // off hand packet, ignore.
		    }
			Player player = event.getPlayer();
			if(player.getGameMode().equals(GameMode.CREATIVE) || player.getGameMode().equals(GameMode.SPECTATOR)) return;
			ItemStack item = player.getInventory().getItemInMainHand();
			Block block = event.getClickedBlock();
			if (block != null && item != null) {
				if(Enchantments.hasEnchantment(item, DefaultEnchantments.FLOWER_GIFT)) {
					Location loc = block.getLocation().clone().add(0.5, 0.5, 0.5);
					if(block.getType() == Material.DOUBLE_PLANT && block.getData() == 10) {
						block = block.getRelative(BlockFace.DOWN);
					}
					if(FlowerGiftChance.isItem(block.getType(), block.getData())) {
						ItemStack flowerGift = FlowerGiftChance.getItem(block.getType(), block.getData());
						if(flowerGift != null) {
							Item droppedItem = player.getWorld().dropItem(
									loc,
									flowerGift);
							droppedItem.setVelocity(new Vector(0,0,0));
							player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc, 30, 0.2, 0.5, 0.2);
						} else {
							player.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, loc, 30, 0.2, 0.5, 0.2);
						}
						int unbreaking = Enchantments.getLevel(item, Enchantment.DURABILITY);
						double chance = (1.0D) / (unbreaking + 1.0D);
						double random = Math.random();
						if(chance > random) {
							item.setDurability((short) (item.getDurability() + 1));
							if(item.getDurability() > item.getType().getMaxDurability()) {
								player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
								player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
							}
						}
					}
				}
			}
		}
	}
	
	
	public enum FlowerGiftChance {
		YELLOW_FLOWER(Material.YELLOW_FLOWER, .5), RED_ROSE(Material.RED_ROSE, .5), DOUBLE_PLANT(Material.DOUBLE_PLANT, 1);
		
		private Material material;
		private double chance;
		
		private FlowerGiftChance(Material material, double chance) {
			this.material = material;
			this.chance = chance;
		}

		public Material getMaterial() {
			return material;
		}

		public double getChance() {
			return chance;
		}
		
		public static boolean isItem(Material material, byte data) {
			for(FlowerGiftChance value : values()) {
				if(value.getMaterial() == material) {
					if(material == Material.DOUBLE_PLANT) {
						if(data == 2 || data == 3 || data >= 8) return false;
					}
					return true;
				}
			}
			return false;
		}
		
		public static ItemStack getItem(Material material, byte data) {
			for(FlowerGiftChance value : values()) {
				if(value.getMaterial() == material) {
					double random = Math.random();
					if(value.getChance() > random) {
						return new ItemStack(material, 1, data);
					}
					return null;
				}
			}
			return null;
		}
	}

}
