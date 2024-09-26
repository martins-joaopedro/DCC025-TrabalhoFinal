package br.ufjf.interfaces;

import javax.swing.*;
import java.awt.*;

import br.ufjf.interfaces.widgets.*;
import br.ufjf.interfaces.widgets.Button;

public class Library extends BasicScreen {

    private final JLabel titulo = new JLabel("Biblioteca");

    private JButton adicionarLivro = new Button("Adicionar Livro");

    public Library() {
        super("personalLibrary");

        addTitle(titulo);
        addComponent(bookLists(new ScrollPanel()), 0, 0, false);
        addComponent(bookLists(new ScrollPanel()), 0, 1, false);
        addComponent(bookLists(new ScrollPanel()), 0, 2, false);
        addButtons(adicionarLivro);

    }

    private ScrollPanel bookLists(ScrollPanel scroll) {
        // Cria um painel de rolagem para a lista de livros
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(100, 150));
        scroll.setMinimumSize(new Dimension(100, 150));
        scroll.setBorder(BorderFactory.createEmptyBorder());

        // Cria um painel para a lista de livros
        JPanel bookList = new JPanel();
        bookList.setLayout(new BoxLayout(bookList, BoxLayout.Y_AXIS));
        bookList.setBackground(Color.WHITE);
        bookList.setPreferredSize(new Dimension(500, 500));
        bookList.setMinimumSize(new Dimension(500, 500));

        // Adiciona a lista de livros ao painel de rolagem
        scroll.setViewportView(bookList);

        return scroll;
    }
    
}
