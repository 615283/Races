package com.georlegacy.general.races.setup;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MapRegionSet {

    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You need to provide a map to edit and other required arguments. Use &4/races help setup &7to see help on this command."));
            return;
        }
        if (args.length == 2) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You need to provide the position you wish to set for the barrier. Use &4/races help setup &7to see help on this command."));
            return;
        }

    }

}
