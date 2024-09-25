package br.ufjf.ui.components.cards;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.ufjf.models.Book;
import br.ufjf.services.PersonalLibraryService;
import br.ufjf.ui.components.Image;

public class LibraryBookCard extends BookCard {
    
    PersonalLibraryService service = new PersonalLibraryService();
    
    public LibraryBookCard(Book book) {
        super(book);
        
        JPanel buttons = new JPanel();

            buttons.setLayout(new GridLayout(2, 0));
            buttons.setPreferredSize(new Dimension(30, 30));

            JButton seeReviews = new JButton("ver todas as avaliações");
            //seeReviews.addActionListener(e -> new ReviewScreenFrame());

            JButton addButton = new JButton("adicionar à biblioteca pessoal");
            addButton.addActionListener(e -> service.addToPersonalLibrary(book.getISBN()));

        seeReviews.addActionListener(e -> handleOptions());
            buttons.add(seeReviews);
            buttons.add(addButton);
        add(buttons);

        add(new Image("content/star.png", 10, 10));
    }

    public void handleOptions() {

    }
}
