package br.ufjf.interfaces;

import javax.swing.*;
import java.awt.*;

import br.ufjf.interfaces.widgets.*;
import br.ufjf.interfaces.widgets.Button;

public class PersonalLibrary extends BasicScreen {

    private final JLabel titulo = new JLabel("Biblioteca Pessoal");

    private JLabel nomeUser = new JLabel();
    private JLabel numLivrosLidos = new JLabel();
    private JLabel numPaginasLidas = new JLabel();
    private JLabel generoFavorito = new JLabel();

    private JButton adicionarLivro = new Button("Adicionar Livro");
    private JButton editarStatus = new Button("Editar Status");

    public PersonalLibrary() {
        super("home");

        updateData("Usuário", 0, 0, "Gênero");

        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        addTitle(titulo, false);
   
        addComponent(nomeUser, 0, 0, false);
        addComponent(numLivrosLidos, 0, 1,  false);
        addComponent(numPaginasLidas, 0, 2, false);
        addComponent(generoFavorito, 0, 3, false);

        addComponent(BookList(), 0, 4, false);


        adicionarLivro.addActionListener(e -> AplicationWindow.showScreen("library"));
        editarStatus.addActionListener(e -> AplicationWindow.showScreen(""));
        addButtons(adicionarLivro, editarStatus);
    }

    private ScrollPanel BookList() {
        // Cria um painel de rolagem para a lista de livros
        ScrollPanel scroll = new ScrollPanel();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(300, 250));
        scroll.setMinimumSize(new Dimension(300, 150));
        scroll.setBorder(BorderFactory.createEmptyBorder());


        // Cria um painel para a lista de livros
        JPanel bookList = new JPanel();
        bookList.setLayout(new BoxLayout(bookList, BoxLayout.Y_AXIS));
        bookList.setBackground(Color.WHITE);
        bookList.setPreferredSize(new Dimension(300, 500));
        bookList.setMinimumSize(new Dimension(300, 500));

        // Adiciona a lista de livros ao painel de rolagem
        scroll.setViewportView(bookList);

        return scroll;
    }

    public void updateData(String nome, int livros, int paginas, String genero) {
        nomeUser.setText("Bem-vindo, " + nome + "!");
        numLivrosLidos.setText("Você já leu " + livros + " livros.");
        numPaginasLidas.setText("Você já leu " + paginas + " páginas.");
        generoFavorito.setText("Seu gênero favorito é " + genero + ".");
    }
}
