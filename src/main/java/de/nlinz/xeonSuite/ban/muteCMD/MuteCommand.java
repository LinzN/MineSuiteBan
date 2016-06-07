package de.nlinz.xeonSuite.ban.muteCMD;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.nlinz.xeonSuite.ban.Banplugin;
import de.nlinz.xeonSuite.ban.api.BNStreamOutApi;
import de.nlinz.xeonSuite.bukkit.utils.languages.GlobalLanguage;

public class MuteCommand implements CommandExecutor {
	public ThreadPoolExecutor executorServiceCommands = new ThreadPoolExecutor(1, 1, 250L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>());

	public MuteCommand(Banplugin instance) {

	}

	@Override
	public boolean onCommand(final CommandSender sender, Command cmd, String label, final String[] args) {
		if (sender.hasPermission("cookieApi.ban.mute")) {
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
							BNStreamOutApi.permaMute(args[0], reasonarg, sender.getName());
						} else {
							sender.sendMessage("/mute <Playername> <Grund>");
						}

				}
			});
		} else {
			sender.sendMessage(GlobalLanguage.NO_PERMISSIONS);
		}
		return false;
	}
}
