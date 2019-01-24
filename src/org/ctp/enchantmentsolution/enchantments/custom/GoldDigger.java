package org.ctp.enchantmentsolution.enchantments.custom;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.ItemType;

public class GoldDigger extends CustomEnchantment{
	
	public GoldDigger() {
		setDefaultDisplayName("Gold Digger");
		setDefaultFiftyConstant(-2);
		setDefaultThirtyConstant(-10);
		setDefaultFiftyModifier(12);
		setDefaultThirtyModifier(11);
		setDefaultFiftyMaxConstant(19);
		setDefaultThirtyMaxConstant(20);
		setDefaultFiftyStartLevel(10);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(6);
		setDefaultThirtyMaxLevel(5);
		setDefaultWeight(Weight.COMMON);
		setDefaultDescription("Earn experience and gold nuggets for breaking crops.");
	}
	
	@Override
	public Enchantment getRelativeEnchantment() {
		return DefaultEnchantments.GOLD_DIGGER;
	}

	@Override
	public String getName() {
		return "gold_digger";
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.BOOK);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.HOES);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList();
	}

}
