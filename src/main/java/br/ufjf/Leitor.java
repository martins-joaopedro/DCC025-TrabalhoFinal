package br.ufjf;

public class Leitor {
    private String nome;
    private String idade;
    private Biblioteca biblioteca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
