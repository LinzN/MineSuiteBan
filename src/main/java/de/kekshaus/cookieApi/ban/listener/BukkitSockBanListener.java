package de.kekshaus.cookieApi.ban.listener;

import java.io.DataInputStream;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.keks.socket.bukkit.events.plugin.BukkitSockBanEvent;
import de.keks.socket.core.ByteStreamConverter;

public class BukkitSockBanListener implements Listener {

	@EventHandler
	public void onBukkitSockBanEvent(final BukkitSockBanEvent e) {

		DataInputStream in = ByteStreamConverter.toDataInputStream(e.readBytes());
		String task = null;
		try {
			task = in.readUTF();
			if (task.equals("SendActionMessage")) {
				String getMessage = in.readUTF();
				String reason = in.readUTF();
				Bukkit.getConsoleSender().sendMessage(getMessage);
				Bukkit.getConsoleSender().sendMessage(reason);
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("cookieApi.ban.notifyinfo")) {
						p.sendMessage(getMessage);
						p.sendMessage(reason);
					}
				}
			}
			if (task.equals("SendDeActionMessage")) {
				String getMessage = in.readUTF();
				Bukkit.getConsoleSender().sendMessage(getMessage);

				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("cookieApi.ban.notifyinfo")) {
						p.sendMessage(getMessage);
					}
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
