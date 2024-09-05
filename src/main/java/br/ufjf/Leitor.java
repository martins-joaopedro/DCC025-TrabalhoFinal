package br.ufjf;

public class Leitor {
    private String nome;
    private String idade;
    private Biblioteca biblioteca;
    
    // FAZER CONSTRUTOR LEITOR NOVO

    // FAZER CONSTRUTOR LEITOR JÁ CADASTRADO

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void removerLivro(String ISBN) {
        this.biblioteca.removerLivroAcervo(ISBN);
        Acervo.buscaLivro(ISBN).removerAvaliacao(this.nome);
    }

    public void atualizarAvaliacao(String ISBN, int estrela, String comentario) {
        this.biblioteca.atualizarAvaliacaoAcervo(ISBN, estrela, comentario);
        Acervo.buscaLivro(ISBN).atualizarAvaliacao(this.nome, this.biblioteca.getLivros().get(ISBN).getAvaliacao());
    }
}
