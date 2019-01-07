package org.ctp.enchantmentsolution.api;

import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.EnchantmentLevel;

public class ApiEnchantmentLevel extends EnchantmentLevel{

	/**
	 * Constructor for ApiEnchantmentLevel
	 * @param enchant - the custom enchantment
	 * @param level - the level of the enchantment
	 */
	public ApiEnchantmentLevel(CustomEnchantment enchant, int level) {
		super(enchant, level);
	}

}
