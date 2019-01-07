package org.ctp.enchantmentsolution.enchantments.vanilla;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.ItemType;

public class FireProtection extends CustomEnchantment{
	
	public FireProtection() {
		setDefaultDisplayName("Fire Protection");
		setDefaultFiftyConstant(-8);
		setDefaultThirtyConstant(2);
		setDefaultFiftyModifier(15);
		setDefaultThirtyModifier(8);
		setDefaultFiftyMaxConstant(21);
		setDefaultThirtyMaxConstant(12);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(4);
		setDefaultThirtyMaxLevel(4);
		setDefaultWeight(Weight.UNCOMMON);
	}

	@Override
	public String getName() {
		return "fire_protection";
	}

	@Override
	public Enchantment getRelativeEnchantment() {
		return Enchantment.PROTECTION_FIRE;
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.ARMOR);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.ARMOR);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList(Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.PROTECTION_EXPLOSIONS, Enchantment.PROTECTION_PROJECTILE);
	}

	@Override
	public String getDescription() {
		return "Reduces fire damage.";
	}

}
