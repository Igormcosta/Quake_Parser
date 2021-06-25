package com.company.parser;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Parser {
    public Parser(String log) throws IOException {
        int gamerCount = 0;
        BufferedReader br = new BufferedReader(new FileReader(log));
        for (String line; (line = br.readLine()) != null; ) {
            //leitura linha por linha

            if (line.contains("InitGame:")) {
                // o jogo inicia
                do {
                    System.out.println(line);
                    line = br.readLine();
                } while (!(line.contains("ShutdownGame:")));
                //termina quando encontrar "ShutdownGame:"
            }
        }
    }

    private String Parts(String line) {
        String[] parts;
        return null;
    }

}
