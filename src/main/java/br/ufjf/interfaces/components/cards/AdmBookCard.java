package br.ufjf.interfaces.components.cards;

import javax.swing.JPanel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Book;
import br.ufjf.services.AdmService;
import br.ufjf.services.ReviewService;

public class AdmBookCard extends LibraryBookCard {

    private final AdmService service = new AdmService();
    
    public AdmBookCard(Book book) {
        super(book);
    }

    @Override
    protected void drawButtons(Book book) {
        Button editBook = new Button("Editar livro");
        Button removeBook = new Button("Remover livro");

        editBook.addActionListener(e -> AplicationWindow.showBookScreen("newBook", book.getISBN()));
        removeBook.addActionListener(e -> service.removeBook(book.getISBN()));

        addButtons(editBook, removeBook);
    }
}
