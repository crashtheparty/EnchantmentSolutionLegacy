package org.ctp.enchantmentsolution.utils.items.nms;

import java.util.List;

import org.bukkit.Material;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.utils.items.nms.itemplace.ItemPlaceType_v1_10;
import org.ctp.enchantmentsolution.utils.items.nms.itemplace.ItemPlaceType_v1_11;
import org.ctp.enchantmentsolution.utils.items.nms.itemplace.ItemPlaceType_v1_12;
import org.ctp.enchantmentsolution.utils.items.nms.itemplace.ItemPlaceType_v1_9;

public interface ItemPlaceType {

	public List<Material> getItemPlaceTypes();
	
	public static List<Material> getPlaceTypes(){
		switch(EnchantmentSolution.getPlugin().getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
		case 3:
			return new ItemPlaceType_v1_9().getItemPlaceTypes();
		case 4:
		case 5:
			return new ItemPlaceType_v1_10().getItemPlaceTypes();
		case 6:
		case 7:
		case 8:
			return new ItemPlaceType_v1_11().getItemPlaceTypes();
		case 9:
		case 10:
		case 11:
			return new ItemPlaceType_v1_12().getItemPlaceTypes();
		}
		return null;
	}
}
