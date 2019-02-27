package org.ctp.enchantmentsolution.utils.items.nms.itemplace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.ctp.enchantmentsolution.utils.items.nms.ItemPlaceType;

public class ItemPlaceType_v1_9 implements ItemPlaceType{

	public List<Material> getItemPlaceTypes(){
		List<Material> itemTypes = new ArrayList<Material>();
		itemTypes.addAll(Arrays.asList(Material.IRON_BLOCK, Material.LAPIS_BLOCK, Material.IRON_ORE, Material.LAPIS_ORE, Material.DIAMOND_BLOCK, Material.EMERALD_BLOCK, 
				Material.GOLD_BLOCK, Material.DIAMOND_ORE, Material.EMERALD_ORE, Material.GOLD_ORE, Material.REDSTONE_ORE, Material.OBSIDIAN, Material.JACK_O_LANTERN, 
				Material.PUMPKIN, Material.MELON, Material.BOOKSHELF, 
				Material.LOG, Material.LOG_2, Material.WOOD, Material.HUGE_MUSHROOM_1, Material.HUGE_MUSHROOM_2, Material.ICE, Material.PACKED_ICE, 
				Material.FROSTED_ICE, Material.REDSTONE_BLOCK, Material.COAL_BLOCK, Material.QUARTZ_BLOCK, Material.BRICK, 
				Material.COAL_ORE, Material.COBBLESTONE, Material.ENDER_STONE, Material.END_BRICKS, Material.MOSSY_COBBLESTONE, 
				Material.COBBLE_WALL, Material.NETHER_BRICK, Material.NETHER_FENCE, Material.QUARTZ_ORE, Material.NETHERRACK, Material.PRISMARINE,
				Material.RED_SANDSTONE, Material.SANDSTONE, Material.STAINED_CLAY, Material.STONE, Material.SNOW_BLOCK, Material.MONSTER_EGGS, 
				Material.CLAY, Material.DIRT, Material.GRAVEL, 
				Material.SAND, Material.SOUL_SAND));
		return itemTypes;
	}
}
