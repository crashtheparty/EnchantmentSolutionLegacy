package org.ctp.enchantmentsolution.enchantments.vanilla;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.ItemType;

public class Protection extends CustomEnchantment{
	
	public Protection() {
		setDefaultDisplayName("Protection");
		setDefaultFiftyConstant(-15);
		setDefaultThirtyConstant(-10);
		setDefaultFiftyModifier(16);
		setDefaultThirtyModifier(11);
		setDefaultFiftyMaxConstant(35);
		setDefaultThirtyMaxConstant(20);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(4);
		setDefaultThirtyMaxLevel(4);
		setDefaultWeight(Weight.COMMON);
	}

	@Override
	public String getName() {
		return "protection";
	}

	@Override
	public Enchantment getRelativeEnchantment() {
		return Enchantment.PROTECTION_ENVIRONMENTAL;
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
		return Arrays.asList(Enchantment.PROTECTION_PROJECTILE, Enchantment.PROTECTION_EXPLOSIONS, Enchantment.PROTECTION_FIRE);
	}

	@Override
	public String getDescription() {
		return "Reduces all damage, except damage from the Void, the /kill command, or hunger damage.";
	}

}
