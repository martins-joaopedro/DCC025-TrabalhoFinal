package br.ufjf;

public class Avaliacao {
    private int estrelas;
    private String comentario;

    public Avaliacao(int estrelas, String comentario) {
        this.estrelas = estrelas;
        this.comentario = comentario;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public String getComentario() {
        return comentario;
    }
}
