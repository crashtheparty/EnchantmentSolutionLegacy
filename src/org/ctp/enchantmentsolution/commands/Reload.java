package org.ctp.enchantmentsolution.commands;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ctp.enchantmentsolution.EnchantmentSolution;
import org.ctp.enchantmentsolution.nms.listeners.VanishListener_v1;
import org.ctp.enchantmentsolution.nms.listeners.VanishListener_v2;
import org.ctp.enchantmentsolution.utils.ChatUtils;
import org.ctp.enchantmentsolution.utils.save.ConfigFiles;

public class Reload implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = null;
		if(sender instanceof Player) {
			player = (Player) sender;
			if(player.hasPermission("enchantmentsolution.command.reload")) {
				ConfigFiles.reload();
				if(EnchantmentSolution.getBukkitVersion().getVersionNumber() > 8) {
					VanishListener_v2.reload();
				} else {
					VanishListener_v1.reload();
				}
				ChatUtils.sendMessage(player, ChatUtils.getMessage(ChatUtils.getCodes(), "commands.reload"));
			} else {
				ChatUtils.sendMessage(player, ChatUtils.getMessage(ChatUtils.getCodes(), "commands.no-permission"));
			}
		} else {
			ConfigFiles.reload();
			if(EnchantmentSolution.getBukkitVersion().getVersionNumber() > 8) {
				VanishListener_v2.reload();
			} else {
				VanishListener_v1.reload();
			}
			ChatUtils.sendToConsole(Level.INFO, ChatUtils.getMessage(ChatUtils.getCodes(), "commands.reload"));
		}
		return true;
	}

}
