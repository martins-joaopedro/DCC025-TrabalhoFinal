package br.ufjf.interfaces.screens.libraries;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.components.cards.LibraryBookCard;
import br.ufjf.interfaces.components.lists.ComponentList;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;
import br.ufjf.services.LibraryService;

public class Library extends BasicScreen {

    protected final JLabel titulo = new JLabel("Biblioteca");

    protected final LibraryService service = new LibraryService();
    protected int line = 0;

    public Library() {
        super("personalLibrary");
        
        this.line = 0;

        addTitle(titulo);

        for(Genre genre : Genre.values()) {
            addComponent(new JLabel(genre.getDisplayName()), 0, this.line, false);
            addComponent(bookList(genre), 0, this.line+1, false);
            this.line+=2;
        }
    }

    public Library(int line) {
        super("home");

        this.line = line;

        addTitle(titulo);

        for(Genre genre : Genre.values()) {
            addComponent(new JLabel(genre.getDisplayName()), 0, this.line, false);
            addComponent(bookList(genre), 0, this.line+1, false);
            this.line+=2;
        }
    }

    protected ComponentList bookList(Genre genre) {
        List<JComponent> components = new ArrayList<>();

        List<Book> books = service.getBooksByGenre(genre);

        for (Book book : books) {
            components.add(new LibraryBookCard(book));
        }

        return new ComponentList(components, true);
    }
    
}
