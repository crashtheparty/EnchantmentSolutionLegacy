package org.ctp.enchantmentsolution.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.enchantments.helper.EnchantmentLevel;

public class ApiEnchantList {

	private static Map<JavaPlugin, List<ApiEnchantment>> ENCHANTMENTS = new LinkedHashMap<JavaPlugin, List<ApiEnchantment>>();
	
	/**
	 * Adds an enchantment to EnchantmentSolution's registry
	 * @param plugin - the plugin of the api enchantment
	 * @param enchant - the enchantment
	 */
	public static void addEnchantment(JavaPlugin plugin, ApiEnchantment enchant) {
		if(plugin == null) throw new NullPointerException("Plugin cannot be null.");
		List<ApiEnchantment> enchantments = ENCHANTMENTS.get(plugin);
		if (enchantments == null) {
			enchantments = new ArrayList<ApiEnchantment>();
		}
		if(!enchantments.contains(enchant)) {
			enchantments.add(enchant);
		}
		ENCHANTMENTS.put(plugin, enchantments);
	}
	
	/**
	 * Adds all enchantments in the plugin's registry to the game.
	 * @param plugin
	 */
	public static void setEnchantments(JavaPlugin plugin) {
		if(plugin == null) throw new NullPointerException("Plugin cannot be null.");
		List<ApiEnchantment> enchantments = ENCHANTMENTS.get(plugin);
		if(enchantments == null) {
			throw new NullPointerException("Enchantments for this plugin are null: " + plugin.getName() + ".");
		}
		
		for(ApiEnchantment enchant : enchantments) {
			DefaultEnchantments.addDefaultEnchantment(enchant);
		}
		
		EnchantmentSolution.getConfigFiles().updateExternalEnchantments(plugin);
		
		DefaultEnchantments.setEnchantments();
		
		EnchantmentSolution.getConfigFiles().updateEnchantments();
	}
	
	/**
	 * Returns whether the enchantment is enabled
	 * @param enchant - the enchantment to check
	 * @return boolean - whether the enchantment is enabled
	 */
	public static boolean isEnabled(Enchantment enchant) {
		return DefaultEnchantments.isEnabled(enchant);
	}
	
	/**
	 * Gets the plugin's registry of an enchantment using Minecraft's wrapper
	 * @param enchant - the enchantment to check for
	 * @return CustomEnchantment - a custom enchantment
	 */
	public static CustomEnchantment getCustomEnchantment(Enchantment enchant) {
		return DefaultEnchantments.getCustomEnchantment(enchant);
	}
	
	/**
	 * Returns if an item has the specified enchantment
	 * @param item - the item to check
	 * @param enchant - the enchantment to check for
	 * @return boolean - whether the item has the enchantment
	 */
	public static boolean hasEnchantment(ItemStack item, Enchantment enchant) {
		return Enchantments.hasEnchantment(item, enchant);
	}
	
	/**
	 * Get the level of an enchantment on an item
	 * @param item - the item to check
	 * @param enchant - the enchantment to check for
	 * @return int - the level of the enchantment on the item, or 0 if the enchantment does not exist on it
	 */
	public static int getLevel(ItemStack item, Enchantment enchant) {
		return Enchantments.getLevel(item, enchant);
	}
	
	/**
	 * Adds enchantments to an item
	 * @param item - the item to enchant
	 * @param levels - the enchantment and level of the enchantment
	 * @return ItemStack - the enchanted item stack
	 */
	public static ItemStack addEnchantmentsToItem(ItemStack item, List<EnchantmentLevel> levels) {
		return Enchantments.addEnchantmentsToItem(item, levels);
	}
	
}
