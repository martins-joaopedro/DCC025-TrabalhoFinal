package br.ufjf.ui.components.cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import br.ufjf.models.Book;
import br.ufjf.ui.UIConstants;

public class BookCard extends JPanel {

    public BookCard(Book book) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(UIConstants.BOOKCARD_WIDTH, UIConstants.BOOKCARD_HEIGHT));
        setBackground(Color.WHITE);

        Border roundedBorder = BorderFactory.createLineBorder(Color.GRAY, 2, true); // true para cantos arredondados
        Border padding = BorderFactory.createEmptyBorder(5, 2, 2, 2); // Espaçamento interno
        setBorder(BorderFactory.createCompoundBorder(roundedBorder, padding));

        JPanel header = new JPanel();
            header.setLayout(new GridLayout(2, 1, 15, 5));
            header.add(new JLabel(book.getName()));
            header.add(new JLabel(book.getAuthor()));
            header.setBackground(Color.WHITE);
        add(header);

        JTextArea a = new JTextArea(book.getSynopsis());
            a.setEditable(false);
            a.setWrapStyleWord(true);
            a.setAutoscrolls(true);
            a.setLineWrap(true);
            a.setBackground(Color.WHITE);
        add(a);
    }

}