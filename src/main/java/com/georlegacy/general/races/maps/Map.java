package com.georlegacy.general.races.maps;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Map {

    File dataFile;

    boolean isSetup;
    String name;
    String authorName;
    int maxPlayers;
    Vector[] spawnPoints;

    Vector barrierP1;
    Vector barrierP2;

    Vector finishP1;
    Vector finishP2;

    Vector mapRegionP1;
    Vector mapRegionP2;

    Vector playRegionP1;
    Vector playRegionP2;

    public Map(File f) {
        YamlConfiguration mapData = YamlConfiguration.loadConfiguration(f);
        if (!mapData.getBoolean("IsSetup")) {
            return;
        }

        this.isSetup = mapData.getBoolean("IsSetup");
        this.name = mapData.getString("Info.Name");
        this.authorName = mapData.getString("Info.Author");
        this.maxPlayers = mapData.getInt("GamePlay.MaxPlayers");
        this.spawnPoints = this.parseVector((String[]) mapData.getStringList("Loading.SpawnPoints").toArray());
    }

    private Vector[] parseVector(String[] s) {
        List<Vector> v = new ArrayList<Vector>();
        for (String l : s) {
            String[] coords = l.split(";");
            v.add(new Vector(
                    Integer.parseInt(coords[0]),
                    Integer.parseInt(coords[1]),
                    Integer.parseInt(coords[2])
            ));
        }
        return (Vector[]) v.toArray();
    }

}
