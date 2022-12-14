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

package de.linzn.mineSuite.ban.commands;

import de.linzn.mineSuite.ban.BanPlugin;
import de.linzn.mineSuite.ban.socket.JClientBanOutput;
import de.linzn.mineSuite.core.configurations.YamlFiles.GeneralLanguage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class KickCommand implements CommandExecutor {
    public ThreadPoolExecutor executorServiceCommands = new ThreadPoolExecutor(1, 1, 250L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

    public KickCommand(BanPlugin instance) {

    }

    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, final String[] args) {
        if (sender.hasPermission("mineSuite.ban.kick")) {
            this.executorServiceCommands.submit(() -> {
                if (args.length >= 2) {
                    String reasonarg = "";
                    for (int i = 1; i < args.length; i++) {
                        String arg = args[i] + " ";
                        reasonarg = reasonarg + arg;
                    }
                    JClientBanOutput.kick(args[0], reasonarg, sender.getName());
                } else {
                    sender.sendMessage(GeneralLanguage.ban_KICK_USAGE);
                }

            });
        } else {
            sender.sendMessage(GeneralLanguage.global_NO_PERMISSIONS);
        }
        return false;
    }
}
