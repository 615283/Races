package com.georlegacy.general.races.maps;

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

        this.dataFile = f;
        this.isSetup = mapData.getBoolean("IsSetup");
        this.name = mapData.getString("Info.Name");
        this.authorName = mapData.getString("Info.Author");
        this.maxPlayers = mapData.getInt("GamePlay.MaxPlayers");
        this.spawnPoints = this.parseVector((String[]) mapData.getStringList("Loading.SpawnPoints").toArray());
        this.barrierP1 = this.parseVector(mapData.getString("Regions.Barrier.Pos1"));
        this.barrierP2 = this.parseVector(mapData.getString("Regions.Barrier.Pos2"));
        this.finishP1 = this.parseVector(mapData.getString("Regions.Finish.Pos1"));
        this.finishP2 = this.parseVector(mapData.getString("Regions.Finish.Pos2"));
        this.mapRegionP1 = this.parseVector(mapData.getString("Regions.Map.Pos1"));
        this.mapRegionP2 = this.parseVector(mapData.getString("Regions.Map.Pos2"));
        this.playRegionP1 = this.parseVector(mapData.getString("Regions.Play.Pos1"));
        this.playRegionP2 = this.parseVector(mapData.getString("Regions.Play.Pos2"));
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

    private Vector parseVector(String s) {
        String[] coords = s.split(";");
        return new Vector(
                Integer.parseInt(coords[0]),
                Integer.parseInt(coords[1]),
                Integer.parseInt(coords[2])
        );
    }

}
