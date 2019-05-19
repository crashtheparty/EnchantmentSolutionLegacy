package org.ctp.enchantmentsolution.enchantments.wrappers;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class WandWrapper extends CustomEnchantmentWrapper{

	public WandWrapper() {
		super(133);
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		return false;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;
	}

	@Override
	public int getMaxLevel() {
		return 0;
	}

	@Override
	public String getName() {
		return "WAND";
	}

	@Override
	public int getStartLevel() {
		return 0;
	}

	public boolean isCursed() {
		return false;
	}

	public boolean isTreasure() {
		return false;
	}

}
