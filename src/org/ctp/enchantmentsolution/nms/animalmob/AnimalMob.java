package org.ctp.enchantmentsolution.nms.animalmob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Animals;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Ocelot.Type;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.utils.StringUtils;
import org.ctp.enchantmentsolution.utils.config.YamlConfig;
import org.ctp.enchantmentsolution.utils.items.ItemSerialization;

public class AnimalMob {
	
	public static List<AnimalMob> ANIMALS = new ArrayList<AnimalMob>();
	private EntityType mob;
	private String name, owner;
	private double health, jumpStrength, movementSpeed, maxHealth;
	private ItemStack item;
	private int age, entityID, domestication, maxDomestication;
	private DyeColor sheepColor, wolfCollar;
	private boolean isHorse, carryingChest, pigSaddle, sheared, angry;
	private Map<Integer, ItemStack> inventoryItems;
	private ItemStack saddle;
	private ItemStack armor;
	private Color horseColor;
	private Style horseStyle;
	private Type ocelotType;
	private org.bukkit.entity.Rabbit.Type rabbitType;
	
	public AnimalMob(Animals mob, ItemStack item) {
		this.setMob(mob.getType());
		this.setName(mob.getCustomName());
		this.setHealth(mob.getHealth());
		this.setItem(item);
		this.setAge(mob.getAge());
		if(mob instanceof Sheep) {
			Sheep sheep = (Sheep) mob;
			setSheepColor(sheep.getColor());
			setSheared(sheep.isSheared());
		}
		if(mob instanceof Tameable) {
			Tameable tameable = (Tameable) mob;
			if(tameable.getOwner() != null) {
				setOwner(tameable.getOwner().getUniqueId().toString());
			}
		}
		if(mob instanceof Pig) {
			Pig pig = (Pig) mob;
			setPigSaddle(pig.hasSaddle());
		}
		if(mob instanceof Wolf) {
			Wolf wolf = (Wolf) mob;
			setWolfCollar(wolf.getCollarColor());
			setAngry(wolf.isAngry());
		}
		if(mob instanceof Ocelot) {
			Ocelot ocelot = (Ocelot) mob;
			setOcelotType(ocelot.getCatType());
		}
		if(mob instanceof Rabbit) {
			Rabbit rabbit = (Rabbit) mob;
			setRabbitType(rabbit.getRabbitType());
		}
		if(mob instanceof AbstractHorse) {
			inventoryItems = new HashMap<Integer, ItemStack>();
			AbstractHorse aHorse = (AbstractHorse) mob;
			setDomestication(aHorse.getDomestication());
			setMaxDomestication(aHorse.getMaxDomestication());
			setJumpStrength(aHorse.getJumpStrength());
			setMovementSpeed(aHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue());
			setMaxHealth(aHorse.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			setSaddle(aHorse.getInventory().getSaddle());
			if(mob instanceof Horse) {
				Horse horse = (Horse) mob;
				setHorseColor(horse.getColor());
				setHorseStyle(horse.getStyle());
				setArmor(horse.getInventory().getArmor());
			}
			if(aHorse instanceof ChestedHorse) {
				ChestedHorse cHorse = (ChestedHorse) aHorse;
				setCarryingChest(cHorse.isCarryingChest());
				for(int i = 2; i < cHorse.getInventory().getSize(); i++) {						
					inventoryItems.put(i, cHorse.getInventory().getItem(i));
				}
			}
		}
	}
	
	protected AnimalMob() {
		
	}
	
	public void setConfig(YamlConfig config, int i) {
		config.set("animals." + i + ".entity_type", getMob().name());
		config.set("animals." + i + ".name", getName());
		config.set("animals." + i + ".age", getAge());
		config.set("animals." + i + ".health", getHealth());
		config.set("animals." + i + ".entity_id", getEntityID());
		config.set("animals." + i + ".color", getSheepColor() != null ? getSheepColor().toString() : null);
		config.set("animals." + i + ".owner", getOwner());
		config.set("animals." + i + ".domestication", getDomestication());
		config.set("animals." + i + ".max_domestication", getMaxDomestication());
		config.set("animals." + i + ".jump_strength", getJumpStrength());
		config.set("animals." + i + ".movement_speed", getMovementSpeed());
		config.set("animals." + i + ".max_health", getMaxHealth());
		config.set("animals." + i + ".carrying_chest", isCarryingChest());
		config.set("animals." + i + ".jump_strength", getJumpStrength());
		config.set("animals." + i + ".pig_saddle", hasPigSaddle());
		config.set("animals." + i + ".sheared", isSheared());
		config.set("animals." + i + ".sheep_color", getSheepColor() != null ? getSheepColor().name() : null);
		config.set("animals." + i + ".wolf_collar", getWolfCollar() != null ? getWolfCollar().name() : null);
		config.set("animals." + i + ".horse_style", getHorseStyle() != null ? getHorseStyle().name() : null);
		config.set("animals." + i + ".horse_color", getHorseColor() != null ? getHorseColor().name() : null);
		config.set("animals." + i + ".ocelot_type", getOcelotType() != null ? getOcelotType().name() : null);
		config.set("animals." + i + ".rabbit_type", getRabbitType() != null ? getRabbitType().name() : null);
		config.set("animals." + i + ".saddle", getSaddle() != null ? ItemSerialization.itemToString(getSaddle()) : null);
		config.set("animals." + i + ".armor", getArmor() != null ? ItemSerialization.itemToString(getArmor()) : null);
		
		for(int k = 2; k < 17; k++) {
			if(inventoryItems.get(k) != null) {
				config.set("animals." + i + ".inventory_items." + k, ItemSerialization.itemToString(inventoryItems.get(k)));
			}
		}
	}
	
	public void editProperties(Entity e) {
		try {
			e.setCustomName(getName());
			if(e instanceof Animals) {
				Animals animal = (Animals) e;
				if(animal instanceof Sheep) {
					if(sheepColor == null) sheepColor = DyeColor.WHITE;
					((Sheep) animal).setColor(sheepColor);
					((Sheep) animal).setSheared(isSheared());
				}
				if(animal instanceof Tameable) {
					Tameable tameable = (Tameable) animal;
					if(owner != null) {
						Entity eOwner = Bukkit.getEntity(UUID.fromString(owner));
						if(eOwner != null && eOwner instanceof AnimalTamer) {
							tameable.setOwner((AnimalTamer) eOwner);
						}
					}
				}
				if(animal instanceof Pig) {
					Pig pig = (Pig) animal;
					pig.setSaddle(hasPigSaddle());
				}
				if(animal instanceof Wolf) {
					Wolf wolf = (Wolf) animal;
					wolf.setCollarColor(getWolfCollar());
					wolf.setAngry(isAngry());
				}
				if(animal instanceof Ocelot) {
					Ocelot ocelot = (Ocelot) animal;
					ocelot.setCatType(getOcelotType());
				}
				if(animal instanceof Rabbit) {
					Rabbit rabbit = (Rabbit) animal;
					rabbit.setRabbitType(getRabbitType());
				}
				if(animal instanceof AbstractHorse) {
					AbstractHorse aHorse = (AbstractHorse) animal;
					aHorse.getInventory().setSaddle(getSaddle());
					if(animal instanceof Horse) {
						Horse horse = (Horse) animal;
						horse.setColor(getHorseColor());
						horse.setStyle(getHorseStyle());
						horse.getInventory().setArmor(getArmor());
					}
					aHorse.setDomestication(getDomestication());
					aHorse.setJumpStrength(getJumpStrength());
					aHorse.setMaxDomestication(getMaxDomestication());
					aHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(getMovementSpeed());
					aHorse.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(getMaxHealth());
					if(aHorse instanceof ChestedHorse) {
						ChestedHorse cHorse = (ChestedHorse) aHorse;
						cHorse.setCarryingChest(isCarryingChest());
						for(int i = 2; i < inventoryItems.size(); i++) {
							cHorse.getInventory().setItem(i, inventoryItems.get(i));
						}
					}
				}
				animal.setAge(getAge());
				animal.setHealth(getHealth());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void generateID() {
		int base = 100;
		for(AnimalMob animal : ANIMALS) {
			if(animal.getEntityID() > base) base = animal.getEntityID();
		}
		setEntityID(base + 1, true);
	}

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
		generateID();
	}

	public EntityType getMob() {
		return mob;
	}

	public void setMob(EntityType mob) {
		this.mob = mob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEntityID() {
		return entityID;
	}

	public void setEntityID(int entityID, boolean addLore) {
		this.entityID = entityID;
		if(addLore) {
			StringUtils.addAnimal(item, entityID);
		}
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getJumpStrength() {
		return jumpStrength;
	}

	public void setJumpStrength(double jumpStrength) {
		this.jumpStrength = jumpStrength;
	}

	public int getDomestication() {
		return domestication;
	}

	public void setDomestication(int domestication) {
		this.domestication = domestication;
	}

	public boolean isHorse() {
		return isHorse;
	}

	public void setHorse(boolean isHorse) {
		this.isHorse = isHorse;
	}

	public boolean isCarryingChest() {
		return carryingChest;
	}

	public void setCarryingChest(boolean carryingChest) {
		this.carryingChest = carryingChest;
	}

	public double getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(double movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public Map<Integer, ItemStack> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(Map<Integer, ItemStack> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public Color getHorseColor() {
		return horseColor;
	}

	public void setHorseColor(Color horseColor) {
		this.horseColor = horseColor;
	}

	public Style getHorseStyle() {
		return horseStyle;
	}

	public void setHorseStyle(Style horseStyle) {
		this.horseStyle = horseStyle;
	}

	public int getMaxDomestication() {
		return maxDomestication;
	}

	public void setMaxDomestication(int maxDomestication) {
		this.maxDomestication = maxDomestication;
	}

	public ItemStack getSaddle() {
		return saddle;
	}

	public void setSaddle(ItemStack saddle) {
		this.saddle = saddle;
	}

	public ItemStack getArmor() {
		return armor;
	}

	public void setArmor(ItemStack armor) {
		this.armor = armor;
	}

	public DyeColor getSheepColor() {
		return sheepColor;
	}

	public void setSheepColor(DyeColor sheepColor) {
		this.sheepColor = sheepColor;
	}

	public boolean hasPigSaddle() {
		return pigSaddle;
	}

	public void setPigSaddle(boolean pigSaddle) {
		this.pigSaddle = pigSaddle;
	}

	public DyeColor getWolfCollar() {
		return wolfCollar;
	}

	public void setWolfCollar(DyeColor wolfCollar) {
		this.wolfCollar = wolfCollar;
	}

	public boolean isAngry() {
		return angry;
	}

	public void setAngry(boolean angry) {
		this.angry = angry;
	}

	public boolean isSheared() {
		return sheared;
	}

	public void setSheared(boolean sheared) {
		this.sheared = sheared;
	}

	public Type getOcelotType() {
		return ocelotType;
	}

	public void setOcelotType(Type ocelotType) {
		this.ocelotType = ocelotType;
	}

	public org.bukkit.entity.Rabbit.Type getRabbitType() {
		return rabbitType;
	}

	public void setRabbitType(org.bukkit.entity.Rabbit.Type rabbitType) {
		this.rabbitType = rabbitType;
	}
}
