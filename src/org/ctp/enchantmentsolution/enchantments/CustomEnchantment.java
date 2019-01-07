package org.ctp.enchantmentsolution.enchantments;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.ctp.enchantmentsolution.utils.ChatUtils;
import org.ctp.enchantmentsolution.utils.PermissionUtils;
import org.ctp.enchantmentsolution.utils.items.ItemType;
import org.ctp.enchantmentsolution.utils.save.ConfigFiles;

public abstract class CustomEnchantment {

	private boolean enabled = true;
	private boolean treasure = false;
	private String displayName = "", defaultDisplayName = "";
	private int defaultThirtyConstant = -1, defaultFiftyConstant = -1, constant = -1, defaultThirtyModifier = -1,
			defaultFiftyModifier = -1, modifier = -1, defaultThirtyMaxConstant = -1, defaultFiftyMaxConstant = -1,
			maxConstant = -1, defaultThirtyStartLevel = -1, defaultFiftyStartLevel = -1, startLevel = -1,
			defaultThirtyMaxLevel = -1, defaultFiftyMaxLevel = -1, maxLevel = -1;
	private Weight defaultWeight = Weight.NULL;
	private Weight weight = Weight.NULL;
	private boolean maxLevelOne = false;
	private List<Enchantment> conflictingEnchantments = new ArrayList<Enchantment>();
	private List<Material> disabledItems = new ArrayList<Material>();

	public CustomEnchantment() {
		setConflictingEnchantments();
	}
	
	public abstract Enchantment getRelativeEnchantment();
	
	public static boolean conflictsWith(CustomEnchantment enchOne, CustomEnchantment enchTwo) {
		if(enchOne.conflictsWith(enchTwo) || enchTwo.conflictsWith(enchOne)) {
			return true;
		}
		return false;
	}
	
	public abstract String getDescription();
	
	protected abstract List<ItemType> getEnchantmentItemTypes();
	
	protected abstract List<ItemType> getAnvilItemTypes();
	
	protected abstract List<Enchantment> getDefaultConflictingEnchantments();
	
	public List<Enchantment> getConflictingEnchantments(){
		List<Enchantment> conflicting = new ArrayList<Enchantment>();
		conflicting.add(getRelativeEnchantment());
		conflicting.addAll(conflictingEnchantments);
		return conflicting;
	}
	
	public List<String> conflictingDefaultList(){
		List<String> names = new ArrayList<String>();
		for(Enchantment enchant : getDefaultConflictingEnchantments()) {
			CustomEnchantment custom = DefaultEnchantments.getCustomEnchantment(enchant);
			if(custom != null) {
				names.add(custom.getName());
			}
		}
		return names;
	}
	
	public void setConflictingEnchantments() {
		List<Enchantment> enchantments = getDefaultConflictingEnchantments();
		if(this.getRelativeEnchantment() != null && enchantments.contains(this.getRelativeEnchantment())) {
			enchantments.remove(this.getRelativeEnchantment());
		}
		this.conflictingEnchantments = enchantments;
	}

	public void setConflictingEnchantments(List<Enchantment> conflictingEnchantments) {
		if(this.getRelativeEnchantment() != null && conflictingEnchantments.contains(this.getRelativeEnchantment())) {
			conflictingEnchantments.remove(this.getRelativeEnchantment());
		}
		this.conflictingEnchantments = conflictingEnchantments;
	}

	public String getDetails() {
		String page = StringUtils.LF + StringUtils.LF + 
				ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.name") + getDisplayName() + StringUtils.LF + StringUtils.LF;
		page += ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.description") + getDescription() + StringUtils.LF;
		page += ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.max-level") + getMaxLevel() + "."+ StringUtils.LF;
		page += ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.weight") + getWeightName() + "."+ StringUtils.LF;
		page += ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.start-level") + getStartLevel() + "."+ StringUtils.LF;
		page +=  ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.enchantable-items");
		if(getEnchantmentItemTypes().size() > 0) {
			if (getEnchantmentItemTypes().get(0).equals(ItemType.ALL)) {
				page += getEnchantmentItemTypes().get(0).getDisplayName() + "." + StringUtils.LF;
			} else {
				for(ItemType type : getEnchantmentItemTypes()) {
					page += type.getDisplayName() + ", ";
				}
				page += "Books." + StringUtils.LF;
			}
		} else {
			page += "None." + StringUtils.LF;
		}
		page +=  ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.anvilable-items");
		if(getAnvilItemTypes().size() > 0) {
			if (getAnvilItemTypes().get(0).equals(ItemType.ALL)) {
				page += getAnvilItemTypes().get(0).getDisplayName() + "." + StringUtils.LF;
			} else {
				for(ItemType type : getAnvilItemTypes()) {
					page += type.getDisplayName() + ", ";
				}
				page += "Books." + StringUtils.LF;
			}
		} else {
			page += "None." + StringUtils.LF;
		}
		page +=  ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.disabled-items");
		if(getDisabledItems().size() > 0) {
			List<String> names = new ArrayList<String>();
			for(int i = 0; i < getDisabledItems().size(); i++) {
				Material mat = getDisabledItems().get(i);
				names.add(mat.name());
			}
			
			if(names.isEmpty()) {
				page += "None" + "." + StringUtils.LF;
			} else {
				page += StringUtils.join(names, ",") + "." + StringUtils.LF;
			}
		} else {
			page += "None." + StringUtils.LF;
		}
		page +=  ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.conflicting-enchantments");
		if(getConflictingEnchantments().size() > 0) {
			List<String> names = new ArrayList<String>();
			for(int i = 0; i < getConflictingEnchantments().size(); i++) {
				Enchantment enchant = getConflictingEnchantments().get(i);
				CustomEnchantment custom = DefaultEnchantments.getCustomEnchantment(enchant);
				if(custom != null && !custom.getRelativeEnchantment().equals(this.getRelativeEnchantment())) {
					names.add(custom.getDisplayName());
				}
			}
			
			if(names.isEmpty()) {
				page += "None";
			} else {
				page += StringUtils.join(names, ",");
			}
			page += "." + StringUtils.LF;
		} else {
			page += "None." + StringUtils.LF;
		}
		page += ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.enabled") + isEnabled() + ". " + StringUtils.LF;
		page += ChatUtils.getMessage(ChatUtils.getCodes(), "enchantment.treasure") + isTreasure() + ". " + StringUtils.LF;
		return page;
	}

	public boolean canEnchantItem(Material item) {
		if(disabledItems.contains(item)) return false;
		for(ItemType type : getEnchantmentItemTypes()) {
			if(type.getItemTypes().contains(item)) {
				return true;
			}
		}
		return false;
	}

	public boolean canAnvilItem(Material item) {
		if(disabledItems.contains(item)) return false;
		for(ItemType type : getAnvilItemTypes()) {
			if(type.getItemTypes().contains(item)) {
				return true;
			}
		}
		return false;
	}

	public boolean conflictsWith(CustomEnchantment ench) {
		for(Enchantment enchantment : getConflictingEnchantments()) {
			if(enchantment.equals(ench.getRelativeEnchantment())) {
				return true;
			}
		}
		return false;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public abstract String getName();

	public String getDisplayName() {
		return displayName;
	}

	public int getStartLevel() {
		return startLevel;
	}

	public int getWeight() {
		return weight.getWeight();
	}
	
	public String getWeightName() {
		return weight.getName();
	}
	
	public boolean canAnvil(Player player, int level) {
		if (PermissionUtils.canAnvil(player, this, level)) {
			return true;
		}

		return false;
	}
	
	public int getAnvilLevel(Player player, int level) {
		while(level > 0) {
			if(PermissionUtils.canAnvil(player, this, level)) {
				return level;
			}
			level --;
		}
		return 0;
	}

	public boolean canEnchant(Player player, int enchantability, int level) {
		if (ConfigFiles.useStartLevel() && level < getStartLevel()) {
			return false;
		}
		if(getEnchantLevel(player, enchantability) > 0) {
			return true;
		}

		return false;
	}

	public int getEnchantLevel(Player player, int enchantability) {
		for(int i = getMaxLevel(); i > 0; i--) {
			int[] levels = enchantability(i);
			if (PermissionUtils.canEnchant(player, this, i)) {
				if (enchantability >= levels[0] && enchantability <= levels[1]) {
					return i;
				}
			}
		}
		return 0;
	}

	public int[] enchantability(int level) {
		int[] levels = new int[2];
		levels[0] = modifier * level + constant;
		levels[1] = levels[0] + maxConstant;
		return levels;
	}

	public int multiplier(Material material) {
		if (!(material.equals(Material.BOOK) || material.equals(Material.ENCHANTED_BOOK))) {
			return weight.getBook();
		}
		return weight.getItem();
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isTreasure() {
		return treasure;
	}

	public void setTreasure(boolean treasure) {
		this.treasure = treasure;
	}

	public void setDisplayName(String name) {
		displayName = name;
	}

	private int getDefaultThirtyConstant() {
		return defaultThirtyConstant;
	}

	protected void setDefaultThirtyConstant(int constant) {
		defaultThirtyConstant = constant;
	}

	public int getDefaultFiftyConstant() {
		return defaultFiftyConstant;
	}

	protected void setDefaultFiftyConstant(int constant) {
		defaultFiftyConstant = constant;
	}

	private void setConstant(int constant) {
		this.constant = constant;
	}

	private int getDefaultThirtyModifier() {
		return defaultThirtyModifier;
	}

	protected void setDefaultThirtyModifier(int modifier) {
		defaultThirtyModifier = modifier;
	}

	public int getDefaultFiftyModifier() {
		return defaultFiftyModifier;
	}

	protected void setDefaultFiftyModifier(int modifier) {
		defaultFiftyModifier = modifier;
	}

	private void setModifier(int modifier) {
		this.modifier = modifier;
	}

	private int getDefaultThirtyMaxConstant() {
		return defaultThirtyMaxConstant;
	}

	protected void setDefaultThirtyMaxConstant(int constant) {
		defaultThirtyMaxConstant = constant;
	}

	public int getDefaultFiftyMaxConstant() {
		return defaultFiftyMaxConstant;
	}

	protected void setDefaultFiftyMaxConstant(int constant) {
		defaultFiftyMaxConstant = constant;
	}

	private void setMaxConstant(int maxConstant) {
		this.maxConstant = maxConstant;
	}

	private int getDefaultThirtyStartLevel() {
		return defaultThirtyStartLevel;
	}

	protected void setDefaultThirtyStartLevel(int startLevel) {
		defaultThirtyStartLevel = startLevel;
	}

	public int getDefaultFiftyStartLevel() {
		return defaultFiftyStartLevel;
	}

	protected void setDefaultFiftyStartLevel(int startLevel) {
		defaultFiftyStartLevel = startLevel;
	}

	private void setStartLevel(int startLevel) {
		this.startLevel = startLevel;
	}

	private int getDefaultThirtyMaxLevel() {
		return defaultThirtyMaxLevel;
	}

	protected void setDefaultThirtyMaxLevel(int maxLevel) {
		defaultThirtyMaxLevel = maxLevel;
	}

	public int getDefaultFiftyMaxLevel() {
		return defaultFiftyMaxLevel;
	}

	protected void setDefaultFiftyMaxLevel(int maxLevel) {
		defaultFiftyMaxLevel = maxLevel;
	}

	private void setMaxLevel(int maxLevel) {
		if (isMaxLevelOne()) {
			this.maxLevel = 1;
		} else {
			this.maxLevel = maxLevel;
		}
	}

	public void setLevelFifty() {
		setConstant(getDefaultFiftyConstant());
		setModifier(getDefaultFiftyModifier());
		setMaxConstant(getDefaultFiftyMaxConstant());
		setStartLevel(getDefaultFiftyStartLevel());
		setMaxLevel(getDefaultFiftyMaxLevel());
		setWeight(null);
	}

	public void setLevelThirty() {
		setConstant(getDefaultThirtyConstant());
		setModifier(getDefaultThirtyModifier());
		setMaxConstant(getDefaultThirtyMaxConstant());
		setStartLevel(getDefaultThirtyStartLevel());
		setMaxLevel(getDefaultThirtyMaxLevel());
		setWeight(null);
	}

	public void setCustom(int constant, int modifier, int maxConstant, int startLevel, int maxLevel, Weight weight) {
		setConstant(constant);
		setModifier(modifier);
		setMaxConstant(maxConstant);
		setStartLevel(startLevel);
		setMaxLevel(maxLevel);
		setWeight(weight);
	}

	public boolean isMaxLevelOne() {
		return maxLevelOne;
	}

	public void setMaxLevelOne(boolean maxLevelOne) {
		this.maxLevelOne = maxLevelOne;
	}

	public int getDefaultWeight() {
		return defaultWeight.getWeight();
	}
	
	public String getDefaultWeightName() {
		return defaultWeight.getName();
	}

	public void setDefaultWeight(Weight defaultWeight) {
		this.defaultWeight = defaultWeight;
		this.weight = defaultWeight;
	}

	protected void setWeight(Weight weight) {
		if(weight != null) {
			this.weight = weight;
		} else {
			this.weight = this.defaultWeight;
		}
	}

	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}

	protected void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
		this.displayName = defaultDisplayName;
	}

	public List<Material> getDisabledItems() {
		return disabledItems;
	}

	public void setDisabledItems(List<Material> disabledItems) {
		this.disabledItems = disabledItems;
	}
	
	public List<String> getDisabledItemsStrings(){
		List<String> names = new ArrayList<String>();
		for(Material item : getDisabledItems()) {
			names.add(item.name());
		}
		return names;
	}

}
