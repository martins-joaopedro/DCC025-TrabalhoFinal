package br.ufjf.exceptions;

public class ParserExceptions extends Exception {

    public ParserExceptions(String message) {
        super("ERRO NO TRATAMENTO DOS DADOS: " + message);
    }
}
