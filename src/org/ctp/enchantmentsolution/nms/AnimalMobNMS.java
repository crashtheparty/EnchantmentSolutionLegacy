package org.ctp.enchantmentsolution.nms;

import org.bukkit.entity.Animals;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.nms.animalmob.AnimalMob;
import org.ctp.enchantmentsolution.nms.animalmob.AnimalMob_v1_10_R1;
import org.ctp.enchantmentsolution.nms.animalmob.AnimalMob_v1_11_R1;
import org.ctp.enchantmentsolution.nms.animalmob.AnimalMob_v1_12_R1;
import org.ctp.enchantmentsolution.nms.animalmob.AnimalMob_v1_9_R1;
import org.ctp.enchantmentsolution.nms.animalmob.AnimalMob_v1_9_R2;
import org.ctp.enchantmentsolution.utils.config.YamlConfig;

public class AnimalMobNMS {

	public static AnimalMob getMob(Animals animal, ItemStack item) {
		switch(EnchantmentSolution.getPlugin().getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
			return new AnimalMob_v1_9_R1(animal, item);
		case 3:
			return new AnimalMob_v1_9_R2(animal, item);
		case 4:
		case 5:
			return new AnimalMob_v1_10_R1(animal, item);
		case 6:
		case 7:
		case 8:
			return new AnimalMob_v1_11_R1(animal, item);
		case 9:
		case 10:
		case 11:
			return new AnimalMob_v1_12_R1(animal, item);
		}
		return null;
	}
	
	public static AnimalMob getFromConfig(YamlConfig config, int i) {
		switch(EnchantmentSolution.getPlugin().getBukkitVersion().getVersionNumber()) {
		case 1:
		case 2:
			return AnimalMob_v1_9_R1.createFromConfig(config, i);
		case 3:
			return AnimalMob_v1_9_R2.createFromConfig(config, i);
		case 4:
		case 5:
			return AnimalMob_v1_10_R1.createFromConfig(config, i);
		case 6:
		case 7:
		case 8:
			return AnimalMob_v1_11_R1.createFromConfig(config, i);
		case 9:
		case 10:
		case 11:
			return AnimalMob_v1_12_R1.createFromConfig(config, i);
		}
		return null;
	}
	
}
