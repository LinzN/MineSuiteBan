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

import de.linzn.jSocket.core.IncomingDataListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;


public class JClientBanListener implements IncomingDataListener {


    @Override
    public void onEvent(String channel, UUID clientUUID, byte[] dataInBytes) {
        // TODO Auto-generated method stub
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(dataInBytes));
        String subChannel;
        try {
            subChannel = in.readUTF();
            if (subChannel.equals("server_ban_notify")) {
                String getMessage = in.readUTF();
                System.out.println(getMessage);
                String reason = in.readUTF();
                System.out.println(reason);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.hasPermission("mineSuite.ban.notifyinfo")) {
                        p.sendMessage(getMessage);
                        if (!reason.equalsIgnoreCase("none")) {
                            p.sendMessage(reason);
                        }
                    }
                }
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
