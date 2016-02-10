package de.kekshaus.cookieApi.ban;

import org.bukkit.plugin.java.JavaPlugin;

import de.kekshaus.cookieApi.ban.banCMD.BanCommand;
import de.kekshaus.cookieApi.ban.banCMD.TempBanCommand;
import de.kekshaus.cookieApi.ban.banCMD.UnBanCommand;
import de.kekshaus.cookieApi.ban.muteCMD.MuteCommand;
import de.kekshaus.cookieApi.ban.muteCMD.TempMuteCommand;
import de.kekshaus.cookieApi.ban.muteCMD.UnMuteCommand;
import de.kekshaus.cookieApi.ban.otherCMD.KickCommand;

public class Banplugin extends JavaPlugin {
	private static Banplugin inst;

	public void onEnable() {
		inst = this;

		loadCommands();
	}

	public void onDisable() {
	}

	public static Banplugin inst() {
		return inst;
	}

	public void loadCommands() {
		getCommand("ban").setExecutor(new BanCommand(this));
		getCommand("tempban").setExecutor(new TempBanCommand(this));
		getCommand("unban").setExecutor(new UnBanCommand(this));
		getCommand("kick").setExecutor(new KickCommand(this));
		getCommand("mute").setExecutor(new MuteCommand(this));
		getCommand("tempmute").setExecutor(new TempMuteCommand(this));
		getCommand("unmute").setExecutor(new UnMuteCommand(this));
	}

}
