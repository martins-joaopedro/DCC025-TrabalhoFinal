package br.ufjf.models;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

public class Review {

    private String id; 
    private final String username;
    private final String ISBN;
    private int stars;
    private String comment;

    public Review(String id, String username, String ISBN, int stars, String comment) {
        this.id = id;
        this.username = username;
        this.ISBN = ISBN;
        this.stars = stars;
        this.comment = comment;
    }

    public String getUsername() {
        return this.username;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public int getStars() {
        return this.stars;
    }

    public String getComment() {
        return this.comment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}