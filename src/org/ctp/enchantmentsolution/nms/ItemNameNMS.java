package org.ctp.enchantmentsolution.nms;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.api.Language;
import org.ctp.enchantmentsolution.nms.itemname.GermanNames_v1_9_to_12;
import org.ctp.enchantmentsolution.nms.itemname.ItemName_v1_10_R1;
import org.ctp.enchantmentsolution.nms.itemname.ItemName_v1_11_R1;
import org.ctp.enchantmentsolution.nms.itemname.ItemName_v1_12_R1;
import org.ctp.enchantmentsolution.nms.itemname.ItemName_v1_9_R1;
import org.ctp.enchantmentsolution.nms.itemname.ItemName_v1_9_R2;

public class ItemNameNMS {
	
	public static String returnLocalizedItemName(Language language, ItemStack item) {
		
		switch(language) {
		case GERMAN:
			return GermanNames_v1_9_to_12.getName(item.getType());
		case US:
			switch(EnchantmentSolution.getPlugin().getBukkitVersion().getVersionNumber()) {
			case 1:
			case 2:
				return ItemName_v1_9_R1.returnLocalizedItemName(item);
			case 3:
				return ItemName_v1_9_R2.returnLocalizedItemName(item);
			case 4:
			case 5:
				return ItemName_v1_10_R1.returnLocalizedItemName(item);
			case 6:
			case 7:
			case 8:
				return ItemName_v1_11_R1.returnLocalizedItemName(item);
			case 9:
			case 10:
			case 11:
				return ItemName_v1_12_R1.returnLocalizedItemName(item);
			}
		default: 
			break;
		}
		return item.toString();
	}
	
	public static String returnLocalizedItemName(Language language, Material material) {
		ItemStack item = new ItemStack(material);
		return returnLocalizedItemName(language, item);
	}
}
