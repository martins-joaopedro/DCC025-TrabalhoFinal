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

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.UIConstants;
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

    ReviewService service = new ReviewService();
    private final Button seeReview = new Button("Ver Avaliações");
    
    public BookCard(Book book) {
        
        int reviewsAmount = service.getReviewsByISBN(book.getISBN()).size();

        this.bookName.setText(book.getName());
        this.autor.setText(book.getAuthor());
        this.bookName.setFont(Style.getFitFont().deriveFont(Font.BOLD));
        this.autor.setFont(Style.getFitFont().deriveFont(Font.BOLD));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setMinimumSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setMaximumSize(new Dimension(BOOKCARD_WIDTH, BOOKCARD_HEIGHT));
        setBackground(Style.getBackgroundColor());
        setBorder(UIConstants.ROUNDED_BORDER);

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

        seeReview.addActionListener(e -> AplicationWindow.showReviewScreen(book.getISBN()));
        if(reviewsAmount > 0)
            addButtons(seeReview);
    }

    public BookCard(PersonalBook book) {

        int reviewsAmount = service.getReviewsByISBN(book.getISBN()).size();

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

        setBorder(UIConstants.ROUNDED_BORDER);

        JPanel header = new JPanel();
            header.setLayout(new GridLayout(4, 0, 15, 5));
            header.add(this.bookName);
            header.add(this.autor);
            header.add(this.genero);
            header.add(bookInfo(book));
            header.setBackground(Style.getBackgroundColor());
        add(header);

        seeReview.addActionListener(e -> AplicationWindow.showReviewScreen(book.getISBN()));
        if(reviewsAmount > 0)
            addButtons(seeReview);
    }

    private JPanel bookInfo(PersonalBook book) {

        JPanel info = new JPanel();
        info.setBackground(Style.getBackgroundColor());
        info.setFont(Style.getFitFont().deriveFont(Font.PLAIN));

        if(book.getStatus().equals(Status.LENDO)) {
        } else if (book.getStatus().equals(Status.LIDO)) {
            if(service.getUserReviewByISBN(book.getISBN(), AplicationWindow.getUser()) != null) {
                for(int i=0; i<service.getUserReviewByISBN(book.getISBN(), AplicationWindow.getUser()).getStars(); i++)
                    info.add(new ImageCard("star.png", 20, 20, Style.getBackgroundColor()));;
            } else {
                info.add(new JLabel("Livro sem avaliação."));
            }
        } else if(book.getStatus().equals(Status.ABANDONEI)) {
            info.add(new JLabel("Livro abandonado na página " + book.getCurrentPage() + "/" + book.getPages() + "."));
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