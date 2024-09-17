package br.ufjf.models;

import br.ufjf.models.enums.Genre;

public class Book {
    private final String ISBN;
    private String name;
    private String autor;
    private String synopsis;
    private int pages;
    private Genre genre;
    
    public Book(String name, String autor, String ISBN, String synopsis, int pages, Genre genre) {
        this.name = name;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
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
