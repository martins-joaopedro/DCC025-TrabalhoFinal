package br.ufjf.interfaces.screens.libraries;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;

import br.ufjf.interfaces.components.cards.LibraryBookCard;
import br.ufjf.interfaces.components.lists.ComponentList;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;
import br.ufjf.services.LibraryService;

public class Library extends BasicScreen {

    private final JLabel titulo = new JLabel("Biblioteca");

    LibraryService service = new LibraryService();

    public Library() {
        super("personalLibrary");

        addTitle(titulo);

        int i = 0;
        for(Genre genre : Genre.values()) {
            addComponent(new JLabel(genre.getDisplayName()), 0, i, false);
            addComponent(bookList(genre), 0, i+1, false);
            i+=2;
        }
    }

    private ComponentList bookList(Genre genre) {
        List<JComponent> components = new ArrayList<>();

        List<Book> books = service.getBooksByGenre(genre);

        for (Book book : books) {
            components.add(new LibraryBookCard(book));
        }

        return new ComponentList(components, true);
    }
    
}
