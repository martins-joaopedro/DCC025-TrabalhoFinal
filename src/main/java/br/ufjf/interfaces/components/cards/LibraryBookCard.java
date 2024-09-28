package br.ufjf.interfaces.components.cards;

import javax.swing.JPanel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Book;

public class LibraryBookCard extends BookCard {

    private final Button addBook = new Button("Adicionar livro");
    
    public LibraryBookCard(Book book) {
        super(book);

        int averageStars = service.getAverageStarsByISBN(book.getISBN());
        
        JPanel starsPanel = new JPanel();
        starsPanel.setOpaque(false);
        for(int i=0; i<averageStars; i++)
            starsPanel.add(new ImageCard("star.png", 20, 20, getBackground()));
        add(starsPanel);

        drawButtons(book);
    }

    protected void drawButtons(Book book) {
        addBook.addActionListener(e -> AplicationWindow.showBookScreen("bookInfo", book.getISBN()));
        addButtons(addBook);
    }
}
