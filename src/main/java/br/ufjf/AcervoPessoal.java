package br.ufjf;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AcervoPessoal {
    private Map<String, LivroUsuario> livrosUsuario;

    public AcervoPessoal(Map<String, LivroUsuario> livrosUsuarios) {
        this.livrosUsuario = livrosUsuarios;
    }
    
    public Map<String, LivroUsuario> getLivros() {
        return livrosUsuario;
    }

    public String getGeneroMaisLido() {
        Map<Genero, Integer> generosLidos = new HashMap<>();

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == Status.LIDO) {
                Genero generoLivro = Biblioteca.buscaLivro(livroUsuario.getIBSN()).getGenero();
                
                if(generosLidos.containsKey(generoLivro))
                    generosLidos.put(generoLivro, generosLidos.get(generoLivro)+1);
                else
                    generosLidos.put(generoLivro, 0);
            }
        }

        Genero generoMaisLido = Genero.ACADEMICO;
        for(Genero genero : generosLidos.keySet()) {
            if(generosLidos.get(genero) > generosLidos.get(generoMaisLido))
                generoMaisLido = genero;
        }

        return generoMaisLido.getTipo();
    }

    public int getNumTotalPaginasLidas() {
        int numTotalPaginas = 0;

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == Status.LIDO)
                numTotalPaginas+=Biblioteca.buscaLivro(livroUsuario.getIBSN()).getPaginas();
            if(livroUsuario.getStatus() == Status.LENDO)
                numTotalPaginas+=livroUsuario.getNumPaginasLidas();
        }

        return numTotalPaginas;
    }

    public int getNumLivrosLidos() {
        int numLivrosLidos = 0;

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == Status.LIDO)
                numLivrosLidos++;
        }

        return numLivrosLidos;
    }

    public void addLivro(String ISBN, Status status) {
        if(this.livrosUsuario.containsKey(ISBN)) {
            // ERRO DE QUE O LIVRO JÁ ESTÁ NO ACERVO PESSOAL
        }
        else
            this.livrosUsuario.put(ISBN, new LivroUsuario(ISBN, status));
    }

    public void removerLivroAcervo(String ISBN) {
        if(!this.livrosUsuario.containsKey(ISBN)) {
            // ERRO DE QUE O LIVRO NÃO ESTÁ NO ACERVO PESSOAL
        }
        else
            this.livrosUsuario.remove(ISBN);
    }

    public void editarLivro(String ISBN, Status status, int numPaginasLidas) {
        if(!this.livrosUsuario.containsKey(ISBN)) {
            // ERRO DE QUE O LIVRO NÃO ESTÁ NO ACERVO PESSOAL
        }
        
        LivroUsuario livroAtualizado = livrosUsuario.get(ISBN);
        livroAtualizado.atualizarStatus(status);
        if(status == Status.LENDO)
            livroAtualizado.atualizarNumPaginasLidas(numPaginasLidas);
        this.livrosUsuario.put(ISBN, livroAtualizado);
    }

    public void atualizarAvaliacaoAcervo(String ISBN, int estrela, String comentario) {
        if(!this.livrosUsuario.containsKey(ISBN)) {
            // ERRO DE QUE O LIVRO NÃO ESTÁ NO ACERVO PESSOAL
        }
        
        LivroUsuario livroAtualizado = livrosUsuario.get(ISBN);
        livroAtualizado.avaliarLivro(estrela, comentario);
        this.livrosUsuario.put(ISBN, livroAtualizado);
    }

    public List<LivroUsuario> getLivrosStatus(Status status) {
        List<LivroUsuario> listaLivrosUsuario = new ArrayList<>();

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == status)
                listaLivrosUsuario.add(livroUsuario);
        }

        return listaLivrosUsuario;
    }

    public List<LivroUsuario> getLivrosAvaliados() {
        List<LivroUsuario> listaLivrosAvaliados = new ArrayList<>();

        for(LivroUsuario livroUsuario : getLivrosStatus(Status.LIDO)) {
            if(livroUsuario.getAvaliacao() != null) {
                listaLivrosAvaliados.add(livroUsuario);
            }
        }

        return listaLivrosAvaliados;
    }
}
