package com.georlegacy.general.races.maps;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private File dataFile;

    private boolean isSetup;
    private String name;
    private String authorName;
    private int maxPlayers;
    private Vector[] spawnPoints;

    private Vector barrierP1;
    private Vector barrierP2;

    private Vector finishP1;
    private Vector finishP2;

    private Vector mapRegionP1;
    private Vector mapRegionP2;

    private Vector playRegionP1;
    private Vector playRegionP2;


    public Map(File f) {
        if (!f.exists()) return;
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


    public boolean isSetup() {
        return isSetup;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public Vector[] getSpawnPoints() {
        return spawnPoints;
    }

    public Vector getBarrierP1() {
        return barrierP1;
    }

    public Vector getBarrierP2() {
        return barrierP2;
    }

    public Vector getFinishP1() {
        return finishP1;
    }

    public Vector getFinishP2() {
        return finishP2;
    }

    public Vector getMapRegionP1() {
        return mapRegionP1;
    }

    public Vector getMapRegionP2() {
        return mapRegionP2;
    }

    public Vector getPlayRegionP1() {
        return playRegionP1;
    }

    public Vector getPlayRegionP2() {
        return playRegionP2;
    }


    public boolean setName(String name) {
        if (this.name.equals(name)) return false;
        this.name = name;
        save(this.dataFile);
        return true;
    }

    public boolean setAuthorName(String name) {
        if (this.authorName.equals(name)) return false;
        this.authorName = name;
        save(this.dataFile);
        return true;
    }

    public boolean setMaxPlayers(int mp) {
        if (this.maxPlayers==mp) return false;
        this.maxPlayers = mp;
        save(this.dataFile);
        return true;
    }

    public boolean addSpawnPoint(Vector spawn) {
        List<Vector> points = new ArrayList<Vector>();
        for (Vector v : this.spawnPoints) {
            if (v.equals(spawn)) return false;
            points.add(v);
        }
        points.add(spawn);
        this.spawnPoints = (Vector[]) points.toArray();
        save(this.dataFile);
        return true;
    }

    public boolean removeSpawnPoint(Vector spawn) {
        boolean wc = false;
        List<Vector> points = new ArrayList<Vector>();
        for (Vector v : this.spawnPoints) {
            if (v.equals(spawn)) {
                wc = true;
                continue;
            }
            points.add(v);
        }
        this.spawnPoints = (Vector[]) points.toArray();
        save(this.dataFile);
        return wc;
    }

    public boolean setBarrierP1(Vector p1) {
        if (this.barrierP1==p1) return false;
        this.barrierP1 = p1;
        save(this.dataFile);
        return true;
    }

    public boolean setBarrierP2(Vector p2) {
        if (this.barrierP2==p2) return false;
        this.barrierP2 = p2;
        save(this.dataFile);
        return true;
    }

    public boolean setFinishP1(Vector p1) {
        if (this.finishP1==p1) return false;
        this.finishP1 = p1;
        save(this.dataFile);
        return true;
    }

    public boolean setFinishP2(Vector p2) {
        if (this.finishP2==p2) return false;
        this.finishP2 = p2;
        save(this.dataFile);
        return true;
    }

    public boolean setMapRegionP1(Vector p1) {
        if (this.mapRegionP1==p1) return false;
        this.mapRegionP1 = p1;
        save(this.dataFile);
        return true;
    }

    public boolean setMapRegionP2(Vector p2) {
        if (this.mapRegionP2==p2) return false;
        this.mapRegionP2 = p2;
        save(this.dataFile);
        return true;
    }

    public boolean setPlayRegionP1(Vector p1) {
        if (this.playRegionP1==p1) return false;
        this.playRegionP1 = p1;
        save(this.dataFile);
        return true;
    }

    public boolean setPlayRegionP2(Vector p2) {
        if (this.playRegionP2==p2) return false;
        this.playRegionP2 = p2;
        save(this.dataFile);
        return true;
    }


    private boolean save(File dataFile) {
        YamlConfiguration mapData = YamlConfiguration.loadConfiguration(dataFile);
        mapData.set("IsSetup", this.isSetup);
        mapData.set("Info.Name", this.name);
        mapData.set("Info.Author", this.authorName);
        mapData.set("GamePlay.MaxPlayers", this.maxPlayers);
        mapData.set("Loading.SpawnPoints", this.spawnPoints);
        mapData.set("Regions.Barrier.Pos1", this.barrierP1);
        mapData.set("Regions.Barrier.Pos2", this.barrierP2);
        mapData.set("Regions.Finish.Pos1", this.finishP1);
        mapData.set("Regions.Finish.Pos2", this.finishP2);
        mapData.set("Regions.Map.Pos1", this.mapRegionP1);
        mapData.set("Regions.Map.Pos2", this.mapRegionP2);
        mapData.set("Regions.Play.Pos1", this.playRegionP1);
        mapData.set("Regions.Play.Pos2", this.playRegionP2);
        try {
            mapData.save(dataFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
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
