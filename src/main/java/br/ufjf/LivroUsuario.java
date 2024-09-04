package br.ufjf;

public class LivroUsuario {
    private String ISBN;
    private Avaliacao avaliacao;
    private Status status;

    public LivroUsuario(String ISBN, Status status) {
        this.ISBN = ISBN;
        this.status = status;
    }

    public void AtualizarStatus(Status status) {
        this.status = status;
    }

    //TODO: try catch 
    public void AvaliarLivro(int estrela, String comentario) {
        
        if(this.status == Status.LIDO) {
            this.avaliacao.setEstrelas(estrela);
            this.avaliacao.setComentario(comentario);
       }
    }

    public String getIBSN() {
        return this.ISBN;
    }

    public Avaliacao getAvaliacao() {
        return this.avaliacao;
    }

    public Status getStatus() {
        return this.status;
    }
}