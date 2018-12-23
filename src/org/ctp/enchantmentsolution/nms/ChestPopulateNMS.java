package org.ctp.enchantmentsolution.nms;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.ctp.enchantmentsolution.nms.chest.ChestPopulate_v1_10_R1;
import org.ctp.enchantmentsolution.nms.chest.ChestPopulate_v1_11_R1;
import org.ctp.enchantmentsolution.nms.chest.ChestPopulate_v1_12_R1;
import org.ctp.enchantmentsolution.nms.chest.ChestPopulate_v1_9_R1;
import org.ctp.enchantmentsolution.nms.chest.ChestPopulate_v1_9_R2;

public class ChestPopulateNMS {
	public static void populateChest(Block block) {
		switch(Version.VERSION_NUMBER) {
		case 1:
		case 2:
			ChestPopulate_v1_9_R1.populateChest(block);
		case 3:
			ChestPopulate_v1_9_R2.populateChest(block);
		case 4:
		case 5:
			ChestPopulate_v1_10_R1.populateChest(block);
		case 6:
		case 7:
		case 8:
			ChestPopulate_v1_11_R1.populateChest(block);
		case 9:
		case 10:
		case 11:
			ChestPopulate_v1_12_R1.populateChest(block);
		}
	}
	
	public static boolean isLootChest(Block block) {
		switch(Version.VERSION_NUMBER) {
		case 1:
		case 2:
			return ChestPopulate_v1_9_R1.isLootChest(block);
		case 3:
			return ChestPopulate_v1_9_R2.isLootChest(block);
		case 4:
		case 5:
			return ChestPopulate_v1_10_R1.isLootChest(block);
		case 6:
		case 7:
		case 8:
			return ChestPopulate_v1_11_R1.isLootChest(block);
		case 9:
		case 10:
		case 11:
			return ChestPopulate_v1_12_R1.isLootChest(block);
		}
		return false;
	}
	
	public static void populateCart(Entity e) {
		switch(Version.VERSION_NUMBER) {
		case 1:
		case 2:
			ChestPopulate_v1_9_R1.populateCart(e);
		case 3:
			ChestPopulate_v1_9_R2.populateCart(e);
		case 4:
		case 5:
			ChestPopulate_v1_10_R1.populateCart(e);
		case 6:
		case 7:
		case 8:
			ChestPopulate_v1_11_R1.populateCart(e);
		case 9:
		case 10:
		case 11:
			ChestPopulate_v1_12_R1.populateCart(e);
		}
	}
	
	public static boolean isLootCart(Entity e) {
		switch(Version.VERSION_NUMBER) {
		case 1:
		case 2:
			return ChestPopulate_v1_9_R1.isLootCart(e);
		case 3:
			return ChestPopulate_v1_9_R2.isLootCart(e);
		case 4:
		case 5:
			return ChestPopulate_v1_10_R1.isLootCart(e);
		case 6:
		case 7:
		case 8:
			return ChestPopulate_v1_11_R1.isLootCart(e);
		case 9:
		case 10:
		case 11:
			return ChestPopulate_v1_12_R1.isLootCart(e);
		}
		return false;
	}
}
