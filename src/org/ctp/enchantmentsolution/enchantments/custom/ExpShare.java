package org.ctp.enchantmentsolution.enchantments.custom;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.api.Language;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.helper.Weight;
import org.ctp.enchantmentsolution.utils.items.nms.ItemType;

public class ExpShare extends CustomEnchantment{
	
	public ExpShare() {
		addDefaultDisplayName("Exp. Share");
		addDefaultDisplayName(Language.GERMAN, "Erfahrung");
		setDefaultFiftyConstant(0);
		setDefaultThirtyConstant(-2);
		setDefaultFiftyModifier(20);
		setDefaultThirtyModifier(12);
		setDefaultFiftyMaxConstant(40);
		setDefaultThirtyMaxConstant(40);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(3);
		setDefaultThirtyMaxLevel(3);
		setDefaultWeight(Weight.UNCOMMON);
		addDefaultDescription("Increase experience earned from killing mobs and breaking blocks.");
		addDefaultDescription(Language.GERMAN, "Erh�hen Sie die Erfahrung durch das T�ten von Mobs und Blockaden.");
	}
	
	@Override
	public Enchantment getRelativeEnchantment() {
		return DefaultEnchantments.EXP_SHARE;
	}

	@Override
	public String getName() {
		return "exp_share";
	}
	
	@Override
	protected List<ItemType> getEnchantmentItemTypes() {
		return Arrays.asList(ItemType.SWORDS, ItemType.TOOLS);
	}

	@Override
	protected List<ItemType> getAnvilItemTypes() {
		return Arrays.asList(ItemType.SWORDS, ItemType.TOOLS);
	}

	@Override
	protected List<Enchantment> getDefaultConflictingEnchantments() {
		return Arrays.asList();
	}

}
