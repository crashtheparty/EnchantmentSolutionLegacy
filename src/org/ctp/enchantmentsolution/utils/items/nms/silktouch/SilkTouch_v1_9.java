package org.ctp.enchantmentsolution.utils.items.nms.silktouch;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.utils.items.nms.ItemBreakType;

public class SilkTouch_v1_9 {
	@SuppressWarnings("deprecation")
	public static ItemStack getSilkTouchItem(Block block, ItemStack item){
		ItemBreakType type = ItemBreakType.getType(item.getType());
		switch(block.getType()) {
		case COAL_ORE:
		case QUARTZ_ORE:
		case STONE:
		case LAPIS_ORE:
		case EMERALD_ORE:
		case DIAMOND_ORE:
		case REDSTONE_ORE:
			if(type != null && type.getBreakTypes().contains(block.getType())) {
				return new ItemStack(block.getType());
			}
			break;
		case MONSTER_EGGS:
			if(type != null && type.getBreakTypes().contains(block.getType())) {
				if(block.getData() == 0) {
					return new ItemStack(Material.STONE);
				}
				if(block.getData() == 1) {
					return new ItemStack(Material.COBBLESTONE);
				}
				if(block.getData() >= 2 && block.getData() <= 5) {
					return new ItemStack(Material.SMOOTH_BRICK, 1, (byte) (block.getData() - 2));
				}
			}
			return null;
		case BOOKSHELF:
		case CLAY:
		case ENDER_CHEST:
		case GLASS:
		case THIN_GLASS:
		case GLOWSTONE:
		case GRASS:
		case MYCEL:
		case HUGE_MUSHROOM_1:
		case HUGE_MUSHROOM_2:
		case MELON_BLOCK:
		case SEA_LANTERN:
		case ICE:
		case PACKED_ICE:
		case SNOW_BLOCK:
			return new ItemStack(block.getType());
		case STAINED_GLASS:
		case STAINED_GLASS_PANE:
			return new ItemStack(block.getType(), 1, block.getData());
		case LEAVES:
		case LEAVES_2:
			return new ItemStack(block.getType(), 1, (byte)(block.getData() % 4));
		case DIRT:
			if(block.getData() == 2) {
				return new ItemStack(block.getType(), 1, block.getData());
			}
		default:
			break;
		}
		return null;
	}
}
