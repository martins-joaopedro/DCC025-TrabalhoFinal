package br.ufjf.interfaces.components.cards;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.LibraryException;
import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Book;
import br.ufjf.services.AdmService;

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
        removeBook.addActionListener(e -> {
            try {
                service.removeBook(book);
                AplicationWindow.showScreen("adm");
            } catch (LibraryException err) {
                new ExceptionsController(err);
            }
        });

        addButtons(editBook, removeBook);
    }
}
