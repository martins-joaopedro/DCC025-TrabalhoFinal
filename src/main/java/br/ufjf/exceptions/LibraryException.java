package br.ufjf.exceptions;

public class LibraryException extends Exception {

    public LibraryException(String message) {
        super("ERRO BIBLIOTECA:" + message);
    }
}
