package de.nlinz.xeonSuite.ban.listener;

import java.io.DataInputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.nlinz.javaSocket.client.api.XeonSocketClientManager;
import de.nlinz.javaSocket.client.events.SocketDataEvent;
import de.nlinz.javaSocket.client.interfaces.IDataListener;

public class XeonBan implements IDataListener {

	@Override
	public String getChannel() {
		// TODO Auto-generated method stub
		return channelName;
	}

	public static String channelName = "xeonBan";

	@Override
	public void onDataRecieve(SocketDataEvent event) {
		// TODO Auto-generated method stub
		DataInputStream in = XeonSocketClientManager.readDataInput(event.getStreamBytes());
		String task = null;
		try {
			task = in.readUTF();
			if (task.equals("SendActionMessage")) {
				String getMessage = in.readUTF();
				String reason = in.readUTF();
				Bukkit.getConsoleSender().sendMessage(getMessage);
				Bukkit.getConsoleSender().sendMessage(reason);
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("xeonSuite.ban.notifyinfo")) {
						p.sendMessage(getMessage);
						p.sendMessage(reason);
					}
				}
			}
			if (task.equals("SendDeActionMessage")) {
				String getMessage = in.readUTF();
				Bukkit.getConsoleSender().sendMessage(getMessage);

				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("xeonSuite.ban.notifyinfo")) {
						p.sendMessage(getMessage);
					}
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
