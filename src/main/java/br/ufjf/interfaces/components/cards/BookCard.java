package br.ufjf.interfaces.components.cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Book;
import br.ufjf.models.PersonalBook;
import br.ufjf.models.enums.Status;
import br.ufjf.services.ReviewService;

public class BookCard extends JPanel {

    private final JLabel bookName = new JLabel();
    private final JLabel autor = new JLabel();
    private final JLabel genero = new JLabel();
    private static final int BOOKCARD_WIDTH = 300;
    private static final int BOOKCARD_HEIGHT = 250;

    public BookCard(Book book) {

        this.bookName.setText(book.getName());
        this.autor.setText(book.getAuthor());
        this.bookName.setFont(Style.getFitFont().deriveFont(Font.BOLD));
        this.autor.setFont(Style.getFitFont().deriveFont(Font.BOLD));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setMinimumSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setMaximumSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setBackground(Style.getBackgroundColor());

        Border roundedBorder = BorderFactory.createLineBorder(Color.GRAY, 2, true); // true para cantos arredondados
        Border padding = BorderFactory.createEmptyBorder(5, 2, 2, 2); // Espaçamento interno
        setBorder(BorderFactory.createCompoundBorder(roundedBorder, padding));

        JPanel header = new JPanel();
            header.setLayout(new GridLayout(2, 1, 15, 5));
            header.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
            header.add(this.bookName);
            header.add(this.autor);
            header.setBackground(Style.getBackgroundColor());
        add(header);

        JTextArea sinopsysArea = new JTextArea(book.getSynopsis());
            sinopsysArea.setFont(Style.getFitFont().deriveFont(Font.PLAIN, 10));
            sinopsysArea.setEditable(false);
            sinopsysArea.setWrapStyleWord(true);sinopsysArea.setAutoscrolls(true);
            sinopsysArea.setLineWrap(true);
            sinopsysArea.setPreferredSize(new Dimension(BOOKCARD_WIDTH, 50));
            sinopsysArea.setMinimumSize(new Dimension(BOOKCARD_WIDTH, 50));
            sinopsysArea.setMaximumSize(new Dimension(BOOKCARD_WIDTH, 50));
            sinopsysArea.setBackground(Style.getBackgroundColor());
        add(sinopsysArea);
    }

    public BookCard(PersonalBook book) {

        this.bookName.setText(book.getName());
        this.autor.setText(book.getAuthor());
        this.genero.setText("Genero: " + book.getGenre().getDisplayName());
        this.bookName.setFont(Style.getFitFont().deriveFont(Font.BOLD));
        this.autor.setFont(Style.getFitFont().deriveFont(Font.BOLD));
        this.genero.setFont(Style.getFitFont().deriveFont(Font.PLAIN));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setMinimumSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setMaximumSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setBackground(Style.getBackgroundColor());

        Border roundedBorder = BorderFactory.createLineBorder(Color.GRAY, 2, true); // true para cantos arredondados
        Border padding = BorderFactory.createEmptyBorder(5, 2, 2, 2); // Espaçamento interno
        setBorder(BorderFactory.createCompoundBorder(roundedBorder, padding));

        JPanel header = new JPanel();
            header.setLayout(new GridLayout(4, 0, 15, 5));
            header.add(this.bookName);
            header.add(this.autor);
            header.add(this.genero);
            header.add(bookInfo(book));
            header.setBackground(Style.getBackgroundColor());
        add(header);
    }

    private JLabel bookInfo(PersonalBook book) {

        JLabel info = new JLabel();
        info.setFont(Style.getFitFont().deriveFont(Font.PLAIN));

        if(book.getStatus().equals(Status.LENDO)) {
            info.setText("Página atual: " + String.valueOf(book.getCurrentPage()));
        }

        return info;
    }

    public void addButtons(Button... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 6));
        buttonPanel.setBackground(Style.getBackgroundColor());
        
        for (JComponent button : buttons) {
            button.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
            buttonPanel.add(button);
        }

        buttonPanel.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
        add(buttonPanel);
    } 

}