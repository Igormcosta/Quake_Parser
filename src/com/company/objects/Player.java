package com.company.objects;

public class Player {
    private String name;
    private int kills;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    @Override
    public String toString() {
        return name + ": " + kills;
    }
}
