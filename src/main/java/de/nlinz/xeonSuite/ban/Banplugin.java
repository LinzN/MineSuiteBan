package de.nlinz.xeonSuite.ban;

import org.bukkit.plugin.java.JavaPlugin;

import de.nlinz.javaSocket.client.api.XeonSocketClientManager;
import de.nlinz.xeonSuite.ban.banCMD.BanCommand;
import de.nlinz.xeonSuite.ban.banCMD.TempBanCommand;
import de.nlinz.xeonSuite.ban.banCMD.UnBanCommand;
import de.nlinz.xeonSuite.ban.listener.XeonBan;
import de.nlinz.xeonSuite.ban.muteCMD.MuteCommand;
import de.nlinz.xeonSuite.ban.muteCMD.TempMuteCommand;
import de.nlinz.xeonSuite.ban.muteCMD.UnMuteCommand;
import de.nlinz.xeonSuite.ban.otherCMD.KickCommand;

public class Banplugin extends JavaPlugin {
	private static Banplugin inst;

	@Override
	public void onEnable() {
		inst = this;

		loadCommands();
		XeonSocketClientManager.registerDataListener(new XeonBan());
	}

	@Override
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
