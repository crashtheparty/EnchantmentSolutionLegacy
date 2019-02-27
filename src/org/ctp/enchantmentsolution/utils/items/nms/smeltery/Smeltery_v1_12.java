package org.ctp.enchantmentsolution.utils.items.nms.smeltery;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.utils.items.nms.ItemBreakType;

public class Smeltery_v1_12 {
	@SuppressWarnings("deprecation")
	public static ItemStack getSmelteryItem(Block block, ItemStack item) {
		Material material = null;
		int data = 0;
		boolean fortune = false;
		ItemBreakType type = ItemBreakType.getType(item.getType());
		switch(block.getType()) {
		case IRON_ORE:
			if(type != null && type.getBreakTypes().contains(block.getType())) {
				material = Material.IRON_INGOT;
				fortune = true;
			}
			break;
		case GOLD_ORE:
			if(type != null && type.getBreakTypes().contains(block.getType())) {
				material = Material.GOLD_INGOT;
				fortune = true;
			}
			break;
		case SAND:
			material = Material.GLASS;
			break;
		case COBBLESTONE:
		case STONE:
			if(type != null && type.getBreakTypes().contains(block.getType())) {
				if(block.getData() == 0) {
					material = Material.STONE;
				}
			}
			break;
		case SMOOTH_BRICK:
			if(type != null && type.getBreakTypes().contains(block.getType())) {
				if(block.getData() == 0) {
					material = Material.SMOOTH_BRICK;
					data = 2;
				}
			}
			break;
		case NETHERRACK:
			if(type != null && type.getBreakTypes().contains(block.getType())) {
				material = Material.NETHER_BRICK_ITEM;
			}
			break;
		case CLAY:
			material = Material.HARD_CLAY;
			break;
		case CACTUS:
			material = Material.INK_SACK;
			data = 2;
			break;
		case LOG:
		case LOG_2:
			material = Material.COAL;
			data = 1;
			break;
		case CHORUS_FRUIT:
			material = Material.CHORUS_FRUIT_POPPED;
			break;
		case SPONGE:
			if(block.getData() == 1) {
				material = Material.SPONGE;
			}
			break;
		default:
			
		}
		int num = 1;
		if(fortune && Enchantments.hasEnchantment(item, Enchantment.LOOT_BONUS_BLOCKS)) {
			int level = Enchantments.getLevel(item,
					Enchantment.LOOT_BONUS_BLOCKS) + 2;
			int multiply = (int) (Math.random() * level);
			if(multiply > 1) {
				num *= multiply;
			}
		}
		if(material != null) {
			return new ItemStack(material, num, (byte) data);
		}
		return null;
	}
}
