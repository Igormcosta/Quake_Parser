package com.company.parser;

import com.company.objects.Game;
import com.company.objects.Player;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Parser {
    public Parser(String log) throws IOException {
        int gameCount = 1;
        BufferedReader br = new BufferedReader(new FileReader(log));
        for (String line; (line = br.readLine()) != null; ) {
            //leitura linha por linha

            if (line.contains("InitGame:")) {
                // o jogo inicia
                Game g = new Game(gameCount);
                do {
                    if (line.contains("Kill:")) {
                        //encontrou uma kill
                        if (line.contains("<world>")) {
                            //kill do "<world>"
                        } else {
                            //kill de player
                            Player aux = new Player(Killer(line));
                        }

                    }
                    line = br.readLine();
                } while (!(line.contains("ShutdownGame:")));
                //termina quando encontrar "ShutdownGame:"
            }
            gameCount = gameCount + 1;
        }
    }

    private String Killer(String line) {
        //encontrar o nome do "killer"
        String aux = line.substring(line.indexOf("Kill:"), line.indexOf("killed"));
        String[] parts = aux.split(":");
        aux = parts[parts.length - 1].substring(1);
        return aux;
    }


}
