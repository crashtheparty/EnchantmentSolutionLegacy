package org.ctp.enchantmentsolution.listeners.abilities;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.nms.McMMO;
import org.ctp.enchantmentsolution.utils.StringUtils;

public class NetListener extends EnchantmentListener{
	
	public static List<AnimalMob> ANIMALS = new ArrayList<AnimalMob>();

	@EventHandler(priority=EventPriority.HIGHEST)
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if(!canRun(DefaultEnchantments.NET, event)) return;
		Entity attacker = event.getDamager();
		Entity attacked = event.getEntity();
		if(attacker instanceof Player && attacked instanceof Animals){
			Player player = (Player) attacker;
			ItemStack attackItem = player.getInventory().getItemInMainHand();
			if(attackItem != null && Enchantments.hasEnchantment(attackItem, DefaultEnchantments.NET)){
				int max = Enchantments.getLevel(attackItem, DefaultEnchantments.NET);
				int current = 0;
				for(AnimalMob animal : ANIMALS) {
					if((animal.getItem() != null && animal.getItem().equals(attackItem)) || StringUtils.getAnimalIDsFromItem(attackItem).contains(animal.getEntityID())) {
						current ++;
					}
				}
				if(current >= max) return;
				McMMO.customName(attacked);
				ANIMALS.add(new AnimalMob((Animals) attacked, attackItem));
				attacked.remove();
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(!canRun(DefaultEnchantments.NET, event)) return;
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (event.getHand() == EquipmentSlot.OFF_HAND) {
		        return; // off hand packet, ignore.
		    }
			Player player = event.getPlayer();
			ItemStack item = player.getInventory().getItemInMainHand();
			if(item != null && Enchantments.hasEnchantment(item, DefaultEnchantments.NET)){
				AnimalMob remove = null;
				List<Integer> entityIDs = StringUtils.getAnimalIDsFromItem(item);
				if(entityIDs.size() == 0) return;
				int entityID = entityIDs.get(0);
				for(AnimalMob animal : ANIMALS) {
					if((animal.getItem() != null && item.equals(animal.getItem())) || (entityIDs.size() > 0 && entityID == animal.getEntityID())) {
						remove = animal;
						Location loc = event.getClickedBlock().getRelative(event.getBlockFace()).getLocation().add(0.5, 0, 0.5);
						Entity e = loc.getWorld().spawnEntity(loc, animal.getMob());
						e.setCustomName(animal.getName());
						if(e instanceof Animals) {
							((Animals) e).setHealth(animal.getHealth());
							((Animals) e).setAge(animal.getAge());
						}
						damageItem(player, item, 1, 2);
						StringUtils.removeAnimal(item, entityID);
						break;
					}
				}
				if(remove != null) {
					ANIMALS.remove(remove);
				}
			}
		}
	}
	
	public static class AnimalMob{
		
		private EntityType mob;
		private String name;
		private double health;
		private ItemStack item;
		private int age, entityID;
		
		public AnimalMob(Animals mob, ItemStack item) {
			this.setMob(mob.getType());
			this.setName(mob.getCustomName());
			this.setHealth(mob.getHealth());
			this.setItem(item);
			this.setAge(mob.getAge());
		}
		
		public AnimalMob(EntityType type, String name, double health, int age, int entityID) {
			this.setMob(type);
			this.setName(name);
			this.setHealth(health);
			this.setEntityID(entityID, false);
			this.setAge(age);
		}
		
		private void generateID() {
			int base = 100;
			for(AnimalMob animal : ANIMALS) {
				if(animal.getEntityID() > base) base = animal.getEntityID();
			}
			setEntityID(base + 1, true);
		}

		public ItemStack getItem() {
			return item;
		}

		public void setItem(ItemStack item) {
			this.item = item;
			generateID();
		}

		public EntityType getMob() {
			return mob;
		}

		public void setMob(EntityType mob) {
			this.mob = mob;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getHealth() {
			return health;
		}

		public void setHealth(double health) {
			this.health = health;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getEntityID() {
			return entityID;
		}

		public void setEntityID(int entityID, boolean addLore) {
			this.entityID = entityID;
			if(addLore) {
				StringUtils.addAnimal(item, entityID);
			}
		}
	}
}
