package br.ufjf.models;

public class Usuario {
    String idUsuario;
    String senha;

    public Usuario(String idUsuario, String senha) {
        this.idUsuario = idUsuario;
        this.senha = senha;
    }
    
    public String getIdUsuario() {
        return this.idUsuario;
    }
    
    public String getSenha() {
        return this.senha;
    }

    
}
