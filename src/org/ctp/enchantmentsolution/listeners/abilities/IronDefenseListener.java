package org.ctp.enchantmentsolution.listeners.abilities;

import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.DefaultEnchantments;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.nms.abilities.IronDefenseContacts;

public class IronDefenseListener extends EnchantmentListener{
	
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if(!canRun(DefaultEnchantments.IRON_DEFENSE, event)) return;
		if(!IronDefenseContacts.getDamageCauses().contains(event.getCause())) return;
		Entity attacked = event.getEntity();
		Entity attacker = event.getDamager();
		if(attacker instanceof AreaEffectCloud) return;
		if(attacked instanceof HumanEntity){
			HumanEntity player = (HumanEntity) attacked;
			ItemStack shield = player.getEquipment().getItemInOffHand();
			if(shield == null) return;
			if(player.isBlocking()) return;
			if(Enchantments.hasEnchantment(shield, DefaultEnchantments.IRON_DEFENSE)){
				int level = Enchantments.getLevel(shield, DefaultEnchantments.IRON_DEFENSE);
				double percentage = .1 + .05 * level;
				double damage = event.getDamage() * percentage;
				event.setDamage(event.getDamage() - damage);
				int shieldDamage = (int) damage;
				if(shieldDamage < damage) shieldDamage += 1;
				super.damageItem(player, shield, shieldDamage);
			}
		}
	}
}
