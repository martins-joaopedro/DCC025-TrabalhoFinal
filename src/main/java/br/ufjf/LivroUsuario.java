package br.ufjf;

public class LivroUsuario {
    private final String ISBN;
    private Status status; // tem "set"
    private Avaliacao avaliacao; // tem "set"
    private int numPaginasLidas; // tem set

    public LivroUsuario(String ISBN, Status status) {
        this.ISBN = ISBN;
        this.status = status;
        this.numPaginasLidas = 0;
        this.avaliacao = null;
    }

    public void atualizarStatus(Status status) {
        this.status = status;
    }

    //TODO: try catch 
    public void avaliarLivro(int estrela, String comentario) {
        
        if(this.status == Status.LIDO) {
            this.avaliacao = new Avaliacao(estrela, comentario);
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

    public void atualizarNumPaginasLidas(int num) {
        this.numPaginasLidas = num;
    }
    
    public int getNumPaginasLidas() {
        return this.numPaginasLidas;
    }
}