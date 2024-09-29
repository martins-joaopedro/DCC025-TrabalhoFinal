package br.ufjf.models;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import br.ufjf.models.enums.Genre;

public class Book {
    private final String ISBN;
    private String name;
    private String author;
    private String synopsis;
    private int pages;
    private Genre genre;
    
    public Book(String name, String author, String ISBN, String synopsis, int pages, Genre genre) {
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.synopsis = synopsis;
        this.pages = pages;
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getPages() {
        return pages;
    }

    public Genre getGenre() {
        return genre;
    }

    
}
