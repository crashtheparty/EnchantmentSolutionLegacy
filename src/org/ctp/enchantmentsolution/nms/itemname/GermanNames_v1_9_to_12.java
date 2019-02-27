package org.ctp.enchantmentsolution.nms.itemname;

import org.bukkit.Material;

public enum GermanNames_v1_9_to_12 {
	BOOK(Material.BOOK, "Buch"), BOW(Material.BOW, "BOGEN"), CARROT_ON_A_STICK(Material.CARROT_STICK, "Karottenrute"), 
	CHAINMAIL_BOOTS(Material.CHAINMAIL_BOOTS, "Kettenstiefel"), CHAINMAIL_CHESTPLATE(Material.CHAINMAIL_CHESTPLATE, "Kettenhemd"), 
	CHAINMAIL_HELMET(Material.CHAINMAIL_HELMET, "Kettenhaube"), CHAINMAIL_LEGGINGS(Material.CHAINMAIL_LEGGINGS, "Kettenhose"), 
	DIAMOND_AXE(Material.DIAMOND_AXE, "Diamantaxt"), DIAMOND_BOOTS(Material.DIAMOND_BOOTS, "Diamantstiefel"), 
	DIAMOND_CHESTPLATE(Material.DIAMOND_CHESTPLATE, "Diamantharnisch"), DIAMOND_HELMET(Material.DIAMOND_HELMET, "Diamanthelm"), 
	DIAMOND_HOE(Material.DIAMOND_HOE, "Diamanthacke"), DIAMOND_LEGGINGS(Material.DIAMOND_LEGGINGS, "Diamantbeinschutz"), 
	DIAMOND_PICKAXE(Material.DIAMOND_PICKAXE, "Diamantspitzhacke"), DIAMOND_SHOVEL(Material.DIAMOND_SPADE, "Diamantschaufel"), 
	DIAMOND_SWORD(Material.DIAMOND_SWORD, "Diamantschwert"), ELYTRA(Material.ELYTRA, "Elytren"), ENCHANTED_BOOK(Material.ENCHANTED_BOOK, "Verzaubertes Buch"),
	FISHING_ROD(Material.FISHING_ROD, "Angel"), FLINT_AND_STEEL(Material.FLINT_AND_STEEL, "Feuerzeug"), GOLDEN_AXE(Material.GOLD_AXE, "Goldaxt"), 
	GOLDEN_BOOTS(Material.GOLD_BOOTS, "Goldstiefel"), GOLDEN_CHESTPLATE(Material.GOLD_CHESTPLATE, "Goldharnisch"), GOLDEN_HELMET(Material.GOLD_HELMET, "Goldhelm"), 
	GOLDEN_HOE(Material.GOLD_HOE, "Goldhacke"), GOLDEN_LEGGINGS(Material.GOLD_LEGGINGS, "Goldbeinschutz"), GOLDEN_PICKAXE(Material.GOLD_PICKAXE, "Goldspitzhacke"),
	GOLDEN_SHOVEL(Material.GOLD_SPADE, "Goldschaufel"), GOLDEN_SWORD(Material.GOLD_SWORD, "Goldschwert"), IRON_AXE(Material.IRON_AXE, "Eisenaxt"), 
	IRON_BOOTS(Material.IRON_BOOTS, "Eisenstiefel"), IRON_CHESTPLATE(Material.IRON_CHESTPLATE, "Eisenharnisch"), IRON_HELMET(Material.IRON_HELMET, "Eisenhelm"), 
	IRON_HOE(Material.IRON_HOE, "Eisenhacke"), IRON_LEGGINGS(Material.IRON_LEGGINGS, "Eisenbeinschutz"), IRON_PICKAXE(Material.IRON_PICKAXE, "Eisenspitzhacke"), 
	IRON_SHOVEL(Material.IRON_SPADE, "Eisenschaufel"), IRON_SWORD(Material.IRON_SWORD, "Eisenschwert"), LEATHER_BOOTS(Material.LEATHER_BOOTS, "Lederstiefel"), 
	LEATHER_CHESTPLATE(Material.LEATHER_CHESTPLATE, "Lederjacke"), LEATHER_HELMET(Material.LEATHER_HELMET, "Lederkappe"), 
	LEATHER_LEGGINGS(Material.LEATHER_LEGGINGS, "Lederhose"), SHEARS(Material.SHEARS, "Schere"), SHIELD(Material.SHIELD, "Schild"), 
	STONE_AXE(Material.STONE_AXE, "Steinaxt"), STONE_HOE(Material.STONE_HOE, "Steinhacke"), STONE_PICKAXE(Material.STONE_PICKAXE, "Steinspitzhacke"),
	STONE_SHOVEL(Material.STONE_SPADE, "Steinschaufel"), STONE_SWORD(Material.STONE_SWORD, "Steinschwert"), 
	WOODEN_AXE(Material.WOOD_AXE, "Holzaxt"), WOODEN_HOE(Material.WOOD_HOE, "Holzhacke"), 
	WOODEN_PICKAXE(Material.WOOD_PICKAXE, "Holzspitzhacke"), WOODEN_SHOVEL(Material.WOOD_SPADE, "Holzschaufel"), WOODEN_SWORD(Material.WOOD_SWORD, "Holzschwert");
	
	private Material material;
	private String name;
	
	GermanNames_v1_9_to_12(Material mat, String name) {
		material = mat;
		this.name = name;
	}
	
	public static String getName(Material mat) {
		for(GermanNames_v1_9_to_12 name : values()) {
			if(name.getMaterial() == mat) {
				return name.getName();
			}
		}
		return null;
	}

	public Material getMaterial() {
		return material;
	}

	public String getName() {
		return name;
	}
}
