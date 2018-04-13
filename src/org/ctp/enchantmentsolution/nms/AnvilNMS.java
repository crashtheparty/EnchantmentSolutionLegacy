package org.ctp.enchantmentsolution.nms;

import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.nms.anvil.Anvil_v1_10_R1;
import org.ctp.enchantmentsolution.nms.anvil.Anvil_v1_11_R1;
import org.ctp.enchantmentsolution.nms.anvil.Anvil_v1_12_R1;
import org.ctp.enchantmentsolution.nms.anvil.Anvil_v1_9_R1;
import org.ctp.enchantmentsolution.nms.anvil.Anvil_v1_9_R2;

public class AnvilNMS {

	public static int getRepairCost(ItemStack item) {
		if(item == null) {
			return 0;
		}
		switch(Version.VERSION_NUMBER) {
		case 1:
		case 2:
			return Anvil_v1_9_R1.getRepairCost(item);
		case 3:
			return Anvil_v1_9_R2.getRepairCost(item);
		case 4:
		case 5:
			return Anvil_v1_10_R1.getRepairCost(item);
		case 6:
		case 7:
		case 8:
			return Anvil_v1_11_R1.getRepairCost(item);
		case 9:
		case 10:
		case 11:
			return Anvil_v1_12_R1.getRepairCost(item);
		}
		return 0;
	}
	
	public static ItemStack setRepairCost(ItemStack item, int repairCost) {
		switch(Version.VERSION_NUMBER) {
		case 1:
		case 2:
			return Anvil_v1_9_R1.setRepairCost(item, repairCost);
		case 3:
			return Anvil_v1_9_R2.setRepairCost(item, repairCost);
		case 4:
		case 5:
			return Anvil_v1_10_R1.setRepairCost(item, repairCost);
		case 6:
		case 7:
		case 8:
			return Anvil_v1_11_R1.setRepairCost(item, repairCost);
		case 9:
		case 10:
		case 11:
			return Anvil_v1_12_R1.setRepairCost(item, repairCost);
		}
		return item;
	}
}
