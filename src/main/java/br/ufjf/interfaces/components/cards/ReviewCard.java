package br.ufjf.interfaces.components.cards;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.UIConstants;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Review;
import br.ufjf.services.ReviewService;

public class ReviewCard extends BasicScreen {

    private ReviewService service = new ReviewService();
    String USER = AplicationWindow.getUser();
   
    public ReviewCard(Review review) {
        super(null, Style.getLightBackgroundColor());

        setPreferredSize(new Dimension(UIConstants.REVIEW_CARD_WIDTH, UIConstants.REVIEW_CARD_HEIGHT));
        setBorder(UIConstants.ROUNDED_BORDER);
        
        addComponent(new JLabel(review.getUsername()), 0, 0, false, 5);

        JTextArea comment = new JTextArea(review.getComment());
            comment.setFont(Style.getFitFont());
            comment.setPreferredSize(new Dimension(150, 120));
            comment.setMinimumSize(new Dimension(150, 120));
            comment.setEditable(false);
            comment.setWrapStyleWord(true);
            comment.setAutoscrolls(true);
            comment.setLineWrap(true);
        addComponent(comment, 0, 1, false, 5);

        JPanel starsPanel = new JPanel();
        for(int i=0; i<review.getStars(); i++)
            starsPanel.add(new ImageCard("star.png", 10, 10, getBackground()));

        addComponent(starsPanel, 0, 2, false, 5);

        Button editReview = new Button("Editar Avaliação");
        editReview.addActionListener(e -> {
            AplicationWindow.showEditReviewScreen(review.getISBN());
        });

        if(review.getUsername().equalsIgnoreCase(USER))
            addComponent(editReview, 0, 4, true);
    }
}
