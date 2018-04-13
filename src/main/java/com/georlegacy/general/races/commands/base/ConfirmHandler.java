package com.georlegacy.general.races.commands.base;

import com.georlegacy.general.races.util.ConfirmAction;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ConfirmHandler {

    private HashMap<Player, ConfirmAction> actions = new HashMap<Player, ConfirmAction>();

    public HashMap<Player, ConfirmAction> getActions() {
        return actions;
    }

    public void addAction(Player p, ConfirmAction a) {
        actions.put(p, a);
        runTimer(p);
    }

    public void removeAction(Player p) {
        actions.remove(p);
    }

    private void runTimer(Player p) {
        try { Thread.sleep(10000); }
        catch (InterruptedException e) { e.printStackTrace(); }
        actions.remove(p);
    }

}
