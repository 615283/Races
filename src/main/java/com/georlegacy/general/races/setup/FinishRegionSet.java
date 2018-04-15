package com.georlegacy.general.races.setup;

import com.georlegacy.general.races.maps.Map;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class FinishRegionSet {

    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You need to provide a map to edit and other required arguments. Use &4/races help setup &7to see help on this command."));
            return;
        }
        if (args.length == 2) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You need to provide the position you wish to set for the finish line. Use &4/races help setup &7to see help on this command."));
            return;
        }
        if (args.length == 3||args.length == 4) {
            Map map = Map.getByName(args[1]);
            if (map==null) {
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
            if (args.length == 3) {
                String loc = player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation();
                if (args[2].equals("1")) {
                    map.setBarrierP1(player.getLocation().toVector());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSuccess! &7The 1st position for the finish line has been set to &4" + loc + "&7."));
                    if (map.isSetup()) {
                        map.setSetup(false);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lWarning! &7This map has already finalised setup and will need to be finalised again. It will not be playable until this is done."));
                    }
                    return;
                }
                if (args[2].equals("2")) {
                    map.setBarrierP2(player.getLocation().toVector());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSuccess! &7The 2nd position for the finish line has been set to &4" + loc + "&7."));
                    if (map.isSetup()) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lWarning! &7This map has already finalised setup and will need to be finalised again. It will not be playable until this is done."));
                    }
                    return;
                }
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &4" + args[2] + " &7 isn't a valid position number. Use &4/races help setup &7to see help on this command."));
                return;
            }
            if (args.length == 4) {
                String[] coords = args[3].split(",");
                try {
                    Integer.parseInt(coords[0]);
                    Integer.parseInt(coords[1]);
                    Integer.parseInt(coords[2]);
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You appear to have formatted coordinates incorrectly. Use &4/races help setup to see help on this command.&7"));
                    return;
                }
                if (!(coords.length == 3)) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You appear to have formatted coordinates incorrectly. Use &4/races help setup to see help on this command.&7"));
                    return;
                }
                if (args[2].equals("1")) {
                    map.setBarrierP1(new Vector(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2])));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSuccess! &7The 1st position for the finish line has been set to &4" + coords[0] + ", " + coords[1] + ", " + coords[2] + "&7."));
                    if (map.isSetup()) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lWarning! &7This map has already finalised setup and will need to be finalised again. It will not be playable until this is done."));
                    }
                    return;
                }
                if (args[2].equals("2")) {
                    map.setBarrierP2(new Vector(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2])));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSuccess! &7The 2nd position for the finish line has been set to &4" + coords[0] + ", " + coords[1] + ", " + coords[2] + "&7."));
                    if (map.isSetup()) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lWarning! &7This map has already finalised setup and will need to be finalised again. It will not be playable until this is done."));
                    }
                    return;
                }
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &4" + args[2] + " &7 isn't a valid position number. Use &4/races help setup &7to see help on this command."));
                return;
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You appear to have provided too many arguments. Use &4/races help setup &7to see help on this command."));
        }

    }

}
