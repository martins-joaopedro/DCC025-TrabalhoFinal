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

    private final ReviewService reviewService = new ReviewService();

    private final JLabel bookName = new JLabel();
    private final JLabel autor = new JLabel();
    private final JLabel genero = new JLabel();

    public BookCard(Book book) {

        this.bookName.setText(book.getName());
        this.autor.setText(book.getAuthor());

        this.bookName.setFont(Style.getFitFont().deriveFont(Font.BOLD));
        this.autor.setFont(Style.getFitFont().deriveFont(Font.BOLD));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(150, 150));
        setMinimumSize(new Dimension(150, 150));
        setMaximumSize(new Dimension(150, 150));
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

        JTextArea a = new JTextArea(book.getSynopsis());
            a.setFont(Style.getFitFont().deriveFont(Font.PLAIN, 10));
            a.setEditable(false);
            a.setWrapStyleWord(true);
            a.setAutoscrolls(true);
            a.setLineWrap(true);
            a.setPreferredSize(new Dimension(150, 50));
            a.setMinimumSize(new Dimension(150, 50));
            a.setMaximumSize(new Dimension(150, 50));
            a.setBackground(Style.getBackgroundColor());
        add(a);
    }

    public BookCard(PersonalBook book) {

        this.bookName.setText(book.getName());
        this.autor.setText(book.getAuthor());
        try {
            this.genero.setText("Genero: " + book.getGenre().getType());
        } catch (Exception e) {
            this.genero.setText("Genero: Não informado");
        }

        this.bookName.setFont(Style.getFitFont().deriveFont(Font.BOLD));
        this.autor.setFont(Style.getFitFont().deriveFont(Font.BOLD));
        this.genero.setFont(Style.getFitFont().deriveFont(Font.PLAIN));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 150));
        setMinimumSize(new Dimension(200, 150));
        setMaximumSize(new Dimension(200, 150));
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
        else if(book.getStatus().equals(Status.LIDO)) {
            try {
                //info.setText(reviewService.getReview(book.getISBN(), book.getUser()).getStars() + " / 5 estrelas.");
            } catch (Exception e) {
                info.setText("Sem avaliação.");
            }
        }
        
        return info;
    }

    public void addButtons(Button... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 6)); // Cria um painel com FlowLayout
        buttonPanel.setBackground(Style.getBackgroundColor()); // Define a cor de fundo
        
        for (JComponent button : buttons) { // Adiciona cada botão ao painel
            button.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
            buttonPanel.add(button);
        }
        
        buttonPanel.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
        add(buttonPanel);
    } 

}