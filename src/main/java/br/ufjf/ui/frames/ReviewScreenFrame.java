package br.ufjf.ui.frames;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufjf.models.Book;
import br.ufjf.services.ReviewService;
import br.ufjf.ui.UIConstants;
import br.ufjf.ui.components.cards.BookCard;

public class ReviewScreenFrame extends JFrame {

    ReviewService service;

    public ReviewScreenFrame(Book book) {

        service = new ReviewService();

        //add(new Screen("Review", new ReviewScreenPanel()));
        add(new BookCard(book));

        JPanel container = new JPanel();

        
        //ScrollPane scroll = new ScrollPane(container);

        setSize(new Dimension(UIConstants.SCREEN_WIDTH, UIConstants.SCREEN_HEIGHT));
        setVisible(true);
    }
}
