package org.ctp.enchantmentsolution.utils.items.nms.fortune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.utils.TreeType;
import org.ctp.enchantmentsolution.utils.items.nms.AbilityUtils;
import org.ctp.enchantmentsolution.utils.items.nms.ItemBreakType;

public class Fortune_v1_11 {
	private static List<Material> FORTUNE_ITEMS = Arrays.asList(
			Material.DIAMOND_ORE, Material.EMERALD_ORE,
			Material.COAL_ORE, Material.QUARTZ_ORE, Material.LAPIS_ORE,
			Material.REDSTONE_ORE, Material.GLOWING_REDSTONE_ORE, Material.CROPS, Material.CARROT,
			Material.POTATO, Material.GLOWSTONE, Material.SEA_LANTERN,
			Material.MELON_BLOCK, Material.NETHER_STALK,
			Material.BEETROOT_BLOCK, Material.LONG_GRASS, Material.GRAVEL, Material.LEAVES, Material.LEAVES_2);

	public static Collection<ItemStack> getFortuneItems(ItemStack item,
			Block brokenBlock, Collection<ItemStack> priorItems) {
		boolean ironGold = false;
		int level = Enchantments.getLevel(item,
				Enchantment.LOOT_BONUS_BLOCKS);
		if(level <= 0) return priorItems;
		Iterator<ItemStack> iter = priorItems.iterator();
		List<ItemStack> duplicate = new ArrayList<ItemStack>();
		while(iter.hasNext()) {
			duplicate.add(iter.next());
		}
		if ((brokenBlock.getType().equals(Material.IRON_ORE) || brokenBlock
				.getType().equals(Material.GOLD_ORE))
				&& item.containsEnchantment(DefaultEnchantments.SMELTERY)) {
			if(DefaultEnchantments.isEnabled(DefaultEnchantments.SMELTERY)) {
				priorItems.clear();
				if (brokenBlock.getType().equals(Material.IRON_ORE)) {
					if(Arrays.asList(Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE, Material.STONE_PICKAXE).contains(item.getType())) {
						priorItems.add(new ItemStack(Material.IRON_INGOT));
						ironGold = true;
					}
				} else {
					if(Arrays.asList(Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE).contains(item.getType())){
						priorItems.add(new ItemStack(Material.GOLD_INGOT));
						ironGold = true;
					}
				}
				iter = priorItems.iterator();
				duplicate = new ArrayList<ItemStack>();
				while(iter.hasNext()) {
					duplicate.add(iter.next());
				}
			}
			
		} else if (!(FORTUNE_ITEMS.contains(brokenBlock.getType()))) {
			if(Enchantments.hasEnchantment(item, DefaultEnchantments.SMELTERY)) {
				if(DefaultEnchantments.isEnabled(DefaultEnchantments.SMELTERY)) {
					ItemStack smelted = AbilityUtils.getSmelteryItem(brokenBlock, item);
					if(smelted != null) {
						priorItems.clear();
						priorItems.add(smelted);
					}
				}
			}
			return priorItems;
		}

		if (Arrays.asList(Material.DIAMOND_ORE, Material.EMERALD_ORE,
				Material.COAL_ORE, Material.QUARTZ_ORE, Material.LAPIS_ORE)
				.contains(brokenBlock.getType())
				|| ironGold) {
			boolean canBreak = false;
			ItemBreakType type = ItemBreakType.getType(brokenBlock.getType());
			if(type != null) {
				if(type.getBreakTypes().contains(item.getType())) {
					canBreak = true;
				}
			}
			if(canBreak || ironGold) {
				ItemStack fortunableItem = duplicate.get(0);
				level = Enchantments.getLevel(item,
						Enchantment.LOOT_BONUS_BLOCKS) + 2;
				int multiply = (int) (Math.random() * level);
				if (multiply > 1) {
					fortunableItem.setAmount(fortunableItem.getAmount() * multiply);
					priorItems.clear();
					priorItems.add(fortunableItem);
				}
				for (int i = 0; i < duplicate.size(); i++) {
					boolean foundPrior = false;
					for (ItemStack prior : priorItems) {
						if (prior.getType().equals(duplicate.get(i).getType())) {
							foundPrior = true;
						}
					}
					if (!foundPrior) {
						priorItems.add(duplicate.get(i));
					}
				}
			}
		} else if (Arrays.asList(Material.REDSTONE_ORE, Material.GLOWING_REDSTONE_ORE, Material.CROPS,
				Material.BEETROOT_BLOCK, Material.CARROT, Material.POTATO,
				Material.NETHER_STALK, Material.SEA_LANTERN, Material.MELON_BLOCK, Material.GLOWSTONE, Material.LONG_GRASS).contains(
				brokenBlock.getType())) {
			level = Enchantments.getLevel(item,
					Enchantment.LOOT_BONUS_BLOCKS);
			int min = 0;
			int max = 0;
			int actualMax = 0;
			Material breakBlock = null;
			switch(brokenBlock.getType()){
			case GLOWING_REDSTONE_ORE:
			case REDSTONE_ORE:
				if(Arrays.asList(Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE).contains(item.getType())) {
					min = 4;
					max = 5 + level;
					breakBlock = Material.REDSTONE;
				}
				break;
			case LONG_GRASS:
				for(ItemStack priorItem : priorItems) {
					if(priorItem.getType().equals(Material.SEEDS)){
						min = 1;
						max = 3 + level * 2;
						break;
					}
				}
				breakBlock = Material.SEEDS;
				break;
			case CROPS:
				breakBlock = Material.SEEDS;
				min = 0;
				max = 3 + level;
				break;
			case BEETROOT_BLOCK:
				breakBlock = Material.BEETROOT_SEEDS;
				min = 0;
				max = 3 + level;
				break;
			case CARROT:
				breakBlock = Material.CARROT_ITEM;
				min = 1;
				max = 4 + level;
				break;
			case POTATO:
				breakBlock = Material.POTATO_ITEM;
				min = 1;
				max = 4 + level;
				break;
			case NETHER_STALK:
				breakBlock = Material.NETHER_WARTS;
				min = 2;
				max = 4 + level;
				break;
			case SEA_LANTERN:
				breakBlock = Material.PRISMARINE_CRYSTALS;
				min = 2;
				max = 3 + level;
				actualMax = 5;
				break;
			case MELON_BLOCK:
				breakBlock = Material.MELON;
				min = 3;
				max = 7 + level;
				actualMax = 9;
				break;
			case GLOWSTONE:
				breakBlock = Material.GLOWSTONE_DUST;
				min = 2;
				max = 4 + level;
				actualMax = 4;
				break;
			default:
				
			}
			int finalCount = (int) (Math.random() * (max - min)) + min;
			if(actualMax > 0 && finalCount > actualMax){
				finalCount = actualMax;
			}
			ItemStack fortunableItem = new ItemStack(breakBlock);
			
			fortunableItem.setAmount(finalCount);
			priorItems.clear();
			priorItems.add(fortunableItem);
			if(brokenBlock.getType().equals(Material.BEETROOT_BLOCK)){
				priorItems.add(new ItemStack(Material.BEETROOT));
			}else if(brokenBlock.getType().equals(Material.CROPS)){
				priorItems.add(new ItemStack(Material.WHEAT));
			}
		}else if(brokenBlock.getType().equals(Material.GRAVEL)){
			double chance = 0;
			if(Enchantments.getLevel(item,
					Enchantment.LOOT_BONUS_BLOCKS) > 2){
				chance = 1;
			}else{
				if(Enchantments.getLevel(item,
					Enchantment.LOOT_BONUS_BLOCKS) == 1){
					chance = .14;
				}else{
					chance = .25;
				}
			}
			double random = Math.random();
			if(chance > random){
				priorItems.clear();
				priorItems.add(new ItemStack(Material.FLINT));
			}
		}else if(brokenBlock.getType().equals(Material.LEAVES) || brokenBlock.getType().equals(Material.LEAVES_2)){
			TreeType type = TreeType.get(brokenBlock);
			level = Enchantments.getLevel(item,
					Enchantment.LOOT_BONUS_BLOCKS);
			if(type.equals(TreeType.JUNGLE)){
				double chance = 0;
				if(4 * (level - 1) * (level - 1) >= 36){
					chance = .25;
				}else{
					chance = 1.0 / (36 - 4 * (level - 1) * (level - 1));
				}
				if(chance > .25) chance = .25;
				double random = Math.random();
				if(chance > random){
					priorItems.add(type.getSapling(1));
				}
			}else{
				double chance = 0;
				if(4 * (level - 1) * (level - 1) >= 16){
					chance = .50;
				}else{
					chance = 1.0 / (16 - 4 * (level - 1) * (level - 1));
				}
				if(chance > .50) chance = .50;
				double random = Math.random();
				if(chance > random){
					priorItems.add(type.getSapling(1));
				}
				if(type.equals(TreeType.DARK_OAK) || type.equals(TreeType.OAK)){
					chance = 0;
					if(20 * (level - 1) * (level - 1) >= 16){
						chance = .50;
					}else{
						chance = 1.0 / (180 - 20 * (level - 1) * (level - 1));
					}
					if(chance > .50) chance = .50;
					random = Math.random();
					if(chance > random){
						priorItems.add(type.getSapling(1));
					}
				}
			}
		}

		return priorItems;
	}
}
