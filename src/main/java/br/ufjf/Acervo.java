package br.ufjf;

import java.util.List;
import java.util.ArrayList;

public class Acervo {
    public static List<Livro> livrosAcervo;

    public Acervo(List<Livro> livros) {
        livrosAcervo = new ArrayList<>(livros);
    }

    public List<Livro> getLivros() {
        return livrosAcervo;
    }

    public static Livro BuscaLivro(String IBSN) {
        for(Livro livro : livrosAcervo) {
            if(livro.getIBSN() == IBSN)
                return livro;
        }

        return null;
    } 

}