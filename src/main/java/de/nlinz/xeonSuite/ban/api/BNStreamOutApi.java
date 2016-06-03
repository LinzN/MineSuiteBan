package de.nlinz.xeonSuite.ban.api;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import de.nlinz.javaSocket.client.api.XeonSocketClientManager;
import de.nlinz.xeonSuite.ban.listener.XeonBan;

public class BNStreamOutApi {

	public static void permaBan(String player, String reason, String bannedBy) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream out = XeonSocketClientManager.createChannel(bytes, XeonBan.channelName);
		try {
			out.writeUTF("PermaBan");
			out.writeUTF(player);
			out.writeUTF(reason);
			out.writeUTF(bannedBy);
		} catch (IOException e) {
			e.printStackTrace();
		}

		XeonSocketClientManager.sendData(bytes);
	}

	public static void permaMute(String player, String reason, String mutedBy) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream out = XeonSocketClientManager.createChannel(bytes, XeonBan.channelName);
		try {
			out.writeUTF("PermaMute");
			out.writeUTF(player);
			out.writeUTF(reason);
			out.writeUTF(mutedBy);
		} catch (IOException e) {
			e.printStackTrace();
		}

		XeonSocketClientManager.sendData(bytes);
	}

	public static void tempBan(String player, String reason, String bannedBy, long seconds) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream out = XeonSocketClientManager.createChannel(bytes, XeonBan.channelName);
		try {
			out.writeUTF("TempBan");
			out.writeUTF(player);
			out.writeUTF(reason);
			out.writeUTF(bannedBy);
			out.writeLong(seconds);
		} catch (IOException e) {
			e.printStackTrace();
		}

		XeonSocketClientManager.sendData(bytes);
	}

	public static void tempMute(String player, String reason, String mutedBy, long seconds) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream out = XeonSocketClientManager.createChannel(bytes, XeonBan.channelName);
		try {
			out.writeUTF("TempMute");
			out.writeUTF(player);
			out.writeUTF(reason);
			out.writeUTF(mutedBy);
			out.writeLong(seconds);
		} catch (IOException e) {
			e.printStackTrace();
		}

		XeonSocketClientManager.sendData(bytes);
	}

	public static void kick(String player, String reason, String kickedby) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream out = XeonSocketClientManager.createChannel(bytes, XeonBan.channelName);
		try {
			out.writeUTF("kick");
			out.writeUTF(player);
			out.writeUTF(reason);
			out.writeUTF(kickedby);

		} catch (IOException e) {
			e.printStackTrace();
		}

		XeonSocketClientManager.sendData(bytes);
	}

	public static void unBan(String player, String reason, String unBannedby) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream out = XeonSocketClientManager.createChannel(bytes, XeonBan.channelName);
		try {
			out.writeUTF("unban");
			out.writeUTF(player);
			out.writeUTF(reason);
			out.writeUTF(unBannedby);

		} catch (IOException e) {
			e.printStackTrace();
		}

		XeonSocketClientManager.sendData(bytes);
	}

	public static void unMute(String player, String reason, String unMutedby) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream out = XeonSocketClientManager.createChannel(bytes, XeonBan.channelName);
		try {
			out.writeUTF("unmute");
			out.writeUTF(player);
			out.writeUTF(reason);
			out.writeUTF(unMutedby);

		} catch (IOException e) {
			e.printStackTrace();
		}

		XeonSocketClientManager.sendData(bytes);
	}

}
