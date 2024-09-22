package br.ufjf.ui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import br.ufjf.models.Book;
import br.ufjf.ui.UIConstants;
import br.ufjf.ui.frames.ReviewScreenFrame;

public class BookCard extends JPanel {

    public BookCard(Book book) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel header = new JPanel();
            header.setLayout(new GridLayout(2, 1, 15, 5));
            header.add(new JLabel(book.getName()));
            header.add(new JLabel(book.getAuthor()));
            header.setBackground(Color.WHITE);
        add(header);

        setPreferredSize(new Dimension(UIConstants.BOOKCARD_WIDTH, UIConstants.BOOKCARD_HEIGHT));
        setMaximumSize(new Dimension(UIConstants.BOOKCARD_WIDTH, UIConstants.BOOKCARD_HEIGHT));
        setBorder(BorderFactory.createTitledBorder(book.getName()));
        setBackground(Color.WHITE);

        Border roundedBorder = BorderFactory.createLineBorder(Color.GRAY, 2, true); // true para cantos arredondados
        Border padding = BorderFactory.createEmptyBorder(5, 2, 2, 2); // Espaçamento interno
        setBorder(BorderFactory.createCompoundBorder(roundedBorder, padding));

        JTextArea a = new JTextArea(book.getSynopsis());
            a.setEditable(false);
            a.setWrapStyleWord(true);
            a.setAutoscrolls(true);
            a.setLineWrap(true);
            a.setBackground(Color.WHITE);
        add(a);

        JPanel buttons = new JPanel();

            buttons.setLayout(new FlowLayout());
            buttons.setPreferredSize(new Dimension(30, 30));

            JButton seeReviews = new JButton("ver todas as avaliações");
            //Dimension fixedSize = new Dimension(150, 50);


        seeReviews.addActionListener(e -> handleOptions(book));
            buttons.add(seeReviews, BorderLayout.EAST);
        add(buttons);

        add(new Image("content/star.png", 10, 10));

    }
    public void handleOptions(Book book) {
        new ReviewScreenFrame(book);
    }
}