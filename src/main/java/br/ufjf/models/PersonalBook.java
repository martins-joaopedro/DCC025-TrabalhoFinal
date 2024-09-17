package br.ufjf.models;

import br.ufjf.models.enums.*;

public class PersonalBook extends Book {
    private Status status;
    private int actualPage;

    public PersonalBook(String name, String autor, String ISBN, String synopsis, int pages, Genre genre, Status status, int actualPage) {
        super(name, autor, ISBN, synopsis, pages, genre);

        this.status = status;
        this.actualPage = actualPage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getActualPage() {
        return actualPage;
    }

    public void setActualPage(int paginaAtual) {
        this.actualPage = paginaAtual;
    }
}
