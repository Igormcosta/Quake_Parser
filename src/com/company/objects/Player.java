package com.company.objects;

public class Player {
    private String ID;
    private String name;
    private int kills;

    public Player(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object obj) {
        final Player other = (Player) obj;
        return (this.ID.equals(other.ID));
    }
}
