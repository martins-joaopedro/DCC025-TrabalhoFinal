package br.ufjf.interfaces.screens.review;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JLabel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.components.cards.ReviewCard;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.models.Review;
import br.ufjf.services.ReviewService;

public class BookReviews extends BasicScreen {

    private ReviewService reviewService = new ReviewService();

    String BOOK_ISBN = AplicationWindow.getBook();
    private boolean isAdm = false;

    public BookReviews(boolean isAdm, Object onPage) {
        super(null);

        setPreferredSize(new Dimension(300, 300));
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);

        this.isAdm = isAdm;
        drawReviewsList(1);
    }

    public BookReviews(boolean isAdm) {
        super("adm");

        this.isAdm = true;
        
        addTitle(new JLabel("Avaliações do Livro: "));
        
        drawReviewsList(1);
    }
    
    public BookReviews() {
        super("personalLibrary");
        
        addTitle(new JLabel("Avaliações do Livro: "));
        
        drawReviewsList(0);
    }

    public void drawReviewsList(int line) {
        List<Review> reviews = reviewService.getReviewsByISBN(BOOK_ISBN);

        if(reviews.isEmpty()) {
            addComponent(new JLabel("Nenhuma avaliação disponível"), 0, line);
        } else {
            int i = 0;
            boolean toggle = true;
            // alterna entre duas colunas
            for (Review review : reviews) {
                if(toggle) {
                    addComponent(new ReviewCard(review, this.isAdm), 0, line+i, true);
                } else {
                    addComponent(new ReviewCard(review, this.isAdm), 1, line+i, true);
                    i+=1;
                } 
                toggle = !toggle;
            }
        }
    }
}


