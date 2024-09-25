package br.ufjf.ui.panels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import br.ufjf.models.Book;
import br.ufjf.services.LibraryService;
import br.ufjf.ui.components.ComponentList;
import br.ufjf.ui.components.cards.LibraryBookCard;

public class LibraryScreenPanel extends JPanel {

    LibraryService service = new LibraryService();

    public LibraryScreenPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        loadBooks();

    }

    public void loadBooks() {
        List<Book> books = service.findAll();
        List<LibraryBookCard> bookCards = new ArrayList<>();

        for(Book book : books)
            bookCards.add(new LibraryBookCard(book));

        ComponentList<LibraryBookCard> list = new ComponentList<>(bookCards, false);
        add(list);
    }
}
