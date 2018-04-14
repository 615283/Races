package com.georlegacy.general.races.setup;

import com.georlegacy.general.races.maps.Map;
import com.google.gson.JsonElement;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.TextComponentSerializer;
import net.minecraft.server.v1_12_R1.ChatMessageType;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.Packet;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class BarrierSet {

    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You need to provide a map to edit and other required arguments. Use &4/races help setup &7to see help on this command."));
            return;
        }
        if (args.length == 2) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7You need to provide the position you wish to set for the barrier. Use &4/races help setup &7to see help on this command."));
            return;
        }
        if (args.length == 3) {
            Map map = Map.getByName(args[1]);
            if (map==null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSorry! &7There doesn't appear to be any map by the name " + args[1] + ". Use &4/races help setup &7to see help on this command."));

                TextComponent text1 = new TextComponent("You can create a map by clicking ");
                text1.setColor(net.md_5.bungee.api.ChatColor.GRAY);
                TextComponent text2 = new TextComponent("here");
                text2.setColor(net.md_5.bungee.api.ChatColor.DARK_RED);
                text2.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/racessetup new " + args[1]));
                TextComponent text3 = new TextComponent(".");
                text3.setColor(net.md_5.bungee.api.ChatColor.GRAY);

                TextComponentSerializer serializer = new TextComponentSerializer();
                JsonElement json1 = serializer.serialize(text1, text1.getClass(), null);
                JsonElement json2 = serializer.serialize(text2, text1.getClass(), null);
                JsonElement json3 = serializer.serialize(text3, text1.getClass(), null);

                String json = "{\"text\":\"You can create a map by clicking \",\"color\":\"gray\"},{\"text\":\"here\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/racessetup new MAPNAME\"}},{\"text\":\".\",\"color\":\"gray\"}";
                Packet packet = new PacketPlayOutChat(ChatSerializer.a(json), ChatMessageType.CHAT);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);

                return;

            }
        }
    }

}
