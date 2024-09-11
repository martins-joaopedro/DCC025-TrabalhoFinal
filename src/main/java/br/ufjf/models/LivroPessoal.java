package br.ufjf.models;

import br.ufjf.models.enums.*;

public class LivroPessoal extends Livro {
    private Status status;
    private int paginaAtual;

    public LivroPessoal(String nome, String autor, String ISBN, String sinopse, int paginas, Genero genero, Status status, int paginaAtual) {
        super(nome, autor, ISBN, sinopse, paginas, genero);

        this.status = status;
        this.paginaAtual = paginaAtual;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }
}
