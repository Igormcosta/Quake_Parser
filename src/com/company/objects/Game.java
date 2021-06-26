package com.company.objects;

import java.util.LinkedList;

public class Game {
    private int totalKills;
    private int ID;
    private LinkedList<Player> Players;

    public Game(int ID) {
        this.ID = ID;
        Players = new LinkedList<>();
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getID() {
        return ID;
    }

    public LinkedList<Player> getPlayers() {
        return Players;
    }


    public void Kills(Player p) {
        //aumenta o total de kills global se pessoais
        this.totalKills = this.totalKills + 1;
        int index = Players.indexOf(p);
        int kill = Players.get(index).getKills() + 1;
        Players.get(index).setKills(kill);
    }

    public void worldKills(Player p) {
        //aumenta a quantidade de kills total e diminui em 1 do jogador que morreu
        this.totalKills = this.totalKills + 1;
        int index = Players.indexOf(p);
        int kill = (Players.get(index).getKills()) - 1;
        if (kill < 0) {
            //não pode ter kills negativas
            kill = 0;
        }
        Players.get(index).setKills(kill);
    }


    @Override
    public String toString() {
        return "Game" + "_" + ID + ": {\n" +
                "totalKills: " + totalKills + ";" +
                "\nPlayers e kills: " + Players +
                "\n}";
    }

    @Override
    public boolean equals(Object obj) {
        final Game other = (Game) obj;
        return (this.ID == other.ID);
    }
}
