package br.ufjf.interfaces.widgets.cards;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Book;
import br.ufjf.services.PersonalLibraryService;
import br.ufjf.ui.components.Image;
import br.ufjf.ui.components.cards.BookCard;

public class LibraryBookCard extends BookCard {
    
    private final PersonalLibraryService service = new PersonalLibraryService();

    private final JButton addBook = new Button("Adicionar livro");
    
    public LibraryBookCard(Book book) {
        super(book);
        
        addBook.addActionListener(e -> AplicationWindow.showScreen("bookInfo", book.getISBN()));

        add(addBook);

        add(new Image("content/star.png", 10, 10));
    }

    public void handleOptions() {

    }
}
