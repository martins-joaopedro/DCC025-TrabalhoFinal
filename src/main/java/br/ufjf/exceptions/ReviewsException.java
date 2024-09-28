package br.ufjf.exceptions;

public class ReviewsException extends Exception {

    public ReviewsException(String message) {
        super("ERRO AVALIAÇÃO: " + message);
    }
}
