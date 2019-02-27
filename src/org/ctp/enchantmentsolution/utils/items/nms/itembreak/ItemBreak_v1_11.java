package org.ctp.enchantmentsolution.utils.items.nms.itembreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.ctp.enchantmentsolution.utils.items.nms.ItemBreakType;

public enum ItemBreak_v1_11 implements ItemBreakType{
	DIAMOND_AXE(Material.DIAMOND_AXE), DIAMOND_SHOVEL(Material.DIAMOND_SPADE), DIAMOND_PICKAXE(Material.DIAMOND_PICKAXE), 
	IRON_AXE(Material.IRON_AXE), IRON_SHOVEL(Material.IRON_SPADE), IRON_PICKAXE(Material.IRON_PICKAXE), 
	GOLDEN_AXE(Material.GOLD_AXE), GOLDEN_SHOVEL(Material.GOLD_SPADE), GOLDEN_PICKAXE(Material.GOLD_PICKAXE), 
	STONE_AXE(Material.STONE_AXE), STONE_SHOVEL(Material.STONE_SPADE), STONE_PICKAXE(Material.STONE_PICKAXE), 
	WOODEN_AXE(Material.WOOD_AXE), WOODEN_SHOVEL(Material.WOOD_SPADE), WOODEN_PICKAXE(Material.WOOD_PICKAXE);
	
	private Material material;
	private List<Material> breakTypes;
	
	ItemBreak_v1_11(Material material) {
		this.material = material;
		this.breakTypes = getItemBreakTypes(material);
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public List<Material> getBreakTypes(){
		return breakTypes;
	}
	
	public static ItemBreak_v1_9 getType(Material type) {
		for(ItemBreak_v1_9 breakType : ItemBreak_v1_9.values()) {
			if(breakType.getMaterial().equals(type)) {
				return breakType;
			}
		}
		return null;
	}
	
	public static List<Material> allBreakTypes(){
		List<Material> itemTypes = new ArrayList<Material>();
		for(ItemBreak_v1_9 type : ItemBreak_v1_9.values()) {
			itemTypes.addAll(type.getBreakTypes());
		}
		return itemTypes;
	}
	
	private List<Material> getItemBreakTypes(Material type){
		List<Material> itemTypes = new ArrayList<Material>();
		switch(type) {
		case DIAMOND_PICKAXE:
			itemTypes.addAll(getItemBreakTypes(Material.IRON_PICKAXE));
			itemTypes.addAll(Arrays.asList(Material.OBSIDIAN));
			return itemTypes;
		case GOLD_PICKAXE:
			itemTypes.addAll(getItemBreakTypes(Material.WOOD_PICKAXE));
			return itemTypes;
		case IRON_PICKAXE:
			itemTypes.addAll(getItemBreakTypes(Material.STONE_PICKAXE));
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_BLOCK, Material.EMERALD_BLOCK, Material.GOLD_BLOCK, Material.DIAMOND_ORE,
					Material.EMERALD_ORE, Material.GOLD_ORE, Material.REDSTONE_ORE));
			return itemTypes;
		case STONE_PICKAXE:
			itemTypes.addAll(getItemBreakTypes(Material.WOOD_PICKAXE));
			itemTypes.addAll(Arrays.asList(Material.IRON_BLOCK, Material.LAPIS_BLOCK, Material.IRON_ORE, Material.LAPIS_ORE));
			return itemTypes;
		case DIAMOND_AXE:
		case GOLD_AXE:
		case IRON_AXE:
		case STONE_AXE:
		case WOOD_AXE:
			itemTypes.addAll(Arrays.asList(Material.COCOA, Material.JACK_O_LANTERN, Material.PUMPKIN, Material.MELON, Material.BOOKSHELF, 
					Material.ACACIA_FENCE, Material.ACACIA_FENCE_GATE, Material.BIRCH_FENCE, Material.BIRCH_FENCE_GATE, Material.DARK_OAK_FENCE, 
					Material.DARK_OAK_FENCE_GATE, Material.JUNGLE_FENCE, Material.JUNGLE_FENCE_GATE, Material.FENCE, Material.FENCE_GATE, 
					Material.SPRUCE_FENCE, Material.SPRUCE_FENCE_GATE, Material.LOG, Material.LOG_2, Material.WOOD, Material.HUGE_MUSHROOM_1, 
					Material.HUGE_MUSHROOM_2, Material.LADDER));
			return itemTypes;
		case WOOD_PICKAXE:
			itemTypes.addAll(Arrays.asList(Material.ICE, Material.PACKED_ICE, Material.FROSTED_ICE, Material.REDSTONE_BLOCK, Material.IRON_BARDING, 
					Material.ACTIVATOR_RAIL, Material.DETECTOR_RAIL, Material.POWERED_RAIL, Material.RAILS, Material.COAL_BLOCK, 
					Material.QUARTZ_BLOCK, Material.BRICK, Material.COAL_ORE, Material.COBBLESTONE, Material.COBBLE_WALL, 
					Material.ENDER_STONE, Material.MOSSY_COBBLESTONE, 
					Material.MOSSY_COBBLESTONE, Material.NETHER_BRICK, Material.NETHER_FENCE, Material.QUARTZ_ORE, Material.NETHERRACK, 
					Material.PRISMARINE, Material.RED_SANDSTONE, Material.SANDSTONE, Material.HARD_CLAY, Material.STAINED_CLAY, Material.STONE, 
					Material.MONSTER_EGGS));
			return itemTypes;
		case DIAMOND_SPADE:
		case IRON_SPADE:
		case GOLD_SPADE:
		case STONE_SPADE:
		case WOOD_SPADE:
			itemTypes.addAll(Arrays.asList(Material.CLAY, Material.DIRT, Material.GRASS, Material.GRAVEL, 
					Material.SAND, Material.SOUL_SAND));
			return itemTypes;
		default:
			break;
		}
		return null;
	}
}
