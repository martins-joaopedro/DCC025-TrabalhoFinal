package br.ufjf.interfaces.components.cards;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufjf.interfaces.UIConstants;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Book;
import br.ufjf.services.ReviewService;

public abstract class BookCard extends JPanel {
    
    protected final JPanel header = new JPanel();

    private final JLabel bookName = new JLabel();
    private final JLabel autor = new JLabel();

    protected ReviewService reviewService = new ReviewService();
    protected int reviewsAmount;

    protected final Button seeReview = new Button("Ver Avaliações");
    
    public BookCard(Book book) {
        reviewsAmount = reviewService.getAllReviewsByISBN(book.getISBN()).size();

        this.bookName.setText(book.getName());
        this.autor.setText(book.getAuthor());
        this.bookName.setFont(Style.getFitFont().deriveFont(Font.BOLD));
        this.autor.setFont(Style.getFitFont().deriveFont(Font.BOLD));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, UIConstants.BOOK_CARD_HEIGHT));
        setMinimumSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, UIConstants.BOOK_CARD_HEIGHT));
        setMaximumSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, UIConstants.BOOK_CARD_HEIGHT));
        setBackground(Style.getBackgroundColor());
        setBorder(UIConstants.ROUNDED_BORDER);

        header.setLayout(new GridLayout(4, 1, 15, 5));
        header.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
        header.add(this.bookName);
        header.add(this.autor);
        header.setBackground(Style.getBackgroundColor());
        add(header);
    }

    public void addButtons(Button... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Style.getBackgroundColor());
        
        for (JComponent button : buttons) {
            button.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
            buttonPanel.add(button);
        }

        buttonPanel.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
        add(buttonPanel);
    }

    abstract protected void drawButtons(String ISBN);
}