package org.ctp.enchantmentsolution.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.ctp.enchantmentsolution.enchantments.EnchantmentLevel;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.enchantments.PlayerLevels;
import org.ctp.enchantmentsolution.utils.AnvilUtils.RepairType;

public class ItemUtils {
	
	private static HashMap<String, List<Material>> ITEM_TYPES = setItemTypes();
	private static HashMap<Material, List<Material>> REPAIR_TYPES = setRepairTypes();
	private static List<Material> REPAIR_MATERIALS = Arrays.asList(Material.DIAMOND, Material.IRON_INGOT, Material.GOLD_INGOT, Material.COBBLESTONE, Material.WOOD, Material.LEATHER, Material.STRING);

	private static HashMap<String, List<Material>> setItemTypes() {
		HashMap<String, List<Material>> itemTypes = new HashMap<String, List<Material>>();
		List<Material> helmets = new ArrayList<Material>();
		helmets.addAll(Arrays.asList(Material.DIAMOND_HELMET,
				Material.CHAINMAIL_HELMET, Material.GOLD_HELMET,
				Material.IRON_HELMET, Material.LEATHER_HELMET));
		itemTypes.put("helmets", helmets);

		List<Material> chestplates = new ArrayList<Material>();
		chestplates.addAll(Arrays.asList(Material.DIAMOND_CHESTPLATE,
				Material.CHAINMAIL_CHESTPLATE, Material.GOLD_CHESTPLATE,
				Material.IRON_CHESTPLATE, Material.LEATHER_CHESTPLATE));
		itemTypes.put("chestplates", chestplates);

		List<Material> leggings = new ArrayList<Material>();
		leggings.addAll(Arrays.asList(Material.DIAMOND_LEGGINGS,
				Material.CHAINMAIL_LEGGINGS, Material.GOLD_LEGGINGS,
				Material.IRON_LEGGINGS, Material.LEATHER_LEGGINGS));
		itemTypes.put("leggings", leggings);

		List<Material> boots = new ArrayList<Material>();
		boots.addAll(Arrays.asList(Material.DIAMOND_BOOTS,
				Material.CHAINMAIL_BOOTS, Material.GOLD_BOOTS,
				Material.IRON_BOOTS, Material.LEATHER_BOOTS));
		itemTypes.put("boots", boots);

		List<Material> swords = new ArrayList<Material>();
		swords.addAll(Arrays.asList(Material.DIAMOND_SWORD,
				Material.GOLD_SWORD, Material.IRON_SWORD, Material.STONE_SWORD,
				Material.WOOD_SWORD));
		itemTypes.put("swords", swords);

		List<Material> pickaxes = new ArrayList<Material>();
		pickaxes.addAll(Arrays.asList(Material.DIAMOND_PICKAXE,
				Material.GOLD_PICKAXE, Material.IRON_PICKAXE,
				Material.STONE_PICKAXE, Material.WOOD_PICKAXE));
		itemTypes.put("pickaxes", pickaxes);

		List<Material> shovels = new ArrayList<Material>();
		shovels.addAll(Arrays.asList(Material.DIAMOND_SPADE,
				Material.GOLD_SPADE, Material.IRON_SPADE, Material.STONE_SPADE,
				Material.WOOD_SPADE));
		itemTypes.put("shovels", shovels);

		List<Material> axes = new ArrayList<Material>();
		axes.addAll(Arrays.asList(Material.DIAMOND_AXE, Material.GOLD_AXE,
				Material.IRON_AXE, Material.STONE_AXE, Material.WOOD_AXE));
		itemTypes.put("axes", axes);

		List<Material> hoes = new ArrayList<Material>();
		hoes.addAll(Arrays.asList(Material.DIAMOND_HOE, Material.GOLD_HOE,
				Material.IRON_HOE, Material.STONE_HOE, Material.WOOD_HOE));
		itemTypes.put("hoes", hoes);

		List<Material> bow = new ArrayList<Material>();
		bow.add(Material.BOW);
		itemTypes.put("bow", bow);

		List<Material> shield = new ArrayList<Material>();
		shield.add(Material.SHIELD);
		itemTypes.put("shield", shield);

		List<Material> fishing = new ArrayList<Material>();
		fishing.add(Material.FISHING_ROD);
		itemTypes.put("fishing", fishing);

		List<Material> shears = new ArrayList<Material>();
		shears.add(Material.SHEARS);
		itemTypes.put("shears", shears);

		List<Material> flintSteel = new ArrayList<Material>();
		flintSteel.add(Material.FLINT_AND_STEEL);
		itemTypes.put("flintSteel", flintSteel);

		List<Material> carrotStick = new ArrayList<Material>();
		carrotStick.add(Material.CARROT_STICK);
		itemTypes.put("carrotStick", carrotStick);

		List<Material> elytra = new ArrayList<Material>();
		elytra.add(Material.ELYTRA);
		itemTypes.put("elytra", elytra);

		List<Material> armor = new ArrayList<Material>();
		armor.addAll(helmets);
		armor.addAll(chestplates);
		armor.addAll(leggings);
		armor.addAll(boots);
		itemTypes.put("armor", armor);

		List<Material> tools = new ArrayList<Material>();
		tools.addAll(pickaxes);
		tools.addAll(axes);
		tools.addAll(shovels);
		itemTypes.put("tools", tools);

		List<Material> weapons = new ArrayList<Material>();
		weapons.addAll(axes);
		weapons.addAll(swords);
		itemTypes.put("weapons", weapons);

		List<Material> misc = new ArrayList<Material>();
		misc.addAll(shield);
		misc.addAll(fishing);
		misc.addAll(flintSteel);
		misc.addAll(carrotStick);
		misc.addAll(elytra);
		misc.addAll(hoes);

		List<Material> all = new ArrayList<Material>();
		all.addAll(armor);
		all.addAll(tools);
		all.addAll(weapons);
		all.addAll(bow);
		all.addAll(misc);
		itemTypes.put("all", all);

		List<Material> woodTools = new ArrayList<Material>();
		woodTools.addAll(Arrays.asList(Material.WOOD_AXE, Material.WOOD_SWORD,
				Material.WOOD_SPADE, Material.WOOD_PICKAXE));
		itemTypes.put("wood_tools", woodTools);

		List<Material> stoneTools = new ArrayList<Material>();
		stoneTools.addAll(Arrays.asList(Material.STONE_AXE,
				Material.STONE_SWORD, Material.STONE_SPADE,
				Material.STONE_PICKAXE));
		itemTypes.put("stone_tools", stoneTools);

		List<Material> goldTools = new ArrayList<Material>();
		goldTools.addAll(Arrays.asList(Material.GOLD_AXE, Material.GOLD_SWORD,
				Material.GOLD_SPADE, Material.GOLD_PICKAXE));
		itemTypes.put("gold_tools", goldTools);

		List<Material> ironTools = new ArrayList<Material>();
		ironTools.addAll(Arrays.asList(Material.IRON_AXE, Material.IRON_SWORD,
				Material.IRON_SPADE, Material.IRON_PICKAXE));
		itemTypes.put("iron_tools", ironTools);

		List<Material> diamondTools = new ArrayList<Material>();
		diamondTools.addAll(Arrays.asList(Material.DIAMOND_AXE,
				Material.DIAMOND_SWORD, Material.DIAMOND_SPADE,
				Material.DIAMOND_PICKAXE));
		itemTypes.put("diamond_tools", diamondTools);

		List<Material> leatherArmor = new ArrayList<Material>();
		leatherArmor.addAll(Arrays.asList(Material.LEATHER_HELMET,
				Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS,
				Material.LEATHER_BOOTS));
		itemTypes.put("leather_armor", leatherArmor);

		List<Material> goldArmor = new ArrayList<Material>();
		goldArmor.addAll(Arrays.asList(Material.GOLD_HELMET,
				Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS,
				Material.GOLD_BOOTS));
		itemTypes.put("gold_armor", goldArmor);

		List<Material> chainArmor = new ArrayList<Material>();
		chainArmor.addAll(Arrays.asList(Material.CHAINMAIL_HELMET,
				Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS,
				Material.CHAINMAIL_BOOTS));
		itemTypes.put("chain_armor", chainArmor);

		List<Material> ironArmor = new ArrayList<Material>();
		ironArmor.addAll(Arrays.asList(Material.IRON_HELMET,
				Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS,
				Material.IRON_BOOTS));
		itemTypes.put("iron_armor", ironArmor);

		List<Material> diamondArmor = new ArrayList<Material>();
		diamondArmor.addAll(Arrays.asList(Material.DIAMOND_HELMET,
				Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS,
				Material.DIAMOND_BOOTS));
		itemTypes.put("diamond_armor", diamondArmor);
		
		return itemTypes;
	}
	
	public static HashMap<String, List<Material>> getItemTypes() {
		return ITEM_TYPES;
	}
	
	private static HashMap<Material, List<Material>> setRepairTypes(){
		HashMap<Material, List<Material>> repairTypes = new HashMap<Material, List<Material>>();
		repairTypes.put(Material.DIAMOND_AXE, Arrays.asList(Material.DIAMOND_AXE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.DIAMOND_SWORD, Arrays.asList(Material.DIAMOND_SWORD, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.DIAMOND_SPADE, Arrays.asList(Material.DIAMOND_SPADE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.DIAMOND_PICKAXE, Arrays.asList(Material.DIAMOND_PICKAXE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.DIAMOND_HOE, Arrays.asList(Material.DIAMOND_HOE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.DIAMOND_HELMET, Arrays.asList(Material.DIAMOND_HELMET, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.DIAMOND_CHESTPLATE, Arrays.asList(Material.DIAMOND_CHESTPLATE, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.DIAMOND_LEGGINGS, Arrays.asList(Material.DIAMOND_LEGGINGS, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.DIAMOND_BOOTS, Arrays.asList(Material.DIAMOND_BOOTS, Material.DIAMOND, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.IRON_AXE, Arrays.asList(Material.IRON_AXE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.IRON_SWORD, Arrays.asList(Material.IRON_SWORD, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.IRON_SPADE, Arrays.asList(Material.IRON_SPADE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.IRON_PICKAXE, Arrays.asList(Material.IRON_PICKAXE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.IRON_HOE, Arrays.asList(Material.IRON_HOE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.IRON_HELMET, Arrays.asList(Material.IRON_HELMET, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.IRON_CHESTPLATE, Arrays.asList(Material.IRON_CHESTPLATE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.IRON_LEGGINGS, Arrays.asList(Material.IRON_LEGGINGS, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_BOOTS, Arrays.asList(Material.GOLD_BOOTS, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_AXE, Arrays.asList(Material.GOLD_AXE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_SWORD, Arrays.asList(Material.GOLD_SWORD, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_SPADE, Arrays.asList(Material.GOLD_SPADE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_PICKAXE, Arrays.asList(Material.GOLD_PICKAXE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_HOE, Arrays.asList(Material.GOLD_HOE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_HELMET, Arrays.asList(Material.GOLD_HELMET, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_CHESTPLATE, Arrays.asList(Material.GOLD_CHESTPLATE, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_LEGGINGS, Arrays.asList(Material.GOLD_LEGGINGS, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.GOLD_BOOTS, Arrays.asList(Material.GOLD_BOOTS, Material.GOLD_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.STONE_AXE, Arrays.asList(Material.STONE_AXE, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.STONE_SWORD, Arrays.asList(Material.STONE_SWORD, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.STONE_SPADE, Arrays.asList(Material.STONE_SPADE, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.STONE_PICKAXE, Arrays.asList(Material.STONE_PICKAXE, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.STONE_HOE, Arrays.asList(Material.STONE_HOE, Material.COBBLESTONE, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.CHAINMAIL_HELMET, Arrays.asList(Material.CHAINMAIL_HELMET, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.CHAINMAIL_CHESTPLATE, Arrays.asList(Material.CHAINMAIL_CHESTPLATE, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.CHAINMAIL_LEGGINGS, Arrays.asList(Material.CHAINMAIL_LEGGINGS, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.CHAINMAIL_BOOTS, Arrays.asList(Material.CHAINMAIL_BOOTS, Material.IRON_INGOT, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.WOOD_AXE, Arrays.asList(Material.WOOD_AXE, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.WOOD_SWORD, Arrays.asList(Material.WOOD_SWORD, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.WOOD_SPADE, Arrays.asList(Material.WOOD_SPADE, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.WOOD_PICKAXE, Arrays.asList(Material.WOOD_PICKAXE, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.WOOD_HOE, Arrays.asList(Material.WOOD_HOE, Material.WOOD, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.LEATHER_HELMET, Arrays.asList(Material.LEATHER_HELMET, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.LEATHER_CHESTPLATE, Arrays.asList(Material.LEATHER_CHESTPLATE, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.LEATHER_LEGGINGS, Arrays.asList(Material.LEATHER_LEGGINGS, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.LEATHER_BOOTS, Arrays.asList(Material.LEATHER_BOOTS, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.ELYTRA, Arrays.asList(Material.ELYTRA, Material.LEATHER, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.BOW, Arrays.asList(Material.BOW, Material.STRING, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.FISHING_ROD, Arrays.asList(Material.FISHING_ROD, Material.STRING, Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.BOOK, Arrays.asList(Material.BOOK, Material.ENCHANTED_BOOK));
		repairTypes.put(Material.ENCHANTED_BOOK, Arrays.asList(Material.BOOK, Material.ENCHANTED_BOOK));
		return repairTypes;
	}
	
	public static HashMap<Material, List<Material>> getRepairTypes(){
		return REPAIR_TYPES;
	}

	public static List<Material> getRepairMaterials() {
		return REPAIR_MATERIALS;
	}
	
	public static int repairItem(ItemStack first, ItemStack second) {
		int amount = second.getAmount();
		if(amount > 4) amount = 4;
		int durPerItem = first.getType().getMaxDurability() / 4;
		ItemStack clone = first.clone();
		clone.setDurability(first.getDurability());
		int level = 0;
		while(clone.getDurability() > 0) {
			level++;
			clone.setDurability((short) (clone.getDurability() - durPerItem));
		}
		return level;
	}
	
	public static ItemStack repairItem(ItemStack combined, ItemStack first, ItemStack second) {
		int amount = second.getAmount();
		if(amount > 4) amount = 4;
		int durPerItem = first.getType().getMaxDurability() / 4;
		while(combined.getDurability() > 0 && amount > 0) {
			amount--;
			combined.setDurability((short) (combined.getDurability() - durPerItem));
		}
		return combined;
	}
	
	public static ItemStack combineItems(Player player, ItemStack first, ItemStack second) {
		ItemStack combined = new ItemStack(first.getType());
		if(first.getType().equals(Material.ENCHANTED_BOOK)) {
			combined = new ItemStack(Material.BOOK);
		}
		combined.setDurability(first.getDurability());
		RepairType repairType = RepairType.getRepairType(first, second);
		if(repairType == null) {
			return null;
		}
		if(repairType.equals(RepairType.REPAIR)) {
			combined = repairItem(combined, first, second);
		}else if(second.getType().equals(first.getType())) {
			int extraDurability = second.getType().getMaxDurability() - second.getDurability() + (int) (second.getType().getMaxDurability() * .12);
			combined.setDurability((short)(combined.getDurability() - extraDurability));
		}
		if(combined.getDurability() < 0) {
			combined.setDurability((short) 0);
		}
		
		List<EnchantmentLevel> enchantments = Enchantments.combineEnchants(player, first, second);
		
		ItemMeta firstMeta = first.getItemMeta();
		ItemMeta combinedMeta = combined.getItemMeta();
		
		combinedMeta.setDisplayName(firstMeta.getDisplayName());
		combinedMeta.setLocalizedName(firstMeta.getLocalizedName());
		
		combined.setItemMeta(combinedMeta);
		
		combined = Enchantments.addEnchantmentsToItem(combined, enchantments);
		
		return combined;
	}
	
	public static void giveItemToPlayer(Player player, ItemStack item, Location fallback) {
		HashMap<Integer, ItemStack> leftOver = new HashMap<Integer, ItemStack>();
		leftOver.putAll((player.getInventory().addItem(item)));
		if (!leftOver.isEmpty()) {
			for (Iterator<java.util.Map.Entry<Integer, ItemStack>> it = leftOver.entrySet().iterator(); it.hasNext();) {
				java.util.Map.Entry<Integer, ItemStack> e = it.next();
				fallback.add(0.5, 0.5, 0.5);
				Item droppedItem = player.getWorld().dropItem(
						fallback,
						e.getValue());
				droppedItem.setVelocity(new Vector(0,0,0));
				droppedItem.teleport(fallback);
			}
		}
	}
	
	public static ItemStack addNMSEnchantment(ItemStack item) {
		ItemStack returnItem = new ItemStack(item.getType());
		ItemStack duplicate = item.clone();
		ItemMeta returnItemMeta = returnItem.getItemMeta();
		ItemMeta duplicateMeta = duplicate.getItemMeta();
		
		returnItemMeta.setDisplayName(duplicateMeta.getDisplayName());
		returnItemMeta.setLocalizedName(duplicateMeta.getLocalizedName());
		returnItem.setItemMeta(returnItemMeta);
		returnItem.setDurability(duplicate.getDurability());
		
		List<EnchantmentLevel> enchants = null;
		while(enchants == null) {
			PlayerLevels levels = PlayerLevels.generateFakePlayerLevels(returnItem.getType());
			int i = 0;
			while(i < 3) {
				int random = (int)(Math.random() * levels.getEnchants().size());
				if(levels.getEnchants().get(random).size() > 0) {
					enchants = levels.getEnchants().get(random);
					break;
				}
				i++;
			}
			if(i >= 3) break;
		}
		
		returnItem = Enchantments.addEnchantmentsToItem(returnItem, enchants);
		
		return returnItem;
	}
}
