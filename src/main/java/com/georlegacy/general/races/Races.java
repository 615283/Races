//Base archetype by James Conway (615283)

package com.georlegacy.general.races;

import com.georlegacy.general.races.commands.CancelCommand;
import com.georlegacy.general.races.commands.ConfirmCommand;
import com.georlegacy.general.races.commands.SetupCommand;
import com.georlegacy.general.races.commands.base.ConfirmHandler;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Races extends JavaPlugin {

    private ConfirmHandler confirmHandler = new ConfirmHandler();
    public ConfirmHandler getConfirmHandler() {
        return confirmHandler;
    }

    public static Races instance;

    @Override
    public void onEnable() {
        instance = this;

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

        PluginCommand racesConfirm = getCommand("racesConfirm");
        racesConfirm.setExecutor(new ConfirmCommand());

        PluginCommand racesCancel = getCommand("racesCancel");
        racesCancel.setExecutor(new CancelCommand());
    }

    public static WorldEditPlugin getWorldEdit() {
        return (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
    }

}
