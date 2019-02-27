package org.ctp.enchantmentsolution.utils.items.nms;

import java.util.Collection;

import org.bukkit.CropState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NetherWartsState;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;
import org.bukkit.material.NetherWarts;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.utils.items.nms.fortune.Fortune_v1_10;
import org.ctp.enchantmentsolution.utils.items.nms.fortune.Fortune_v1_11;
import org.ctp.enchantmentsolution.utils.items.nms.fortune.Fortune_v1_12;
import org.ctp.enchantmentsolution.utils.items.nms.fortune.Fortune_v1_9;
import org.ctp.enchantmentsolution.utils.items.nms.silktouch.SilkTouch_v1_10;
import org.ctp.enchantmentsolution.utils.items.nms.silktouch.SilkTouch_v1_11;
import org.ctp.enchantmentsolution.utils.items.nms.silktouch.SilkTouch_v1_12;
import org.ctp.enchantmentsolution.utils.items.nms.silktouch.SilkTouch_v1_9;
import org.ctp.enchantmentsolution.utils.items.nms.smeltery.Smeltery_v1_10;
import org.ctp.enchantmentsolution.utils.items.nms.smeltery.Smeltery_v1_11;
import org.ctp.enchantmentsolution.utils.items.nms.smeltery.Smeltery_v1_12;
import org.ctp.enchantmentsolution.utils.items.nms.smeltery.Smeltery_v1_9;

public class AbilityUtils {
	
	public static ItemStack getSmelteryItem(Block block, ItemStack item) {
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
		case 3:
			return Smeltery_v1_9.getSmelteryItem(block, item);
		case 4:
		case 5:
			return Smeltery_v1_10.getSmelteryItem(block, item);
		case 6:
		case 7:
		case 8:
			return Smeltery_v1_11.getSmelteryItem(block, item);
		case 9:
		case 10:
		case 11:
			return Smeltery_v1_12.getSmelteryItem(block, item);
		}
		return null;
	}
	
	public static ItemStack getSilkTouchItem(Block block, ItemStack item){
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
		case 3:
			return SilkTouch_v1_9.getSilkTouchItem(block, item);
		case 4:
		case 5:
			return SilkTouch_v1_10.getSilkTouchItem(block, item);
		case 6:
		case 7:
		case 8:
			return SilkTouch_v1_11.getSilkTouchItem(block, item);
		case 9:
		case 10:
		case 11:
			return SilkTouch_v1_12.getSilkTouchItem(block, item);
		}
		return null;
	}

	public static Collection<ItemStack> getFortuneItems(ItemStack item,
			Block brokenBlock, Collection<ItemStack> priorItems) {
		switch(EnchantmentSolution.getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
		case 3:
			return Fortune_v1_9.getFortuneItems(item, brokenBlock, priorItems);
		case 4:
		case 5:
			return Fortune_v1_10.getFortuneItems(item, brokenBlock, priorItems);
		case 6:
		case 7:
		case 8:
			return Fortune_v1_11.getFortuneItems(item, brokenBlock, priorItems);
		case 9:
		case 10:
		case 11:
			return Fortune_v1_12.getFortuneItems(item, brokenBlock, priorItems);
		}
		return null;
	}
	
	public static ItemStack getGoldDiggerItems(ItemStack item,
			Block brokenBlock) {
		
		if(brokenBlock.getState().getData() instanceof Crops) {
			Crops c = (Crops) brokenBlock.getState().getData();
            if(!c.getState().equals(CropState.RIPE)) {
            	return null;
            }
		} else if(brokenBlock.getState().getData() instanceof NetherWarts) {
			NetherWarts c = (NetherWarts) brokenBlock.getState().getData();
            if(!c.getState().equals(NetherWartsState.RIPE)) {
            	return null;
            }
		} else {
			return null;
		}
		int level = Enchantments.getLevel(item,
				DefaultEnchantments.GOLD_DIGGER);
		int amount = 0;
		while(level > 0) {
			double random = Math.random();
			double chance = 1.0 / 6.0;
			if(chance > random) {
				amount ++;
			}
			level --;
		}
		if(amount > 0) {
			return (new ItemStack(Material.GOLD_NUGGET, amount));
		}
		
		return null;
	}
	
	public static void dropExperience(Location loc, int amount) {
		if(amount > 0) {
			((ExperienceOrb)loc.getWorld().spawn(loc, ExperienceOrb.class)).setExperience(amount);
		}
	}
}
