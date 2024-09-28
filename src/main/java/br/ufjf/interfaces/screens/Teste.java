package br.ufjf.interfaces.screens;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.LibraryException;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;
import br.ufjf.services.AdmService;

public class Teste extends BasicScreen {

    private AdmService service = new AdmService();

    public Teste() {
        super("null");
        Book b = new Book("a","a", "a", "a", 1, Genre.ACADEMICO);
        Book b21 = new Book("a","a2222222", "a", "a", 1, Genre.ACADEMICO);

        Button b1 = new Button("ADD");
        b1.addActionListener(e -> {
            try {
                service.addBook(b);
                service.addBook(b);
            } catch (LibraryException ex) {
                new ExceptionsController(ex);
            }
        });

        Button b2 = new Button("EDIT");
        b2.addActionListener(e -> {
            try {
                service.update(b21);
            } catch (LibraryException ex) {
                throw new RuntimeException(ex);
            }
        });

        Button b3 = new Button("remove");
        b3.addActionListener(e -> {
            try {
                service.removeBook(b);
            } catch (LibraryException ex) {
                new ExceptionsController(ex);
            }
        });

        addButtons(b1, b2, b3);

    }
}
