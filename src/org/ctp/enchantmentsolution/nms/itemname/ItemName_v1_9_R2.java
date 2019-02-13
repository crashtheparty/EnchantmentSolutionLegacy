package org.ctp.enchantmentsolution.nms.itemname;

import org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class ItemName_v1_9_R2 {

	public static String returnLocalizedItemName(ItemStack item) {
		net.minecraft.server.v1_9_R2.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		return nmsItem.getName();
	}
}