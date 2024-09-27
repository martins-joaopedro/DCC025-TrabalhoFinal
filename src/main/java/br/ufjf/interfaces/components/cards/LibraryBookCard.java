package br.ufjf.interfaces.components.cards;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;

import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Book;
import br.ufjf.models.Review;
import br.ufjf.services.ReviewService;

import javax.swing.*;


public class LibraryBookCard extends BookCard {

    private final Button addBook = new Button("Adicionar livro");

    public LibraryBookCard(Book book) {
        super(book);

        int averageStars = service.getAverageStarsByISBN(book.getISBN());
        addBook.addActionListener(e -> AplicationWindow.showBookScreen("bookInfo", book.getISBN()));
        addButtons(addBook);

        JPanel starsPanel = new JPanel();
        starsPanel.setBackground(Style.getLightBackgroundColor());
        for(int i=0; i<averageStars; i++)
            starsPanel.add(new ImageCard("star.png", 10, 10));
        add(starsPanel);
    }
}
