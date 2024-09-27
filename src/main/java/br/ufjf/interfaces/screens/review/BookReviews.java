package br.ufjf.interfaces.screens.review;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.components.cards.ReviewCard;
import br.ufjf.interfaces.components.lists.ComponentList;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Review;
import br.ufjf.services.LibraryService;
import br.ufjf.services.ReviewService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BookReviews extends BasicScreen {

    private ReviewService reviewService = new ReviewService();

    String BOOK_ISBN = AplicationWindow.getBook();

    public BookReviews() {
        super("personalLibrary");

        setPreferredSize(new Dimension(Style.getWidth(), Style.getHeight()));
        addTitle(new JLabel("Avaliações do Livro: ") );
        drawReviewsList();
    }

    public void drawReviewsList() {
        List<Review> reviews = reviewService.getReviewsByISBN(BOOK_ISBN);
        List<JComponent> components = new ArrayList<>();

        if(reviews.isEmpty()) {
            addComponent(new JLabel("Nenhuma avaliação disponível"), 0, 0);
        } else {
            for (Review review : reviews)
                components.add(new ReviewCard(review));
            addComponent(new ComponentList(components, false, 500, 500), 0 , 0);
        }
    }
}


