package com.company.main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.company.objects.Game;
import com.company.parser.Parser;

public class Main {

    public static void main(String[] args) {
        File arq = new File("C:\\Users\\PICHAU\\IdeaProjects\\Quake Parser\\src\\com\\company\\main\\games.log");
        //diretorio do log
        try {
            Parser sc = new Parser(arq.getPath());
            Scanner s = new Scanner(System.in);
            System.out.println("Menu:");
            int op, QTD = 0;
            do {
                System.out.println("1-Buscar por ID de jogo");
                System.out.println("2-Mostrar tudo");
                System.out.println("3-Remover Jogo");
                System.out.println("0-SAIR");
                op = s.nextInt();
                s.nextLine();
                Game aux;

                switch (op) {
                    case 1:
                        System.out.println("Digite o ID");
                        op = s.nextInt();
                        aux = new Game(op);
                        if (sc.getGames().contains(aux)) {
                            System.out.println("\n" + sc.getGames().get(sc.getGames().indexOf(aux)) + "\n");
                        } else {
                            System.out.println("jogo não encontrado");
                        }
                        break;
                    case 2:
                        System.out.println("\n" + sc.getGames() + "\n");
                        break;
                    case 3:
                        System.out.println("Digite o ID");
                        op = s.nextInt();
                        aux = new Game(op);
                        if (sc.getGames().contains(aux)) {
                            System.out.println("jogo " + aux.getID() + " Removido");
                            sc.getGames().remove(aux);
                        } else {
                            System.out.println("jogo não encontrado");
                        }
                        break;
                    case 0:
                        System.out.println("FIM");
                        break;
                    default:
                        System.out.println("Valor invalido");
                        break;
                }
            } while (op != 0);
        } catch (IOException ex) {
            System.out.println("Erro ao carregar arquivo");
        }

    }
}

