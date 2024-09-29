package br.ufjf.models;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.util.Map;

public class Reader extends User {

    String name;
    Map<String, Book> personalLibrary;

    public Reader(String username, String password, Map<String, Book> personalLibrary) {
        super(username, password);
    
        this.personalLibrary = personalLibrary;
    }

    public String getName() {
        return name;
    }

    public Map<String, Book> getPersonalLibrary() {
        return personalLibrary;
    }
}
