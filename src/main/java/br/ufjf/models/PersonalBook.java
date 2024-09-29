package br.ufjf.models;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import br.ufjf.models.enums.Genre;
import br.ufjf.models.enums.Status;

public class PersonalBook extends Book {
    private String user;
    private Status status;
    private int currentPage;

    public PersonalBook(String name, String autor, String ISBN, String synopsis, int pages, Genre genre, String user, Status status, int actualPage) {
        super(name, autor, ISBN, synopsis, pages, genre);

        this.user = user;

        this.status = status;
        this.currentPage = actualPage;
    }

    public PersonalBook(Book book, String user, Status status, int currentPage) {
        super(book.getName(), book.getAuthor(), book.getISBN(), book.getSynopsis(), book.getPages(), book.getGenre());

        this.user = user;

        this.status = status;
        this.currentPage = currentPage;
    }

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public int getCurrentPage() { return currentPage; }

    public void setCurrentPage(int paginaAtual) { this.currentPage = paginaAtual; }
}
