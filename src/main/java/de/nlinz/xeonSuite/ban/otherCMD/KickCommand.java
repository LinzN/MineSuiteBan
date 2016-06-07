package de.nlinz.xeonSuite.ban.otherCMD;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.nlinz.xeonSuite.ban.Banplugin;
import de.nlinz.xeonSuite.ban.api.BNStreamOutApi;
import de.nlinz.xeonSuite.bukkit.utils.languages.GlobalLanguage;

public class KickCommand implements CommandExecutor {
	public ThreadPoolExecutor executorServiceCommands = new ThreadPoolExecutor(1, 1, 250L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>());

	public KickCommand(Banplugin instance) {

	}

	@Override
	public boolean onCommand(final CommandSender sender, Command cmd, String label, final String[] args) {
		if (sender.hasPermission("xeonSuite.ban.kick")) {
			this.executorServiceCommands.submit(new Runnable() {
				@Override
				public void run() {
					if (args.length >= 0)
						if (args.length >= 2) {
							String reasonarg = "";
							for (int i = 1; i < args.length; i++) {
								String arg = args[i] + " ";
								reasonarg = reasonarg + arg;
							}
							BNStreamOutApi.kick(args[0], reasonarg, sender.getName());
						} else {
							sender.sendMessage("/kick <Playername> <Grund>");
						}

				}
			});
		} else {
			sender.sendMessage(GlobalLanguage.NO_PERMISSIONS);
		}
		return false;
	}
}
