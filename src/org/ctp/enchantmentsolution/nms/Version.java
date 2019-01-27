package org.ctp.enchantmentsolution.nms;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.ctp.enchantmentsolution.utils.ChatUtils;

public class Version {
	
	public static String VERSION = getVersion();
	public static boolean VERSION_ALLOWED = allowedVersion();
	public static int VERSION_NUMBER;

	private static String getVersion() {
		String a = Bukkit.getVersion();
		String version = a.substring(a.lastIndexOf(':') + 1, a.lastIndexOf(')')).trim();

		return version;
	}
	
	private static boolean allowedVersion() {
		
		VERSION_NUMBER = 0;
		
		// Version
		ChatUtils.sendToConsole(Level.INFO, "Version:  " + VERSION);

		// Check
		switch(VERSION) {
		case "1.9":
			VERSION_NUMBER = 1;
			return true;
		case "1.9.2":
			VERSION_NUMBER = 2;
			return true;
		case "1.9.4":
			VERSION_NUMBER = 3;
			return true;
		case "1.10":
			VERSION_NUMBER = 4;
			return true;
		case "1.10.2":
			VERSION_NUMBER = 5;
			return true;
		case "1.11":
			VERSION_NUMBER = 6;
			return true;
		case "1.11.1":
			VERSION_NUMBER = 7;
			return true;
		case "1.11.2":
			VERSION_NUMBER = 8;
			return true;
		case "1.12":
			VERSION_NUMBER = 9;
			return true;
		case "1.12.1":
			VERSION_NUMBER = 10;
			return true;
		case "1.12.2":
			VERSION_NUMBER = 11;
			return true;
		}
		return false;
	}
}
