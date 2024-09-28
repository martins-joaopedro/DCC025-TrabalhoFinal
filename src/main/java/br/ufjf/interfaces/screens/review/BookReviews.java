package br.ufjf.interfaces.screens.review;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.ParserExceptions;
import br.ufjf.exceptions.ReviewsException;
import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.components.cards.ReviewCard;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Review;
import br.ufjf.services.ReviewService;
import br.ufjf.utils.InputParser;

public class BookReviews extends BasicScreen {

    private ReviewService reviewService = new ReviewService();

    String BOOK_ISBN = AplicationWindow.getBook();
    String USER = AplicationWindow.getUser();
    private boolean isAdm = false;

    private JTextField comment = new JTextField();
    private JComboBox<String> starsBox = new JComboBox<>();
    private String selectedStars = "1";

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

        Review review = reviewService.getUserReviewByISBN(BOOK_ISBN, USER);
        if(review == null)
            drawAddReviewPanel();
        drawReviewsList(1);
    }

    public void drawAddReviewPanel() {

        BasicScreen info = new BasicScreen(null);
        info.addComponent(new JLabel("Autor: " + AplicationWindow.getUser()), 0, 0);

        info.addComponent(new JLabel("Comentário: "), 0, 1);
        comment.setPreferredSize(new Dimension(250, 80));
        info.addComponent(comment, 0, 2);

        info.addComponent(new JLabel("Estrelas: "), 0, 2);
        for(int i=1; i<=5; i++) {
            this.starsBox.addItem(String.valueOf(i));
        }

        this.starsBox.addActionListener(e -> {
            this.selectedStars = starsBox.getSelectedItem().toString();
        });
        info.addComponent(starsBox, 0, 3);

        Button save = new Button("Salvar");
        save.addActionListener(e -> addReviewController());
        info.addButtons(save);

        addComponent(info, 0, 0);
    }

    private void addReviewController() {

        int stars = 0;
        try {
            stars = InputParser.toInteger(selectedStars, 5);
        } catch (ParserExceptions e) {
            new ExceptionsController(e);
        }

        Review data = new Review("0", USER, BOOK_ISBN, stars, comment.getText());
        try {
            this.reviewService.addUserReview(data);
        } catch (ReviewsException e) {
            new ExceptionsController(e);
        }
    }

    public void drawReviewsList(int line) {
        List<Review> reviews = reviewService.getAllReviewsByISBN(BOOK_ISBN);

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


