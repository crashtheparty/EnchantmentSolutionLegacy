package org.ctp.enchantmentsolution.enchantments.vanilla;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.ItemType;

public class Power extends CustomEnchantment{
	
	public Power() {
		setDefaultDisplayName("Power");
		setDefaultFiftyConstant(-10);
		setDefaultThirtyConstant(-9);
		setDefaultFiftyModifier(11);
		setDefaultThirtyModifier(10);
		setDefaultFiftyMaxConstant(25);
		setDefaultThirtyMaxConstant(15);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(6);
		setDefaultThirtyMaxLevel(5);
		setDefaultWeight(Weight.COMMON);
	}
	
	@Override
	public Enchantment getRelativeEnchantment() {
		return Enchantment.ARROW_DAMAGE;
	}

	@Override
	public String getName() {
		return "power";
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.BOW);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.BOW);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList();
	}

	@Override
	public String getDescription() {
		return "Increases arrow damage by 25% � (level + 1), rounded up to nearest half-heart.";
	}

}
