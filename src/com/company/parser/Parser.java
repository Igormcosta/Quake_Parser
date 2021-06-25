package com.company.parser;

import com.company.objects.Game;
import com.company.objects.Player;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

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
                        //alguem se conectou
                        g = playerSave(line, g);

                    }

                   /* if (line.contains("Kill:")) {
                        //encontrou uma kill
                        if (line.contains("<world>")) {
                            //kill do "<world>"
                        } else {
                            //kill de player
                            Player aux = new Player(Killer(line));
                            g.Kills(aux);
                        }

                    }*/
                    line = br.readLine();
                } while (!(line.contains("ShutdownGame:")));
                //termina quando encontrar "ShutdownGame:"
                System.out.println(g);
                System.out.println("");
            }

        }
    }

    private Game playerSave(String line, Game g) {
        //adiciona players ao game
        line = line.substring(line.indexOf("n\\") + 2, line.indexOf("\\t"));
        Player aux = new Player(line);
        if (!g.getPlayers().contains(aux)) {
            //testa se o player ja existe e não adiciona de novo
            g.getPlayers().add(aux);
        }
        System.out.println(aux);
        return g;
    }

    private String Killer(String line) {
        //encontrar o nome do "killer"
        String aux = line.substring(line.indexOf("Kill:"));
        String[] parts = aux.split(":");
        aux = parts[parts.length - 1].trim();
       /* for (int i = 0; i < aux.length(); i = i + 1) {
            String aux2;
            if(aux.charAt(i)=" "&&aux.)
        }*/


        return aux;
    }

    private String worldKill(String line) {
        //encontrar o nome do jogador morto
        String aux = line.substring(line.indexOf("killed"));
        String[] parts = aux.split(":");
        aux = parts[parts.length - 1].substring(1);
        return aux;
    }


}
