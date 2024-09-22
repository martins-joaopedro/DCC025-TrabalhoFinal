package br.ufjf.ui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufjf.models.Book;
import br.ufjf.services.LibraryService;
import br.ufjf.ui.UIConstants;
import br.ufjf.ui.components.BookCard;
import br.ufjf.ui.components.ComponentList;

public class PersonalLibraryScreenPanel extends JPanel {

    LibraryService service = new LibraryService(); 
    JPanel mainPanel;

    public PersonalLibraryScreenPanel() {
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.red);

        List<Book> books = service.findAll();
        List<BookCard> bookCards = new ArrayList<>();

        for(Book book : books)
            bookCards.add(new BookCard(book));

        ComponentList<BookCard> list = new ComponentList<>(bookCards, true);
        mainPanel.add(list);

        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.setPreferredSize(new Dimension(UIConstants.SCREEN_WIDTH - UIConstants.OFFSET, UIConstants.SCREEN_HEIGHT-200));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);

    }
    
}