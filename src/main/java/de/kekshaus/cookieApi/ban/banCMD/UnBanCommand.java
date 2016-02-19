package de.kekshaus.cookieApi.ban.banCMD;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.kekshaus.cookieApi.ban.Banplugin;
import de.kekshaus.cookieApi.ban.api.BNStreamOutApi;
import de.kekshaus.cookieApi.bukkit.MessageDB;

public class UnBanCommand implements CommandExecutor {
	public ThreadPoolExecutor executorServiceCommands = new ThreadPoolExecutor(1, 1, 250L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>());

	public UnBanCommand(Banplugin instance) {

	}

	public boolean onCommand(final CommandSender sender, Command cmd, String label, final String[] args) {
		if (sender.hasPermission("cookieApi.ban.unban")) {
			this.executorServiceCommands.submit(new Runnable() {
				public void run() {
					if (args.length >= 0)
						if (args.length >= 2) {
							String reasonarg = "";
							for (int i = 1; i < args.length; i++) {
								String arg = args[i] + " ";
								reasonarg = reasonarg + arg;
							}
							BNStreamOutApi.unBan(args[0], reasonarg, sender.getName());
						} else {
							sender.sendMessage("/unban <Playername> <Grund>");
						}

				}
			});
		} else {
			sender.sendMessage(MessageDB.NO_PERMISSIONS);
		}
		return false;
	}
}
