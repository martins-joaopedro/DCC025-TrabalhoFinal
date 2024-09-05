package br.ufjf;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Livro {
    private final String ISBN;
    private String nome;
    private String autor;
    private String sinopse;
    private int paginas;
    private Genero genero;
    private Map<String, Avaliacao> mapAvaliacoes;
    
    public Livro(String nome, String autor, String ISBN, String sinopse, int paginas, Genero genero) {
        this.nome = nome;
        this.autor = autor;
        this.ISBN = ISBN;
        this.sinopse = sinopse;
        this.paginas = paginas;
        this.genero = genero;
        this.mapAvaliacoes = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getIBSN() {
        return ISBN;
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

    public void carregarAvaliacoes(List<Leitor> leitores) {
        for(Leitor leitor : leitores) {
            for(LivroUsuario livroLeitor : leitor.getBiblioteca().getLivrosAvaliados()) {
                if(livroLeitor.getIBSN() == this.ISBN)
                    this.mapAvaliacoes.put(leitor.getNome(), livroLeitor.getAvaliacao());
            }
        }
    }

    public void atualizarAvaliacao(String nome, Avaliacao avaliacao) {
        this.mapAvaliacoes.put(nome, avaliacao);
        
        // CÓDIGO PARA CHAMAR ATUALIZAR JSON LEITORES
    }

    public void removerAvaliacao(String nome) {
        this.mapAvaliacoes.remove(nome);
        
        // CÓDIGO PARA CHAMAR ATUALIZAR JSON LEITORES
    }

    public Map<String, Avaliacao> getAvaliacoes() {
        return this.mapAvaliacoes;
    }

}