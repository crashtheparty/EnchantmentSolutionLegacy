package org.ctp.enchantmentsolution.enchantments.custom;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.ItemType;

public class IronDefense extends CustomEnchantment{

	public IronDefense() {
		setDefaultDisplayName("Iron Defense");
		setDefaultFiftyConstant(7);
		setDefaultThirtyConstant(6);
		setDefaultFiftyModifier(11);
		setDefaultThirtyModifier(9);
		setDefaultFiftyMaxConstant(40);
		setDefaultThirtyMaxConstant(50);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(5);
		setDefaultThirtyMaxLevel(3);
		setDefaultWeight(Weight.RARE);
	}
	
	@Override
	public String getName() {
		return "iron_defense";
	}

	@Override
	public Enchantment getRelativeEnchantment() {
		return DefaultEnchantments.IRON_DEFENSE;
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.SHIELD);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.SHIELD);
	}

	@Override
	public String getDescription() {
		return "Having the shield equipped will redirect damage to the shield.";
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList(DefaultEnchantments.HARD_BOUNCE);
	}

}
