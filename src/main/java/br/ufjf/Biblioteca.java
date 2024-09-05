package br.ufjf;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    public static List<Livro> livrosAcervo;

    public Biblioteca(List<Livro> livros) {
        livrosAcervo = new ArrayList<>(livros);
    }

    public List<Livro> getLivros() {
        return livrosAcervo;
    }

    // GET LIVROS POR GENERO

    public static Livro buscaLivro(String ISBN) {
        for(Livro livro : livrosAcervo) {
            if(livro.getIBSN() == ISBN)
                return livro;
        }

        return null;
    } 

}