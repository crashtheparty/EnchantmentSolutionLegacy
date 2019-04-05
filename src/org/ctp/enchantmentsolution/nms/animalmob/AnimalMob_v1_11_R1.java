package org.ctp.enchantmentsolution.nms.animalmob;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.DyeColor;
import org.bukkit.entity.Animals;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Llama.Color;
import org.bukkit.entity.Ocelot.Type;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.utils.config.YamlConfig;
import org.ctp.enchantmentsolution.utils.items.ItemSerialization;

public class AnimalMob_v1_11_R1 extends AnimalMob{
	
	private Color llamaColor;
	private int llamaStrength;

	public AnimalMob_v1_11_R1(Animals mob, ItemStack item) {
		super(mob, item);
		
		if(mob instanceof Llama) {
			Llama llama = (Llama) mob;
			setLlamaColor(llama.getColor());
			setLlamaStrength(llama.getStrength());
		}
	}
	
	private AnimalMob_v1_11_R1() {}
	
	public void setConfig(YamlConfig config, int i) {
		super.setConfig(config, i);
		
		config.set("animals." + i + ".llama_strength", getLlamaStrength());
		config.set("animals." + i + ".llama_color", getLlamaColor() != null ? getLlamaColor().name() : null);
	}

	public static AnimalMob createFromConfig(YamlConfig config, int i) {
		AnimalMob_v1_11_R1 mob = new AnimalMob_v1_11_R1();
		
		mob.setName(config.getString("animals." + i + ".name"));
		mob.setAge(config.getInt("animals." + i + ".age"));
		mob.setHealth(config.getDouble("animals." + i + ".health"));
		mob.setEntityID(config.getInt("animals." + i + ".entity_id"), false);
		mob.setOwner(config.getString("animals." + i + ".owner"));
		mob.setDomestication(config.getInt("animals." + i + ".domestication"));
		mob.setMaxDomestication(config.getInt("animals." + i + ".max_domestication"));
		mob.setJumpStrength(config.getDouble("animals." + i + ".jump_strength"));
		mob.setMovementSpeed(config.getDouble("animals." + i + ".movement_speed"));
		mob.setMaxHealth(config.getDouble("animals." + i + ".max_health"));
		mob.setCarryingChest(config.getBoolean("animals." + i + ".carrying_chest"));
		mob.setLlamaStrength(config.getInt("animals." + i + ".llama_strength"));
		mob.setPigSaddle(config.getBoolean("animals." + i + ".pig_saddle"));
		mob.setSheared(config.getBoolean("animals." + i + ".sheared"));

		try {
			mob.setMob(EntityType.valueOf(config.getString("animals." + i + ".entity_type")));
		} catch(Exception ex) {}
		try {
			mob.setSheepColor(DyeColor.valueOf(config.getString("animals." + i + ".sheep_color")));
		} catch(Exception ex) {}
		try {
			mob.setWolfCollar(DyeColor.valueOf(config.getString("animals." + i + ".wolf_collar")));
		} catch(Exception ex) {}
		try {
			mob.setHorseStyle(Style.valueOf(config.getString("animals." + i + ".horse_style")));
		} catch(Exception ex) {}
		try {
			mob.setHorseColor(org.bukkit.entity.Horse.Color.valueOf(config.getString("animals." + i + ".horse_color")));
		} catch(Exception ex) {}
		try {
			mob.setLlamaColor(org.bukkit.entity.Llama.Color.valueOf(config.getString("animals." + i + ".llama_color")));
		} catch(Exception ex) {}
		try {
			mob.setOcelotType(Type.valueOf(config.getString("animals." + i + ".ocelot_type")));
		} catch(Exception ex) {}
		try {
			mob.setRabbitType(org.bukkit.entity.Rabbit.Type.valueOf(config.getString("animals." + i + ".rabbit_type")));
		} catch(Exception ex) {}
		try {
			mob.setSaddle(ItemSerialization.stringToItem(config.getString("animals." + i + ".saddle")));
		} catch(Exception ex) {}
		try {
			mob.setArmor(ItemSerialization.stringToItem(config.getString("animals." + i + ".armor")));
		} catch(Exception ex) {}

		Map<Integer, ItemStack> inventoryItems = new HashMap<Integer, ItemStack>();
		List<String> inventoryKeys = config.getConfigurationInfo("animals." + i + ".inventory_items");
		for(String key : inventoryKeys) {
			String keyNum = key.substring(key.lastIndexOf('.') + 1);
			try {
				int num = Integer.parseInt(keyNum);
				inventoryItems.put(num, ItemSerialization.stringToItem(config.getString(key)));
				config.removeKey(key);
			} catch(Exception ex) {}
		}
		mob.setInventoryItems(inventoryItems);
		
		for(String key : config.getConfigurationInfo("animals." + i)) {
			config.removeKey(key);
		}
		ANIMALS.add(mob);
		return mob;
	}

	public Color getLlamaColor() {
		return llamaColor;
	}

	public void setLlamaColor(Color llamaColor) {
		this.llamaColor = llamaColor;
	}

	public int getLlamaStrength() {
		return llamaStrength;
	}

	public void setLlamaStrength(int llamaStrength) {
		this.llamaStrength = llamaStrength;
	}

}
