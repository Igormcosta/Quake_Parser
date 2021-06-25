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

    public void Kills(Player p) {
        //aumenta o total de kills e adiciona o player
        this.totalKills = this.totalKills + 1;
        if (Players.contains(p)) {
            int index = Players.indexOf(p);
            int kill = Players.get(index).getKills() + 1;
            Players.get(index).setKills(kill);
        } else {
            p.setKills(1);
            Players.add(p);
        }

    }
    public void worldKills(){

    }

    @Override
    public String toString() {
        return "Game" + "_" + gameNumber + "{" +
                "totalKills:" + totalKills + ";" +
                "/n, Players:" + Players +
                '}';
    }
}
