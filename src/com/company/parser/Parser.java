package com.company.parser;

import com.company.objects.Game;
import com.company.objects.Player;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;

public class Parser {
    public Parser(String log) throws IOException {
        int gameCount = 0;
        BufferedReader br = new BufferedReader(new FileReader(log));
        for (String line; (line = br.readLine()) != null; ) {
            //leitura linha por linha

            if (line.contains("InitGame:")) {
                // o jogo inicia
                gameCount = gameCount + 1;
                Game g = new Game(gameCount);
                do {
                    if (line.contains("ClientUserinfoChanged:")) {
                        playerSave(line, g);


                    }

                    if (line.contains("Kill:")) {
                        //encontrou uma kill
                        if (line.contains("<world>")) {
                            //kill do "<world>"

                        } else {
                            //kill de player


                        }

                    }
                    line = br.readLine();
                } while (!(line.contains("ShutdownGame:")));
                //termina quando encontrar "ShutdownGame:"
                System.out.println(g);
                System.out.println("");
            }

        }
    }

    private Game playerSave(String line, Game g) {
        //adiciona players ao game e altera nomes
        String[] parts = line.split(":");
        String ID = parts[2].trim();
        String nick = ID.substring(ID.indexOf(" n\\")+3, ID.indexOf("\\t"));
        ID = ID.substring(0,ID.indexOf(" "));
        Player aux = new Player(ID, nick);
        if(g.getPlayers().contains(aux)){
            int index = g.getPlayers().indexOf(aux);
            g.getPlayers().get(index).setName(aux.getName());
        }else{
            g.getPlayers().add(aux);
        }
        return null;
    }

    private String Killer(String line) {
        //contabilizando a kill

        return null;
    }

    private String worldKill(String line, Game g) {
        //encontrar o nome do jogador morto

        return null;
    }


}
