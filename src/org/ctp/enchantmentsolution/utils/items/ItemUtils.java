package org.ctp.enchantmentsolution.utils.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.Vector;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.enchantments.helper.EnchantmentLevel;
import org.ctp.enchantmentsolution.enchantments.helper.PlayerLevels;
import org.ctp.enchantmentsolution.utils.AnvilUtils.RepairType;
import org.ctp.enchantmentsolution.utils.ConfigUtils;
import org.ctp.enchantmentsolution.utils.items.nms.ItemRepairType;

public class ItemUtils {
	
	private static List<Material> REPAIR_MATERIALS = Arrays.asList(Material.DIAMOND, Material.IRON_INGOT, Material.GOLD_INGOT, Material.COBBLESTONE, 
			Material.WOOD, Material.LEATHER, Material.STRING);

	public static List<Material> getRepairMaterials() {
		return REPAIR_MATERIALS;
	}
	
	public static List<String> getRepairMaterialsStrings(){
		List<String> names = new ArrayList<String>();
		for(ItemRepairType type : ItemRepairType.getValues()) {
			for(Material m : type.getRepairTypes()) {
				if(!names.contains(m.name())) {
					names.add(m.name());
				}
			}
		}
		return names;
	}
	
	public static int repairItem(ItemStack first, ItemStack second) {
		int amount = second.getAmount();
		if(amount > 4) amount = 4;
		int durPerItem = first.getType().getMaxDurability() / 4;
		ItemStack clone = first.clone();
		clone.setDurability(first.getDurability());
		int level = 0;
		while(clone.getDurability() > 0) {
			level++;
			clone.setDurability((short) (clone.getDurability() - durPerItem));
		}
		return level;
	}
	
	public static ItemStack repairItem(ItemStack combined, ItemStack first, ItemStack second) {
		int amount = second.getAmount();
		if(amount > 4) amount = 4;
		int durPerItem = first.getType().getMaxDurability() / 4;
		while(combined.getDurability() > 0 && amount > 0) {
			amount--;
			combined.setDurability((short) (combined.getDurability() - durPerItem));
		}

		if(combined.getDurability() < 0) {
			combined.setDurability((short) 0);
		}
		return combined;
	}
	
	public static ItemStack combineItems(Player player, ItemStack first, ItemStack second) {
		ItemStack combined = new ItemStack(first.getType());
		if(first.getType().equals(Material.ENCHANTED_BOOK)) {
			combined = new ItemStack(Material.BOOK);
		}
		combined.setDurability(first.getDurability());
		RepairType repairType = RepairType.getRepairType(first, second);
		if(repairType == null) {
			return null;
		}
				
		if(repairType.equals(RepairType.REPAIR)) {
			combined = repairItem(combined, first, second);
		}else if(second.getType().equals(first.getType())) {
			int extraDurability = second.getType().getMaxDurability() - second.getDurability() + (int) (second.getType().getMaxDurability() * .12);
			combined.setDurability((short) (combined.getDurability() - extraDurability));
			if(combined.getDurability() < 0) {
				combined.setDurability((short) 0);
			}
		}
		
		List<EnchantmentLevel> enchantments = Enchantments.combineEnchants(player, first, second);
		
		ItemMeta firstMeta = first.getItemMeta();
		ItemMeta combinedMeta = combined.getItemMeta();
		
		if(firstMeta instanceof LeatherArmorMeta && combinedMeta instanceof LeatherArmorMeta) {
			((LeatherArmorMeta) combinedMeta).setColor(((LeatherArmorMeta) firstMeta).getColor());
		}
		
		combinedMeta.setDisplayName(firstMeta.getDisplayName());
		combinedMeta.setLore(firstMeta.getLore());
		
		combined.setItemMeta(combinedMeta);
		
		combined = Enchantments.addEnchantmentsToItem(combined, enchantments);
		
		return combined;
	}
	
	public static void giveItemToPlayer(Player player, ItemStack item, Location fallback, boolean statistic) {
		HashMap<Integer, ItemStack> leftOver = new HashMap<Integer, ItemStack>();
		int amount = item.getAmount();
		leftOver.putAll((player.getInventory().addItem(item)));
		if (!leftOver.isEmpty()) {
			for (Iterator<java.util.Map.Entry<Integer, ItemStack>> it = leftOver.entrySet().iterator(); it.hasNext();) {
				java.util.Map.Entry<Integer, ItemStack> e = it.next();
				amount -= e.getValue().getAmount();
				fallback.add(0.5, 0.5, 0.5);
				Item droppedItem = player.getWorld().dropItem(
						fallback,
						e.getValue());
				droppedItem.setVelocity(new Vector(0,0,0));
				droppedItem.teleport(fallback);
			}
		}
		if(amount > 0 && statistic) {
			player.incrementStatistic(Statistic.PICKUP, item.getType(), amount);
		}
	}
	
	public static ItemStack addNMSEnchantment(ItemStack item, String type) {
		ItemStack returnItem = new ItemStack(item.getType());
		ItemStack duplicate = item.clone();
		ItemMeta returnItemMeta = returnItem.getItemMeta();
		ItemMeta duplicateMeta = duplicate.getItemMeta();
		
		returnItemMeta.setDisplayName(duplicateMeta.getDisplayName());
		returnItem.setItemMeta(returnItemMeta);
		returnItem.setDurability(duplicate.getDurability());
		
		List<EnchantmentLevel> enchants = null;
		while(enchants == null) {
			int bookshelves = ConfigUtils.getBookshelvesFromType(type);
			boolean treasure = ConfigUtils.includeTreasureFromType(type);
			PlayerLevels levels = PlayerLevels.generateFakePlayerLevels(returnItem.getType(), bookshelves, treasure);
			int i = 0;
			while(i < 3) {
				int random = (int)(Math.random() * levels.getEnchants().size() + ConfigUtils.getLevelFromType(type));
				if(random > levels.getEnchants().size() - 1) random = levels.getEnchants().size() - 1;
				if(levels.getEnchants().get(random).size() > 0) {
					enchants = levels.getEnchants().get(random);
					break;
				}
				i++;
			}
			if(i >= 3) break;
		}
		
		returnItem = Enchantments.addEnchantmentsToItem(returnItem, enchants);
		
		return returnItem;
	}
}
