package com.georlegacy.general.races.commands;

import com.georlegacy.general.races.setup.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommand implements CommandExecutor {
    private BarrierSet barrierSet = new BarrierSet();
    private FinishRegionSet finishRegionSet = new FinishRegionSet();
    private MapRegionSet mapRegionSet = new MapRegionSet();
    private PlayRegionSet playRegionSet = new PlayRegionSet();
    private SpawnPoint spawnPoint = new SpawnPoint();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command cannot be run by the console.");
            return true;
        }
        if (!sender.hasPermission("races.commands.setup")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You don't appear to have permission to execute this command."));
            return true;
        }
        if (args.length==0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You haven't provided the correct arguments for this command. Use &4/races help setup &7to see help on this command."));
            return true;
        }

        String sub = args[0];
        switch (sub) {
            case "barrier":
                barrierSet.execute((Player) sender, args);
                break;
            case "finishline":
                finishRegionSet.execute((Player) sender, args);
                break;
            case "mapregion":
                mapRegionSet.execute((Player) sender, args);
                break;
            case "playregion":
                playRegionSet.execute((Player) sender, args);
                break;
            case "spawnpoint":
                spawnPoint.execute((Player) sender, args);
        }

        return false;
    }

}
