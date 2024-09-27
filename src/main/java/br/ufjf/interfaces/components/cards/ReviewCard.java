package br.ufjf.interfaces.components.cards;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Review;

public class ReviewCard extends JPanel {
    
    public ReviewCard(Review review) {

        setPreferredSize(new Dimension(150, 150));
        setMinimumSize(new Dimension(150, 150));
        setMaximumSize(new Dimension(150, 150));
        setBackground(Style.getBackgroundColor());
        
        JPanel reviewCard = new JPanel();
        reviewCard.add(new JLabel(review.getUsername()));
        reviewCard.add(new JLabel(review.getComment()));

        for(int i=0; i<review.getStars(); i++)
            reviewCard.add(new ImageCard("star.png", 10, 10));
        
        add(reviewCard);
    }
}
