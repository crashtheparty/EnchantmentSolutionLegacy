package org.ctp.enchantmentsolution.enchantments.vanilla;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.ItemType;

public class Unbreaking extends CustomEnchantment{
	
	public Unbreaking() {
		setDefaultDisplayName("Unbreaking");
		setDefaultFiftyConstant(-10);
		setDefaultThirtyConstant(-3);
		setDefaultFiftyModifier(15);
		setDefaultThirtyModifier(8);
		setDefaultFiftyMaxConstant(40);
		setDefaultThirtyMaxConstant(50);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(5);
		setDefaultThirtyMaxLevel(3);
		setDefaultWeight(Weight.UNCOMMON);
		setDefaultDescription("Increases effective durability.");
	}
	
	@Override
	public Enchantment getRelativeEnchantment() {
		return Enchantment.DURABILITY;
	}
	
	@Override
	public String getName() {
		return "unbreaking";
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.TOOLS, ItemType.SWORDS, ItemType.ARMOR, ItemType.RANGED, ItemType.SHIELD);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.ALL);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList();
	}
}
