package br.ufjf.models;

import br.ufjf.models.enums.Genero;

public class Livro {
    private final String ISBN;
    private String nome;
    private String autor;
    private String sinopse;
    private int paginas;
    private Genero genero;
    
    public Livro(String nome, String autor, String ISBN, String sinopse, int paginas, Genero genero) {
        this.nome = nome;
        this.autor = autor;
        this.ISBN = ISBN;
        this.sinopse = sinopse;
        this.paginas = paginas;
        this.genero = genero;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getPaginas() {
        return paginas;
    }

    public Genero getGenero() {
        return genero;
    }

    
}
