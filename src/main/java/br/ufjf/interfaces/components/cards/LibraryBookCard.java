package br.ufjf.interfaces.components.cards;

import javax.swing.*;
import java.awt.*;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.UIConstants;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Book;

public class LibraryBookCard extends BookCard {

    private final Button addBook = new Button("Adicionar");
    
    public LibraryBookCard(Book book) {
        super(book);

        JTextArea sinopsysArea = new JTextArea(book.getSynopsis());
            sinopsysArea.setFont(Style.getFitFont().deriveFont(Font.PLAIN, 10));
            sinopsysArea.setEditable(false);
            sinopsysArea.setWrapStyleWord(true);sinopsysArea.setAutoscrolls(true);
            sinopsysArea.setLineWrap(true);
            sinopsysArea.setPreferredSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, 50));
            sinopsysArea.setMinimumSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, 50));
            sinopsysArea.setMaximumSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, 50));
            sinopsysArea.setBackground(Style.getBackgroundColor());
        add(sinopsysArea);

        int averageStars = reviewService.getAverageStarsByISBN(book.getISBN());
        
        JPanel starsPanel = new JPanel();
        starsPanel.setOpaque(false);
        for(int i=0; i<averageStars; i++)
            starsPanel.add(new ImageCard("star.png", 20, 20, getBackground()));
        add(starsPanel);

        drawButtons(book.getISBN());
    }

    @Override
    protected void drawButtons(String ISBN) {
        seeReview.addActionListener(e -> AplicationWindow.showReviewScreen(ISBN));
        addBook.addActionListener(e -> AplicationWindow.showBookScreen("bookInfo", ISBN));
        
        if(reviewsAmount > 0)
            addButtons(seeReview, addBook);
        else
            addButtons(addBook);
    }
}
