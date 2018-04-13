package com.georlegacy.general.races.setup;

import com.georlegacy.general.races.Races;
import com.georlegacy.general.races.util.ConfirmAction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class NewMap {

    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You need to provide a map to edit and other required arguments. Use &4/races help setup &7to see help on this command.s"));
            return;
        }

        Races.getPlugin().getConfirmHandler().addAction(player, new ConfirmAction() {
            @Override
            public void confirm() {

            }

            @Override
            public void cancel() {

            }
        });

    }

}
