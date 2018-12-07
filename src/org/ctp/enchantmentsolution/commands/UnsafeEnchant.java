package org.ctp.enchantmentsolution.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.ctp.enchantmentsolution.enchantments.CustomEnchantment;
import org.ctp.enchantmentsolution.enchantments.Enchantments;
import org.ctp.enchantmentsolution.utils.ChatUtils;

import net.md_5.bungee.api.ChatColor;

public class UnsafeEnchant implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("enchantmentsolution.command.enchantunsafe")) {
				if(args.length > 0){
					String enchantmentName = args[0];
					for(CustomEnchantment enchant : Enchantments.getEnchantments()){
						if(enchant.getName().equalsIgnoreCase(enchantmentName)){
							int level = 1;
							if(args.length > 1){
								try{
									level = Integer.parseInt(args[1]);
									if (level < 1) {
										ChatUtils.sendMessage(player, "Cannot set a negative or 0 level. Setting level to 1.");
										level = 1;
									}
								}catch(NumberFormatException ex){
									ChatUtils.sendMessage(player, args[1] + " is not a valid level. Setting level to 1.");
								}
							}
							ItemStack itemToEnchant = player.getInventory().getItemInMainHand();
							if(itemToEnchant != null){
								itemToEnchant = Enchantments.addEnchantmentToItem(itemToEnchant, enchant, level);
								player.getInventory().setItemInMainHand(itemToEnchant);
								ChatUtils.sendMessage(player, "Enchantment with name " + enchant.getDisplayName() + " with level " + level + " has been added to the item.");
							}else{
								ChatUtils.sendMessage(player, "You must try to enchant an item.");
							}
							return true;
						}
					}
					ChatUtils.sendMessage(player, "Enchantment with name " + enchantmentName + " not found.");
				}else{
					ChatUtils.sendMessage(player, "You must specify an enchantment.");
				}
			}else {
				ChatUtils.sendMessage(player, ChatColor.RED + "You do not have permission to use this command!");
			}
		}
		return true;
	}
}
