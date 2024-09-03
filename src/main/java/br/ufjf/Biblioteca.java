package br.ufjf;

public class Biblioteca {
    private Livro[] livros;
    private int calcTotalPaginas;
    private String calcGeneroMaisLido;
    
    private void removerLivro(){};
    private void editarLivro(){};
    private void listarHistorico(){}
    private void addLivro(){}
    
    public Livro[] getLivros() {
        return livros;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    public int getCalcTotalPaginas() {
        return calcTotalPaginas;
    }

    public String getCalcGeneroMaisLido() {
        return calcGeneroMaisLido;
    }
}
