package com.company.main;

import java.io.File;
import java.io.IOException;

import com.company.parser.Parser;

public class Main {

    public static void main(String[] args) {
        File arq = new File("C:\\Users\\PICHAU\\IdeaProjects\\Quake Parser\\src\\com\\company\\main\\games.log");

        try {
            Parser sc = new Parser(arq.getPath());
        }catch (IOException ex) {
            System.out.println("FIM");
        }

    }
}

