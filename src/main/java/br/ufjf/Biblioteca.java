package br.ufjf;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private List<LivroUsuario> livros;
    
    private void editarLivro(){};
    private void listarHistorico(){}

    private Biblioteca(List<LivroUsuario> livros) {
        this.livros = new ArrayList<>(livros);
    }
    
    public List<LivroUsuario> getLivros() {
        return livros;
    }

    public String getGeneroMaisLido() {
        Map<Genero, Integer> generosLidos = new HashMap<>();

        for(LivroUsuario livro : this.livros) {
            if(livro.getStatus() == Status.LIDO) {
                Genero generoLivro = Acervo.buscaLivro(livro.getIBSN()).getGenero();
                
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

    public int getNumPaginasLidas() {
        int numTotalPaginas = 0;

        for(LivroUsuario livro : this.livros) {
            if(livro.getStatus() == Status.LIDO)
                numTotalPaginas+=Acervo.buscaLivro(livro.getIBSN()).getPaginas();
        }

        return numTotalPaginas;
    }

    public int getNumLivrosLidos() {
        int numLivrosLidos = 0;

        for(LivroUsuario livro : this.livros) {
            if(livro.getStatus() == Status.LIDO)
                numLivrosLidos++;
        }

        return numLivrosLidos;
    }

    public void addLivro(String ISBN, Status status) {
        LivroUsuario novoLivro = new LivroUsuario(ISBN, status);

        this.livros.add(novoLivro);
    }

    public void removerLivro(String ISBN) {
        for(LivroUsuario livro : this.livros) {
            if(livro.getIBSN() == ISBN)
                livros.remove(livro);
        }
    }

}
