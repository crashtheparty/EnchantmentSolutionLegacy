package org.ctp.enchantmentsolution.enchantments.vanilla;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.ItemType;

public class FeatherFalling extends CustomEnchantment{
	
	public FeatherFalling() {
		setDefaultDisplayName("Feather Falling");
		setDefaultFiftyConstant(-7);
		setDefaultThirtyConstant(-1);
		setDefaultFiftyModifier(12);
		setDefaultThirtyModifier(6);
		setDefaultFiftyMaxConstant(18);
		setDefaultThirtyMaxConstant(10);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(4);
		setDefaultThirtyMaxLevel(4);
		setDefaultWeight(Weight.UNCOMMON);
		setDefaultDescription("Reduces fall damage.");
	}

	@Override
	public String getName() {
		return "feather_falling";
	}
	
	@Override
	public Enchantment getRelativeEnchantment() {
		return Enchantment.PROTECTION_FALL;
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.BOOTS);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.BOOTS);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList();
	}
}
