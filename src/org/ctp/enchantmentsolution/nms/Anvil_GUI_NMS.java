package org.ctp.enchantmentsolution.nms;

import org.bukkit.entity.Player;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.inventory.Anvil;
import org.ctp.enchantmentsolution.inventory.ConfigInventory;
import org.ctp.enchantmentsolution.nms.anvil.AnvilGUI_v1_10_R1;
import org.ctp.enchantmentsolution.nms.anvil.AnvilGUI_v1_11_R1;
import org.ctp.enchantmentsolution.nms.anvil.AnvilGUI_v1_12_R1;
import org.ctp.enchantmentsolution.nms.anvil.AnvilGUI_v1_9_R1;
import org.ctp.enchantmentsolution.nms.anvil.AnvilGUI_v1_9_R2;

public class Anvil_GUI_NMS {

	public static void createAnvil(Player player, Anvil anvil) {
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
			AnvilGUI_v1_9_R1.createAnvil(player, anvil);
			break;
		case 3:
			AnvilGUI_v1_9_R2.createAnvil(player, anvil);
			break;
		case 4:
		case 5:
			AnvilGUI_v1_10_R1.createAnvil(player, anvil);
			break;
		case 6:
		case 7:
		case 8:
			AnvilGUI_v1_11_R1.createAnvil(player, anvil);
			break;
		case 9:
		case 10:
		case 11:
			AnvilGUI_v1_12_R1.createAnvil(player, anvil);
			break;
		}
	}
	
	public static void createAnvil(Player player, ConfigInventory anvil) {
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
			AnvilGUI_v1_9_R1.createAnvil(player, anvil);
			break;
		case 3:
			AnvilGUI_v1_9_R2.createAnvil(player, anvil);
			break;
		case 4:
		case 5:
			AnvilGUI_v1_10_R1.createAnvil(player, anvil);
			break;
		case 6:
		case 7:
		case 8:
			AnvilGUI_v1_11_R1.createAnvil(player, anvil);
			break;
		case 9:
		case 10:
		case 11:
			AnvilGUI_v1_12_R1.createAnvil(player, anvil);
			break;
		}
	}
}
