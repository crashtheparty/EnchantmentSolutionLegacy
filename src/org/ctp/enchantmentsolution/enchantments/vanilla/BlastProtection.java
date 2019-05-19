package org.ctp.enchantmentsolution.enchantments.vanilla;

import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.ctp.enchantmentsolution.api.Language;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.helper.Weight;
import org.ctp.enchantmentsolution.utils.ConfigUtils;
import org.ctp.enchantmentsolution.utils.items.nms.ItemType;

public class BlastProtection extends CustomEnchantment{
	
	public BlastProtection() {
		addDefaultDisplayName("Blast Protection");
		addDefaultDisplayName(Language.GERMAN, "Explosionsshutz");
		setDefaultFiftyConstant(-8);
		setDefaultThirtyConstant(-3);
		setDefaultFiftyModifier(14);
		setDefaultThirtyModifier(8);
		setDefaultFiftyStartLevel(1);
		setDefaultThirtyStartLevel(1);
		setDefaultFiftyMaxLevel(4);
		setDefaultThirtyMaxLevel(4);
		setDefaultWeight(Weight.RARE);
		addDefaultDescription("Reduces explosion damage." + 
				"\n" + 
				"Also reduces explosion knockback by (15 � level)%. If multiple pieces have the enchantment, only the highest level's reduction is used.");
		addDefaultDescription(Language.GERMAN, "Reduziert Explosionssch�den. " + 
				"\n" + 
				"Verringert au�erdem den Explosionsr�ckschlag um (15 � Level)%. Wenn mehrere Teile die Verzauberung besitzen, " + 
				"wird nur die Reduzierung der h�chsten Stufe verwendet.");
	}
	
	@Override
	public String getName() {
		return "blast_protection";
	}

	@Override
	public Enchantment getRelativeEnchantment() {
		return Enchantment.PROTECTION_EXPLOSIONS;
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
		if(!ConfigUtils.getProtectionConflicts()) return Arrays.asList();
		return Arrays.asList(Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.PROTECTION_FIRE, Enchantment.PROTECTION_PROJECTILE);
	}
}
