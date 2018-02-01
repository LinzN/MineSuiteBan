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
import de.linzn.mineSuite.ban.utils.TimeParser;
import de.linzn.mineSuite.core.configurations.YamlFiles.GeneralLanguage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class TempMuteCommand implements CommandExecutor {
    public ThreadPoolExecutor executorServiceCommands = new ThreadPoolExecutor(1, 1, 250L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

    public TempMuteCommand(BanPlugin instance) {

    }

    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, final String[] args) {
        if (sender.hasPermission("mineSuite.ban.tempmute")) {
            this.executorServiceCommands.submit(() -> {
                if (args.length >= 3) {

                    long time = TimeParser.parseString(args[1]);
                    if (time == -1) {
                        sender.sendMessage(GeneralLanguage.ban_NO_VALID_TIME);
                        return;
                    }
                    String reasonarg = "";
                    for (int i = 2; i < args.length; i++) {
                        String arg = args[i] + " ";
                        reasonarg = reasonarg + arg;
                    }
                    JClientBanOutput.tempMute(args[0], reasonarg, sender.getName(), time);
                } else {
                    sender.sendMessage(GeneralLanguage.ban_MUTE_TEMP_USAGE);
                }

            });
        } else {
            sender.sendMessage(GeneralLanguage.global_NO_PERMISSIONS);
        }
        return false;
    }
}
