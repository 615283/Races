//Base archetype by James Conway (615283)

package com.georlegacy.general.races;

import com.georlegacy.general.races.commands.SetupCommand;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Races extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();

        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        PluginCommand races = getCommand("races");

        PluginCommand racesSetup = getCommand("racessetup");
        racesSetup.setExecutor(new SetupCommand());
    }

    public static WorldEditPlugin getWorldEdit() {
        return (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
    }

}
