package br.ufjf.interfaces.components.cards;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;

import br.ufjf.models.Book;


public class LibraryBookCard extends BookCard {

    private final Button addBook = new Button("Adicionar livro");
    
    public LibraryBookCard(Book book) {
        super(book);
        
        addBook.addActionListener(e -> AplicationWindow.showBookScreen("bookInfo", book.getISBN()));

        addButtons(addBook);

    }

    public void handleOptions() {

    }
}
