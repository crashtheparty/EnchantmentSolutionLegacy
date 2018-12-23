package org.ctp.enchantmentsolution.enchantments.mcmmo;

import java.util.logging.Level;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.utils.ChatUtils;

public class FishingEnchanted {

	private CustomEnchantment enchant;
	private int level;
	
	public FishingEnchanted(CustomEnchantment enchant, int level) {
		this.enchant = enchant;
		this.level = level;
	}
	
	public FishingEnchanted(String configString) {
		String[] split = configString.split(" ");
		if(split.length == 2) {
			try {
				this.level = Integer.parseInt(split[1]);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				return;
			}
			this.enchant = getEnchantFromString(split[0]);
		} else {
			ChatUtils.sendToConsole(Level.WARNING, "Bad enchantment in fishing config: " + configString + ". No chance to get this enchantment.");
		}
	}
	
	private CustomEnchantment getEnchantFromString(String key) {
		if (Enchantment.getByName(key) != null) {
			for(CustomEnchantment enchantment : DefaultEnchantments.getEnchantments()) {
				if(enchantment.getRelativeEnchantment().equals(Enchantment.getByName(key))) {
					return enchantment;
				}
			}
		}
		ChatUtils.sendToConsole(Level.WARNING, "Bad enchantment in fishing config: " + key + ". No chance to get this enchantment.");
		return null;
	}

	public CustomEnchantment getEnchant() {
		return enchant;
	}

	public int getLevel() {
		return level;
	}
	
	public String toString() {
		if(enchant == null) {
			return "null";
		}
		
		Enchantment enchant = this.enchant.getRelativeEnchantment();
		
		if(enchant == null) {
			return "null";
		}
		
		return enchant.getName() + " " + level;
	}
}
