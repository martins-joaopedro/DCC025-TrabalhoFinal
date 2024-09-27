package br.ufjf.interfaces.components.cards;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Review;

public class ReviewCard extends JPanel {
    
    public ReviewCard(Review review) {

        //setPreferredSize(new Dimension(300, 200));
        setLayout(new GridBagLayout());
        setBackground(Style.getLightBackgroundColor());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 5, 0); // Espaçamento entre os componentes

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel(review.getUsername()), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextArea comment = new JTextArea(review.getComment());
            comment.setPreferredSize(new Dimension(300, 80));
            comment.setMinimumSize(new Dimension(300, 80));
            comment.setEditable(false);
            comment.setWrapStyleWord(true);
            comment.setAutoscrolls(true);
            comment.setLineWrap(true);
            comment.setBackground(Style.getLightBackgroundColor());
        add(comment, gbc);

        JPanel starsPanel = new JPanel();
        starsPanel.setBackground(Style.getLightBackgroundColor());
        for(int i=0; i<review.getStars(); i++)
            starsPanel.add(new ImageCard("star.png", 10, 10));

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(starsPanel, gbc);
    }
}
