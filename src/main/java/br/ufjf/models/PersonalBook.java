package br.ufjf.models;

import br.ufjf.models.enums.Genre;
import br.ufjf.models.enums.Status;

public class PersonalBook extends Book {
    private Status status;
    private int currentPage;

    public PersonalBook(String name, String autor, String ISBN, String synopsis, int pages, Genre genre, Status status, int actualPage) {
        super(name, autor, ISBN, synopsis, pages, genre);

        this.status = status;
        this.currentPage = actualPage;
    }

    public PersonalBook(Book book, Status status, int currentPage) {
        super(book.getName(), book.getAuthor(), book.getISBN(), book.getSynopsis(), book.getPages(), book.getGenre());
        this.status = status;
        this.currentPage = currentPage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int paginaAtual) {
        this.currentPage = paginaAtual;
    }
}
