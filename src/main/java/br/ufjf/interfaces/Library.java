package br.ufjf.interfaces;

import javax.swing.*;
import java.awt.*;

import java.util.List;
import java.util.ArrayList;

import br.ufjf.interfaces.widgets.*;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;
import br.ufjf.services.LibraryService;
import br.ufjf.ui.components.ComponentList;

import br.ufjf.interfaces.widgets.cards.LibraryBookCard;

public class Library extends BasicScreen {

    private final JLabel titulo = new JLabel("Biblioteca");

    LibraryService service = new LibraryService();

    private JButton adicionarLivro = new Button("Adicionar Livro");

    public Library() {
        super("personalLibrary");

        addTitle(titulo);

        addComponent(new JLabel("Fantasia"), 0, 0, false);
        addComponent(bookList(Genre.FANTASIA), 0, 1, false);
        addComponent(new JLabel("Romance"), 0, 2, false);
        addComponent(bookList(Genre.ROMANCE), 0, 3, false);
        addComponent(new JLabel("Ficção"), 0, 4, false);
        addComponent(bookList(Genre.FICCAO), 0, 5, false);
        addComponent(new JLabel("Terror"), 0, 6, false);
        addComponent(bookList(Genre.TERROR), 0, 7, false);
        addComponent(new JLabel("Acadêmico"), 0, 8, false);
        addComponent(bookList(Genre.ACADEMICO), 0, 9, false);
        addComponent(new JLabel("Distopia"), 0, 10, false);
        addComponent(bookList(Genre.DISTOPIA), 0, 11, false);
        addComponent(new JLabel("Suspense"), 0, 12, false);
        addComponent(bookList(Genre.SUSPENSE), 0, 13, false);
        
        addButtons(adicionarLivro);

    }

    private ScrollPanel bookList(Genre genero) {

        ScrollPanel scroll = new ScrollPanel();

        // Cria um painel de rolagem para a lista de livros
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(120, 150));
        scroll.setMinimumSize(new Dimension(120, 150));
        scroll.setBorder(BorderFactory.createEmptyBorder());

        // Adiciona a lista de livros ao painel de rolagem
        scroll.setViewportView(loadBooks(genero));

        return scroll;
    }

    private ComponentList<LibraryBookCard> loadBooks(Genre genero) {
        List<Book> books = service.findAll();
        List<LibraryBookCard> bookCards = new ArrayList<>();

        for(Book book : books)
            //if(book.getGenre() == genero)
                bookCards.add(new LibraryBookCard(book));

        return new ComponentList<>(bookCards, true);
    }
    
}
