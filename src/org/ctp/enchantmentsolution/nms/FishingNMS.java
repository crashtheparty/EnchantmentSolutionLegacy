package org.ctp.enchantmentsolution.nms;

import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.nms.fishing.Fishing_v1_9_R2;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.nms.fishing.Fishing_v1_10_R1;
import org.ctp.enchantmentsolution.nms.fishing.Fishing_v1_11_R1;
import org.ctp.enchantmentsolution.nms.fishing.Fishing_v1_12_R1;
import org.ctp.enchantmentsolution.nms.fishing.Fishing_v1_9_R1;

public class FishingNMS {
	public static ItemStack replaceLoot(ItemStack i){
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
			return Fishing_v1_9_R1.enchantItem(i);
		case 3:
			return Fishing_v1_9_R2.enchantItem(i);
		case 4:
		case 5:
			return Fishing_v1_10_R1.enchantItem(i);
		case 6:
		case 7:
		case 8:
			return Fishing_v1_11_R1.enchantItem(i);
		case 9:
		case 10:
		case 11:
			return Fishing_v1_12_R1.enchantItem(i);
		}
		return i;
	}
}
