package br.ufjf.interfaces.widgets.cards;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Book;
import br.ufjf.ui.components.Image;

public class LibraryBookCard extends BookCard {

    private final Button addBook = new Button("Adicionar livro");
    
    public LibraryBookCard(Book book) {
        super(book);
        
        addBook.addActionListener(e -> AplicationWindow.showBookScreen("bookInfo", book.getISBN()));

        addButtons(addBook);

        add(new Image("content/star.png", 10, 10));
    }

    public void handleOptions() {

    }
}
