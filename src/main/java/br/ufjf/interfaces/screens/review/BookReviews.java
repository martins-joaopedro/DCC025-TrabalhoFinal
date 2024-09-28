package br.ufjf.interfaces.screens.review;

import java.util.List;

import javax.swing.JLabel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.components.cards.ReviewCard;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.models.Review;
import br.ufjf.services.ReviewService;

public class BookReviews extends BasicScreen {

    private ReviewService reviewService = new ReviewService();

    public BookReviews() {
        super("personalLibrary");

        addTitle(new JLabel("Avaliações do Livro: "));
        drawReviewsList();
    }

    public void drawReviewsList() {
        String BOOK_ISBN = AplicationWindow.getBook();
        List<Review> reviews = reviewService.getReviewsByISBN(BOOK_ISBN);

        if(reviews.isEmpty()) {
            addComponent(new JLabel("Nenhuma avaliação disponível"), 0, 0);
        } else {
            int i = 0;
            boolean toggle = true;
            // alterna entre duas colunas
            for (Review review : reviews) {
                if(toggle) {
                    addComponent(new ReviewCard(review), 0, i, true);
                } else {
                    addComponent(new ReviewCard(review), 1, i, true);
                    i+=1;
                } 
                toggle = !toggle;
            }
        }
    }
}


