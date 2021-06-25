package com.company.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Parser {
    public Parser(String log) throws IOException {
        String txtConteudo;
        txtConteudo = new String(Files.readAllBytes(Paths.get(log)), StandardCharsets.UTF_8);
        System.out.println(txtConteudo);
    }
}
