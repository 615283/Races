package com.georlegacy.general.races.setup;

import com.georlegacy.general.races.maps.Map;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SpawnPoint {

    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You need to provide a map to edit and other required arguments. Use &4/races help setup &7to see help on this command."));
            return;
        }
        if (args.length == 3||args.length == 4) {
            Map map = Map.getByName(args[1]);
            if (map == null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7There doesn't appear to be any map by the name &4" + args[1] + "&7. Use &4/races help setup &7to see help on this command."));

                TextComponent text1 = new TextComponent("You can also create a map by clicking ");
                text1.setColor(net.md_5.bungee.api.ChatColor.GRAY);
                TextComponent text2 = new TextComponent("here");
                text2.setColor(net.md_5.bungee.api.ChatColor.DARK_RED);
                text2.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/racessetup new " + args[1]));
                TextComponent text3 = new TextComponent(".");
                text3.setColor(net.md_5.bungee.api.ChatColor.GRAY);

                player.spigot().sendMessage(text1, text2, text3);
                return;
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You appear to have provided too many arguments. Use &4/races help setup &7to see help on this command."));
        }
        String action = args[2];
        switch (action) {
            case "add" :

                break;
            case "remove" :

                break;
            default :
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You appear to have provided incorrect arguments. Use &4/races help setup &7to see help on this command."));
                break;
        }
    }

}
