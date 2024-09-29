package br.ufjf.exceptions;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

public class CouldNotConvertJsonException extends RuntimeException {
    
    public CouldNotConvertJsonException(String message) {
        super(message);
    }
}
