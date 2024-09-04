package br.ufjf;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private List<LivroUsuario> livros;
    private int calcTotalPaginas;
    
    private void removerLivro(){};
    private void editarLivro(){};
    private void listarHistorico(){}
    private void addLivro(){}

    private Biblioteca(List<LivroUsuario> livros) {
        this.livros = new ArrayList<>(livros);
    }
    
    public List<LivroUsuario> getLivros() {
        return livros;
    }

    public int getCalcTotalPaginas() {
        return calcTotalPaginas;
    }

    public String getCalcGeneroMaisLido() {
        Map<Genero, Integer> generosLidos = new HashMap<>();

        for(LivroUsuario livro : this.livros) {
            if(livro.getStatus() == Status.LIDO) {
                Genero generoLivro = Acervo.BuscaLivro(livro.getIBSN()).getGenero();



            }
        }
    }

    public int getNumLivrosLidos() {
        int numLivrosLidos = 0;

        for(LivroUsuario livro : this.livros) {
            if(livro.getStatus() == Status.LIDO)
                numLivrosLidos++;
        }

        return numLivrosLidos;
    }
}
