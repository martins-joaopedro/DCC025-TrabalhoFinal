package br.ufjf.exceptions;

public class CouldNotConvertJsonException extends RuntimeException {
    
    public CouldNotConvertJsonException(String message) {
        super(message);
    }
}
