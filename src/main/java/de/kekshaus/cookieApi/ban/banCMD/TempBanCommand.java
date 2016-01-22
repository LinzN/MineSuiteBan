package de.kekshaus.cookieApi.ban.banCMD;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.kekshaus.cookieApi.ban.Banplugin;
import de.kekshaus.cookieApi.ban.utils.TimeParser;
import de.kekshaus.cookieApi.bukkit.MessageDB;
import de.kekshaus.cookieApi.bukkit.managerApi.BanApi;

public class TempBanCommand implements CommandExecutor {
	public ThreadPoolExecutor executorServiceCommands = new ThreadPoolExecutor(1, 1, 250L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>());

	public TempBanCommand(Banplugin instance) {

	}

	public boolean onCommand(final CommandSender sender, Command cmd, String label, final String[] args) {
		if (sender.hasPermission("cookieApi.ban.tempban")) {
			this.executorServiceCommands.submit(new Runnable() {
				public void run() {
					if (args.length >= 0)
						if (args.length >= 3) {

							long time = TimeParser.parseString(args[1]);
							if (time == -1) {
								sender.sendMessage("Keine gültige Zeitangabe!");
								return;
							}
							String reasonarg = "";
							for (int i = 2; i < args.length; i++) {
								String arg = args[i] + " ";
								reasonarg = reasonarg + arg;
							}
							BanApi.tempBan(args[0], reasonarg, sender.getName(), time);
						} else {
							sender.sendMessage("/tempban <Playername> <Time> <Grund>");
						}

				}
			});
		} else {
			sender.sendMessage(MessageDB.NO_PERMISSIONS);
		}
		return false;
	}
}
