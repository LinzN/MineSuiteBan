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

package de.linzn.mineSuite.ban;


import de.linzn.mineSuite.ban.commands.*;
import de.linzn.mineSuite.ban.socket.JClientBanListener;
import de.linzn.mineSuite.core.MineSuiteCorePlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BanPlugin extends JavaPlugin {
    private static BanPlugin inst;

    public static BanPlugin inst() {
        return inst;
    }

    @Override
    public void onEnable() {
        inst = this;
        loadCommands();
        MineSuiteCorePlugin.getInstance().getMineJSocketClient().jClientConnection1.registerIncomingDataListener("mineSuiteBungee", new JClientBanListener());
    }

    @Override
    public void onDisable() {
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
