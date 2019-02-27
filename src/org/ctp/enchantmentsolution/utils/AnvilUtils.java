package org.ctp.enchantmentsolution.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.inventory.LegacyAnvil;
import org.ctp.enchantmentsolution.utils.items.ItemUtils;
import org.ctp.enchantmentsolution.utils.items.nms.ItemRepairType;

public class AnvilUtils {
	
	private static List<Player> OPEN_LEGACY = new ArrayList<Player>();
	
	public enum RepairType{
		RENAME,
		REPAIR,
		COMBINE;
		
		public static RepairType getRepairType(ItemStack first, ItemStack second) {
			if(second == null) {
				return RepairType.RENAME;
			}
			if(canCombineItems(first, second)) {
				if(ItemUtils.getRepairMaterials().contains(second.getType())) {
					return RepairType.REPAIR;
				}else {
					return RepairType.COMBINE;
				}
			}
			return null;
		}
	}

	public static boolean canCombineItems(ItemStack first, ItemStack second) {
		if(ItemRepairType.getType(first.getType()) == null) return false;
		List<Material> items = ItemRepairType.getType(first.getType()).getRepairTypes();
		if(items == null) {
			return false;
		}
		if(second.getItemMeta().getEnchants().size() > 0 || first.getDurability() > 0) {
			if(items.contains(second.getType())) {
				if((!second.getType().equals(Material.BOOK) && !second.getType().equals(Material.ENCHANTED_BOOK)) || first.getDurability() > 0 || !second.getType().equals(first.getType())) {
					return true;
				}
				if(second.getType().equals(Material.ENCHANTED_BOOK)) {
					Map<Enchantment, Integer> enchantments = ((EnchantmentStorageMeta) second.getItemMeta()).getStoredEnchants();
					return checkEnchantments(enchantments, first);
				}
				Map<Enchantment, Integer> enchantments = second.getItemMeta().getEnchants();
				return checkEnchantments(enchantments, first);
			}
		}else if(second.getType().equals(Material.ENCHANTED_BOOK)) {
			if(((EnchantmentStorageMeta) second.getItemMeta()).getStoredEnchants().size() > 0) {
				Map<Enchantment, Integer> enchantments = ((EnchantmentStorageMeta) second.getItemMeta()).getStoredEnchants();
				return checkEnchantments(enchantments, first);
			}
		}
		return false;
	}
	
	private static boolean checkEnchantments(Map<Enchantment, Integer> enchantments, ItemStack first) {
		for (Iterator<java.util.Map.Entry<Enchantment, Integer>> it = enchantments.entrySet().iterator(); it.hasNext();) {
			java.util.Map.Entry<Enchantment, Integer> e = it.next();
			Enchantment enchant = e.getKey();
			for(CustomEnchantment customEnchant : Enchantments.getEnchantments()) {
				if(customEnchant.getRelativeEnchantment().equals(enchant)) {
					if(Enchantments.canAddEnchantment(customEnchant, first)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void addLegacyAnvil(Player player) {
		OPEN_LEGACY.add(player);
	}
	
	public static boolean hasLegacyAnvil(Player player) {
		for(Player p : OPEN_LEGACY) {
			if(p.equals(player)) {
				return true;
			}
		}
		return false;
	}
	
	public static void removeLegacyAnvil(LegacyAnvil anvil) {
		OPEN_LEGACY.remove(anvil.getPlayer());
	}
}
