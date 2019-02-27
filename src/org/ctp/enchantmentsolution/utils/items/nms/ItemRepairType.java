package org.ctp.enchantmentsolution.utils.items.nms;

import java.util.List;

import org.bukkit.Material;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.utils.items.nms.itemrepair.ItemRepair_v1_10;
import org.ctp.enchantmentsolution.utils.items.nms.itemrepair.ItemRepair_v1_11;
import org.ctp.enchantmentsolution.utils.items.nms.itemrepair.ItemRepair_v1_12;
import org.ctp.enchantmentsolution.utils.items.nms.itemrepair.ItemRepair_v1_9;

public interface ItemRepairType {
	public Material getMaterial();
	
	public List<Material> getRepairTypes();
	
	public static ItemRepairType getType(Material type) {
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
		case 3:
			return ItemRepair_v1_9.getType(type);
		case 4:
		case 5:
			return ItemRepair_v1_10.getType(type);
		case 6:
		case 7:
		case 8:
			return ItemRepair_v1_11.getType(type);
		case 9:
		case 10:
		case 11:
			return ItemRepair_v1_12.getType(type);
		}
		return null;
	}
	
	public static ItemRepairType[] getValues(){
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
		case 3:
			return ItemRepair_v1_9.values();
		case 4:
		case 5:
			return ItemRepair_v1_10.values();
		case 6:
		case 7:
		case 8:
			return ItemRepair_v1_11.values();
		case 9:
		case 10:
		case 11:
			return ItemRepair_v1_12.values();
		}
		return null;
	}
}
