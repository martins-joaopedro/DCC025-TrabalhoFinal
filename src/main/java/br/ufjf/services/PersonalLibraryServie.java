package br.ufjf.services;

import java.util.HashMap;
import java.util.Map;

import br.ufjf.models.*;
import br.ufjf.models.enums.*;

public class PersonalLibraryServie {
/*
    public Genre getGenreMaisLido() {
        Map<Genre, Integer> readGenres = new HashMap<>();

        for(LivroUsuario livroUsuario : this.livrosUsuario.values()) {
            if(livroUsuario.getStatus() == Status.LIDO) {
                Genre GenreLivro = Biblioteca.buscaLivro(livroUsuario.getIBSN()).getGenre();
                
                if(readGenres.containsKey(GenreLivro))
                    readGenres.put(GenreLivro, readGenres.get(GenreLivro)+1);
                else
                    readGenres.put(GenreLivro, 0);
            }
        }

        Genre GenreMaisLido = Genre.ACADEMICO;
        for(Genre Genre : readGenres.keySet()) {
            if(readGenres.get(Genre) > readGenres.get(GenreMaisLido))
                GenreMaisLido = Genre;
        }

        return GenreMaisLido;
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

    public void removerLivro(String ISBN) {
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

    public void atualizarAvaliacao(String ISBN, int estrela, String comentario) {
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
 */
}
