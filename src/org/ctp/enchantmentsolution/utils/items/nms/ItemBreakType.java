package org.ctp.enchantmentsolution.utils.items.nms;

import java.util.List;

import org.bukkit.Material;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.utils.items.nms.itembreak.ItemBreak_v1_10;
import org.ctp.enchantmentsolution.utils.items.nms.itembreak.ItemBreak_v1_11;
import org.ctp.enchantmentsolution.utils.items.nms.itembreak.ItemBreak_v1_12;
import org.ctp.enchantmentsolution.utils.items.nms.itembreak.ItemBreak_v1_9;

public interface ItemBreakType {
	public Material getMaterial();
	
	public List<Material> getBreakTypes();
	
	public static ItemBreakType getType(Material type) {
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
		case 3:
			return ItemBreak_v1_9.getType(type);
		case 4:
		case 5:
			return ItemBreak_v1_10.getType(type);
		case 6:
		case 7:
		case 8:
			return ItemBreak_v1_11.getType(type);
		case 9:
		case 10:
		case 11:
			return ItemBreak_v1_12.getType(type);
		}
		return null;
	}
	
	public static List<Material> allBreakTypes(){
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
		case 3:
			return ItemBreak_v1_9.allBreakTypes();
		case 4:
		case 5:
			return ItemBreak_v1_10.allBreakTypes();
		case 6:
		case 7:
		case 8:
			return ItemBreak_v1_11.allBreakTypes();
		case 9:
		case 10:
		case 11:
			return ItemBreak_v1_12.allBreakTypes();
		}
		return null;
	}
}
