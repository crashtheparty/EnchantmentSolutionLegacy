package org.ctp.enchantmentsolution.enchantments.vanilla;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Weight;
import org.ctp.enchantmentsolution.utils.items.ItemType;

public class AquaAffinity extends CustomEnchantment{

	public AquaAffinity() {
		setDefaultDisplayName("Aqua Affinity");
		setDefaultFiftyConstant(15);
		setDefaultThirtyConstant(1);
		setDefaultFiftyModifier(0);
		setDefaultThirtyModifier(0);
		setDefaultFiftyMaxConstant(60);
		setDefaultThirtyMaxConstant(40);
		setDefaultFiftyStartLevel(15);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(1);
		setDefaultThirtyMaxLevel(1);
		setDefaultWeight(Weight.RARE);
		setMaxLevelOne(true);
	}
	
	@Override
	public String getName() {
		return "aqua_affinity";
	}

	@Override
	public Enchantment getRelativeEnchantment() {
		return Enchantment.WATER_WORKER;
	}
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.HELMETS);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.HELMETS);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList();
	}

	@Override
	public String getDescription() {
		return "Increases underwater mining rate.";
	}
}