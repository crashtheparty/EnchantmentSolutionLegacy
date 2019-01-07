package org.ctp.enchantmentsolution.utils.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;

public enum ItemRepairType {
	DIAMOND_AXE(Material.DIAMOND_AXE), DIAMOND_SWORD(Material.DIAMOND_SWORD), DIAMOND_SHOVEL(Material.DIAMOND_SPADE), DIAMOND_PICKAXE(Material.DIAMOND_PICKAXE), 
	DIAMOND_HOE(Material.DIAMOND_HOE), DIAMOND_HELMET(Material.DIAMOND_HELMET), DIAMOND_CHESTPLATE(Material.DIAMOND_CHESTPLATE), 
	DIAMOND_LEGGINGS(Material.DIAMOND_LEGGINGS), DIAMOND_BOOTS(Material.DIAMOND_BOOTS), IRON_AXE(Material.IRON_AXE), IRON_SWORD(Material.IRON_SWORD), 
	IRON_SHOVEL(Material.IRON_SPADE), IRON_PICKAXE(Material.IRON_PICKAXE), IRON_HOE(Material.IRON_HOE), IRON_HELMET(Material.IRON_HELMET), 
	IRON_CHESTPLATE(Material.IRON_CHESTPLATE), IRON_LEGGINGS(Material.IRON_LEGGINGS), IRON_BOOTS(Material.IRON_BOOTS), GOLDEN_AXE(Material.GOLD_AXE), 
	GOLDEN_SWORD(Material.GOLD_SWORD), GOLDEN_SHOVEL(Material.GOLD_SPADE), GOLDEN_PICKAXE(Material.GOLD_PICKAXE), GOLDEN_HOE(Material.GOLD_HOE), 
	GOLDEN_HELMET(Material.GOLD_HELMET), GOLDEN_CHESTPLATE(Material.GOLD_CHESTPLATE), GOLDEN_LEGGINGS(Material.GOLD_LEGGINGS), 
	GOLDEN_BOOTS(Material.GOLD_BOOTS), STONE_AXE(Material.STONE_AXE), STONE_SWORD(Material.STONE_SWORD), STONE_SHOVEL(Material.STONE_SPADE), 
	STONE_PICKAXE(Material.STONE_PICKAXE), STONE_HOE(Material.STONE_HOE), CHAINMAIL_HELMET(Material.CHAINMAIL_HELMET), 
	CHAINMAIL_CHESTPLATE(Material.CHAINMAIL_CHESTPLATE), CHAINMAIL_LEGGINGS(Material.CHAINMAIL_LEGGINGS), CHAINMAIL_BOOTS(Material.CHAINMAIL_BOOTS),
	WOODEN_AXE(Material.WOOD_AXE), WOODEN_SWORD(Material.WOOD_SWORD), WOODEN_SHOVEL(Material.WOOD_SPADE), WOODEN_PICKAXE(Material.WOOD_PICKAXE), 
	WOODEN_HOE(Material.WOOD_HOE), LEATHER_HELMET(Material.LEATHER_HELMET), LEATHER_CHESTPLATE(Material.LEATHER_CHESTPLATE), 
	LEATHER_LEGGINGS(Material.LEATHER_LEGGINGS), LEATHER_BOOTS(Material.LEATHER_BOOTS), ELYTRA(Material.ELYTRA), BOW(Material.BOW), FISHING_ROD(Material.FISHING_ROD), 
	BOOK(Material.BOOK), ENCHANTED_BOOK(Material.ENCHANTED_BOOK), SHEARS(Material.SHEARS), FLINT_AND_STEEL(Material.FLINT_AND_STEEL),
	SHIELD(Material.SHIELD);
	
	private Material material;
	private List<Material> repairTypes;
	
	ItemRepairType(Material material){
		this.material = material;
		this.repairTypes = getItemRepairTypes(material);
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public List<Material> getRepairTypes(){
		return repairTypes;
	}
	
	public static ItemRepairType getType(Material type) {
		for(ItemRepairType repairType : ItemRepairType.values()) {
			if(repairType.getMaterial().equals(type)) {
				return repairType;
			}
		}
		return null;
	}
	
	private List<Material> getItemRepairTypes(Material type){
		List<Material> itemTypes = new ArrayList<Material>();
		switch(type) {
		case BOOK:
			itemTypes.addAll(Arrays.asList(Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case BOW:
			itemTypes.addAll(Arrays.asList(Material.BOW, Material.STRING, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case CHAINMAIL_BOOTS:
			itemTypes.addAll(Arrays.asList(Material.CHAINMAIL_BOOTS, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case CHAINMAIL_CHESTPLATE:
			itemTypes.addAll(Arrays.asList(Material.CHAINMAIL_CHESTPLATE, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case CHAINMAIL_HELMET:
			itemTypes.addAll(Arrays.asList(Material.CHAINMAIL_HELMET, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case CHAINMAIL_LEGGINGS:
			itemTypes.addAll(Arrays.asList(Material.CHAINMAIL_LEGGINGS, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_AXE:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_AXE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_BOOTS:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_BOOTS, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_CHESTPLATE:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_CHESTPLATE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_HELMET:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_HELMET, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_HOE:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_HOE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_LEGGINGS:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_LEGGINGS, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_PICKAXE:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_PICKAXE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_SPADE:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_SPADE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case DIAMOND_SWORD:
			itemTypes.addAll(Arrays.asList(Material.DIAMOND_SWORD, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case ELYTRA:
			itemTypes.addAll(Arrays.asList(Material.ELYTRA, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case ENCHANTED_BOOK:
			itemTypes.addAll(Arrays.asList(Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case FISHING_ROD:
			itemTypes.addAll(Arrays.asList(Material.FISHING_ROD, Material.STRING, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case FLINT_AND_STEEL:
			itemTypes.addAll(Arrays.asList(Material.FLINT_AND_STEEL, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_AXE:
			itemTypes.addAll(Arrays.asList(Material.GOLD_AXE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_BOOTS:
			itemTypes.addAll(Arrays.asList(Material.GOLD_BOOTS, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_CHESTPLATE:
			itemTypes.addAll(Arrays.asList(Material.GOLD_CHESTPLATE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_HELMET:
			itemTypes.addAll(Arrays.asList(Material.GOLD_HELMET, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_HOE:
			itemTypes.addAll(Arrays.asList(Material.GOLD_HOE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_LEGGINGS:
			itemTypes.addAll(Arrays.asList(Material.GOLD_LEGGINGS, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_PICKAXE:
			itemTypes.addAll(Arrays.asList(Material.GOLD_PICKAXE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_SPADE:
			itemTypes.addAll(Arrays.asList(Material.GOLD_SPADE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case GOLD_SWORD:
			itemTypes.addAll(Arrays.asList(Material.GOLD_SWORD, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_AXE:
			itemTypes.addAll(Arrays.asList(Material.IRON_AXE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_BOOTS:
			itemTypes.addAll(Arrays.asList(Material.IRON_BOOTS, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_CHESTPLATE:
			itemTypes.addAll(Arrays.asList(Material.IRON_CHESTPLATE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_HELMET:
			itemTypes.addAll(Arrays.asList(Material.IRON_HELMET, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_HOE:
			itemTypes.addAll(Arrays.asList(Material.IRON_HOE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_LEGGINGS:
			itemTypes.addAll(Arrays.asList(Material.IRON_LEGGINGS, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_PICKAXE:
			itemTypes.addAll(Arrays.asList(Material.IRON_PICKAXE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_SPADE:
			itemTypes.addAll(Arrays.asList(Material.IRON_SPADE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case IRON_SWORD:
			itemTypes.addAll(Arrays.asList(Material.IRON_SWORD, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case LEATHER_BOOTS:
			itemTypes.addAll(Arrays.asList(Material.LEATHER_BOOTS, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case LEATHER_CHESTPLATE:
			itemTypes.addAll(Arrays.asList(Material.LEATHER_CHESTPLATE, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case LEATHER_HELMET:
			itemTypes.addAll(Arrays.asList(Material.LEATHER_HELMET, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case LEATHER_LEGGINGS:
			itemTypes.addAll(Arrays.asList(Material.LEATHER_LEGGINGS, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case SHEARS:
			itemTypes.addAll(Arrays.asList(Material.SHEARS, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case SHIELD:
			itemTypes.addAll(Arrays.asList(Material.SHIELD, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case STONE_AXE:
			itemTypes.addAll(Arrays.asList(Material.STONE_AXE, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case STONE_HOE:
			itemTypes.addAll(Arrays.asList(Material.STONE_HOE, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case STONE_PICKAXE:
			itemTypes.addAll(Arrays.asList(Material.STONE_PICKAXE, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case STONE_SPADE:
			itemTypes.addAll(Arrays.asList(Material.STONE_SPADE, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case STONE_SWORD:
			itemTypes.addAll(Arrays.asList(Material.STONE_SWORD, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case WOOD_AXE:
			itemTypes.addAll(Arrays.asList(Material.WOOD_AXE, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case WOOD_HOE:
			itemTypes.addAll(Arrays.asList(Material.WOOD_HOE, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case WOOD_PICKAXE:
			itemTypes.addAll(Arrays.asList(Material.WOOD_PICKAXE, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case WOOD_SPADE:
			itemTypes.addAll(Arrays.asList(Material.WOOD_SPADE, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		case WOOD_SWORD:
			itemTypes.addAll(Arrays.asList(Material.WOOD_SWORD, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
			return itemTypes;
		default:
			break;
		}
		return null;
	}
	
}
