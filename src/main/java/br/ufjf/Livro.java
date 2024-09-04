package br.ufjf;

public class Livro {
    private String nome;
    private String autor;
    private String IBSN;
    private String sinopse;
    private int paginas;
    private Genero genero;

    public Livro(String nome, String autor, String IBSN, String sinopse, int paginas, Genero genero) {
        this.nome = nome;
        this.autor = autor;
        this.IBSN = IBSN;
        this.sinopse = sinopse;
        this.paginas = paginas;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getIBSN() {
        return IBSN;
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