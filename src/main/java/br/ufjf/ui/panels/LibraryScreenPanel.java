package br.ufjf.ui.panels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import br.ufjf.models.Book;
import br.ufjf.services.LibraryService;
import br.ufjf.ui.components.BookCard;
import br.ufjf.ui.components.ComponentList;

public class LibraryScreenPanel extends JPanel {

    LibraryService service = new LibraryService();

    public LibraryScreenPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        loadBooks();

    }

    public void loadBooks() {
        List<Book> books = service.findAll();
        List<BookCard> bookCards = new ArrayList<>();

        for(Book book : books)
            bookCards.add(new BookCard(book));

        ComponentList<BookCard> list = new ComponentList<>(bookCards, false);
        add(list);
    }
}
