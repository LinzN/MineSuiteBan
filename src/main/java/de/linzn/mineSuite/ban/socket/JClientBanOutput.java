/*
 * Copyright (C) 2018. MineGaming - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 *  You should have received a copy of the LGPLv3 license with
 *  this file. If not, please write to: niklas.linz@enigmar.de
 *
 */

package de.linzn.mineSuite.ban.socket;

import de.linzn.mineSuite.core.MineSuiteCorePlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class JClientBanOutput {

    public static void permaBan(String player, String reason, String bannedBy) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("client_ban_perma-ban");
            dataOutputStream.writeUTF(player);
            dataOutputStream.writeUTF(reason);
            dataOutputStream.writeUTF(bannedBy);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MineSuiteCorePlugin.getInstance().getMineJSocketClient().jClientConnection1.writeOutput("mineSuiteBan", byteArrayOutputStream.toByteArray());

    }

    public static void permaMute(String player, String reason, String mutedBy) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("client_ban_perma-mute");
            dataOutputStream.writeUTF(player);
            dataOutputStream.writeUTF(reason);
            dataOutputStream.writeUTF(mutedBy);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MineSuiteCorePlugin.getInstance().getMineJSocketClient().jClientConnection1.writeOutput("mineSuiteBan", byteArrayOutputStream.toByteArray());
    }

    public static void tempBan(String player, String reason, String bannedBy, long seconds) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("client_ban_temp-ban");
            dataOutputStream.writeUTF(player);
            dataOutputStream.writeUTF(reason);
            dataOutputStream.writeUTF(bannedBy);
            dataOutputStream.writeLong(seconds);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MineSuiteCorePlugin.getInstance().getMineJSocketClient().jClientConnection1.writeOutput("mineSuiteBan", byteArrayOutputStream.toByteArray());
    }

    public static void tempMute(String player, String reason, String mutedBy, long seconds) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("client_ban_temp-mute");
            dataOutputStream.writeUTF(player);
            dataOutputStream.writeUTF(reason);
            dataOutputStream.writeUTF(mutedBy);
            dataOutputStream.writeLong(seconds);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MineSuiteCorePlugin.getInstance().getMineJSocketClient().jClientConnection1.writeOutput("mineSuiteBan", byteArrayOutputStream.toByteArray());
    }

    public static void kick(String player, String reason, String kickedby) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("client_ban_kick");
            dataOutputStream.writeUTF(player);
            dataOutputStream.writeUTF(reason);
            dataOutputStream.writeUTF(kickedby);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MineSuiteCorePlugin.getInstance().getMineJSocketClient().jClientConnection1.writeOutput("mineSuiteBan", byteArrayOutputStream.toByteArray());
    }

    public static void unBan(String player, String reason, String unBannedby) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("client_ban_unban");
            dataOutputStream.writeUTF(player);
            dataOutputStream.writeUTF(reason);
            dataOutputStream.writeUTF(unBannedby);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MineSuiteCorePlugin.getInstance().getMineJSocketClient().jClientConnection1.writeOutput("mineSuiteBan", byteArrayOutputStream.toByteArray());
    }

    public static void unMute(String player, String reason, String unMutedby) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("client_ban_unmute");
            dataOutputStream.writeUTF(player);
            dataOutputStream.writeUTF(reason);
            dataOutputStream.writeUTF(unMutedby);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MineSuiteCorePlugin.getInstance().getMineJSocketClient().jClientConnection1.writeOutput("mineSuiteBan", byteArrayOutputStream.toByteArray());
    }

}
