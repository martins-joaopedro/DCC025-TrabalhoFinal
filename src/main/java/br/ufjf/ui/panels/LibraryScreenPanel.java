package br.ufjf.ui.panels;

import java.awt.*;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufjf.models.Book;
import br.ufjf.services.LibraryService;
import br.ufjf.ui.components.BookCard;
import br.ufjf.ui.UIConstants;

public class LibraryScreenPanel extends JPanel {

    LibraryService service = new LibraryService();

    public LibraryScreenPanel() {

        add(new JLabel("Acervo"));
        
        loadBooks();
    }

    public void loadBooks() {
        List<Book> books = service.findAll();
        
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout());
        //container.setPreferredSize(new Dimension(100, 100));
        container.add(Box.createHorizontalStrut(20));

        for (Book book : books)
            container.add(new BookCard(book));

        JScrollPane scroll = new JScrollPane(container);
        scroll.getHorizontalScrollBar().setUnitIncrement(16);
        scroll.setPreferredSize(new Dimension(UIConstants.SCREEN_WIDTH-50, UIConstants.SCREEN_HEIGHT));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Define o scroll horizontal
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Remove o scroll vertical

        add(scroll);
    }
}
