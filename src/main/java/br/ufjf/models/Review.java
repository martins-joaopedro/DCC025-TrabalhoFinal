package br.ufjf.models;

public class Review {

    private final String idUsuario;
    private final String ISBN;
    private int estrelas;
    private String comentario;

    public Review(String idUsuario, String ISBN, int estrelas, String comentario) {
        this.idUsuario = idUsuario;
        this.ISBN = ISBN;
        this.estrelas = estrelas;
        this.comentario = comentario;
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public int getEstrelas() {
        return this.estrelas;
    }

    public String getComentario() {
        return this.comentario;
    }
}