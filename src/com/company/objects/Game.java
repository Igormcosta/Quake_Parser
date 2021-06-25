package com.company.objects;

import java.util.LinkedList;

public class Game {
    private int totalKills;
    private int gameNumber;
    private LinkedList<Player> Players;

    public Game(int gameNumber) {
        this.gameNumber = gameNumber;
        Players = new LinkedList<>();
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public LinkedList<Player> getPlayers() {
        return Players;
    }

    @Override
    public String toString() {
        return "Game" + "_" + gameNumber + "{" +
                "totalKills:" + totalKills + ";" +
                "/n, Players:" + Players +
                '}';
    }
}
