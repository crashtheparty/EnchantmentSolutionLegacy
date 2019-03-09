package org.ctp.enchantmentsolution.nms.abilities;

import java.util.Arrays;
import java.util.List;

import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.ctp.enchantmentsolution.EnchantmentSolution;

public class IronDefenseContacts {

	public static List<DamageCause> getDamageCauses(){
		if(EnchantmentSolution.getPlugin().getBukkitVersion().getVersionNumber() > 6) {
			return Arrays.asList(DamageCause.BLOCK_EXPLOSION, DamageCause.CONTACT, DamageCause.CUSTOM, DamageCause.ENTITY_ATTACK,
					DamageCause.ENTITY_EXPLOSION, DamageCause.ENTITY_SWEEP_ATTACK, DamageCause.LIGHTNING, DamageCause.PROJECTILE, DamageCause.THORNS);
		}
		return Arrays.asList(DamageCause.BLOCK_EXPLOSION, DamageCause.CONTACT, DamageCause.CUSTOM, DamageCause.ENTITY_ATTACK,
				DamageCause.ENTITY_EXPLOSION, DamageCause.LIGHTNING, DamageCause.PROJECTILE, DamageCause.THORNS);
	}
}
