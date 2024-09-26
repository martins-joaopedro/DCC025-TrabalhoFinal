package br.ufjf.interfaces;
import javax.swing.*;

import br.ufjf.interfaces.widgets.*;

public class PersonalLibrary extends BasicScreen {

    private final JLabel titulo = new JLabel("Biblioteca Pessoal");

    private JLabel nomeUser = new JLabel("Bem-vindo, " + "Usuário" + "!");
    private JLabel numLivrosLidos;
    private JLabel numPaginasLidas;
    private JLabel generoFavorito;

    public PersonalLibrary() {
        super("home");

        numLivrosLidos = new JLabel("Você já leu " + "0" + " livros.");
        numPaginasLidas = new JLabel("Você já leu " + "0" + " páginas.");
        generoFavorito = new JLabel("Seu gênero favorito é " + "Gênero" + ".");

        addTitle(titulo, false);
   
        addComponent(nomeUser, 0, 0, false);
        addComponent(numLivrosLidos, 0, 1,  false);
        addComponent(numPaginasLidas, 0, 2, false);
        addComponent(generoFavorito, 0, 3, false);

        //addButtons(login, signin);
    }
}
