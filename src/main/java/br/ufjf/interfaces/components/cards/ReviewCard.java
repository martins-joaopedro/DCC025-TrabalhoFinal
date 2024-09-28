package br.ufjf.interfaces.components.cards;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.ReviewsException;
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

    public ReviewCard(Review review, boolean isAdm) {
        super(null, Style.getLightBackgroundColor());

        setPreferredSize(new Dimension(UIConstants.REVIEW_CARD_WIDTH, UIConstants.REVIEW_CARD_HEIGHT));
        setBackground(Style.getLightBackgroundColor());
        setBorder(UIConstants.ROUNDED_BORDER);

        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        JLabel username = new JLabel("Avaliação de " + review.getUsername());
            username.setFont(Style.getMainFont().deriveFont(Font.BOLD, 18));
            username.setBackground(Style.getLightBackgroundColor());
        addSimpleComponent(username, 0, 0);
        
        JPanel starsPanel = new JPanel();
            starsPanel.setBackground(Style.getLightBackgroundColor());
            for(int i=0; i<review.getStars(); i++)
                starsPanel.add(new ImageCard("star.png", 20, 20, Style.getLightBackgroundColor()));
        addSimpleComponent(starsPanel, 0, 1);

        JTextArea comment = new JTextArea(review.getComment());
            comment.setFont(Style.getFitFont());
            comment.setBackground(Style.getLightBackgroundColor());
            comment.setEditable(false);
            comment.setWrapStyleWord(true);
            comment.setAutoscrolls(true);
            comment.setLineWrap(true);
        addSimpleComponent(comment, 0, 2);
        
        Button editReview = new Button("Editar Avaliação");
        editReview.addActionListener(e -> {
            AplicationWindow.showEditReviewScreen(review.getISBN());
        });

        if(isAdm) {
            Button deleteReview = new Button("Deletar Avaliação");
            deleteReview.addActionListener(e -> deleteReviewController(review));
            addTopButtons(0, 3, deleteReview);
        } else if(review.getUsername().equalsIgnoreCase(USER))
            addTopButtons(0, 3, editReview);
    }

    public void addSimpleComponent(JComponent component, int gridx, int gridy) {

        this.centerPanel.setBackground(Style.getLightBackgroundColor());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.weightx = 1;

        gbc.insets = new Insets(10, 15, 0, 30);
        gbc.gridx = gridx;
        gbc.gridy = gridy;

        this.centerPanel.add(component, gbc);
    }

    private void deleteReviewController(Review review) {
        try {
            service.removeUserReview(review);        
        } catch (ReviewsException e) {
            new ExceptionsController(e);
        }
        AplicationWindow.showScreen("adm");
    }
}
