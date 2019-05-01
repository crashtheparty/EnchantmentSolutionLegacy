package org.ctp.enchantmentsolution.version;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.ctp.enchantmentsolution.utils.ChatUtils;

public class BukkitVersion {
	
	private String version = getBukkitVersion();
	private boolean versionAllowed = allowedBukkitVersion();
	private int versionNumber;

	private String getBukkitVersion() {
		String a = Bukkit.getVersion();
		String version = a.substring(a.lastIndexOf(':') + 1, a.lastIndexOf(')')).trim();

		return version;
	}
	
	private boolean allowedBukkitVersion() {
		versionNumber = 0;
		
		// BukkitVersion
		ChatUtils.sendToConsole(Level.INFO, "Bukkit Version: " + version);

		// Check
		switch(version) {
		case "1.9":
			versionNumber = 1;
			return true;
		case "1.9.2":
			versionNumber = 2;
			return true;
		case "1.9.4":
			versionNumber = 3;
			return true;
		case "1.10":
			versionNumber = 4;
			return true;
		case "1.10.2":
			versionNumber = 5;
			return true;
		case "1.11":
			versionNumber = 6;
			return true;
		case "1.11.1":
			versionNumber = 7;
			return true;
		case "1.11.2":
			versionNumber = 8;
			return true;
		case "1.12":
			versionNumber = 9;
			return true;
		case "1.12.1":
			versionNumber = 10;
			return true;
		case "1.12.2":
			versionNumber = 11;
			return true;
		}
		return false;
	}

	public boolean isVersionAllowed() {
		return versionAllowed;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public String getVersion() {
		return version;
	}
}
