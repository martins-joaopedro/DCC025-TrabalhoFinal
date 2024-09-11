package br.ufjf.models;

import java.util.Map;

public class Leitor extends Usuario {

    String nome;
    Map<String, Livro> bibliotecaPessoal;

    public Leitor(String idUsuario, String senha, Map<String, Livro> bibliotecaPessoal) {
        super(idUsuario, senha);
    
        this.bibliotecaPessoal = bibliotecaPessoal;
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Livro> getBibliotecaPessoal() {
        return bibliotecaPessoal;
    }
}
