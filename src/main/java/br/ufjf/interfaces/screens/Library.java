package br.ufjf.interfaces.screens;

import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

import br.ufjf.interfaces.widgets.*;
import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;
import br.ufjf.services.LibraryService;

import br.ufjf.interfaces.components.cards.LibraryBookCard;

public class Library extends BasicScreen {

    private final JLabel titulo = new JLabel("Biblioteca");

    LibraryService service = new LibraryService();

    public Library() {
        super("personalLibrary");

        addTitle(titulo);

        int i = 0;
        for(Genre genre : Genre.values()) {
            addComponent(new JLabel(genre.getType()), 0, i, false);
            addComponent(bookList(genre), 0, i+1, false);
            i+=2;
        }
    }

    private ComponentList bookList(Genre genre) {
        List<JComponent> components = new ArrayList<JComponent>();

        List<Book> books = service.getBooksByGenre(genre);

        for (Book book : books) {
            components.add(new LibraryBookCard(book));
        }

        return new ComponentList(components, true);
    }
    
}
