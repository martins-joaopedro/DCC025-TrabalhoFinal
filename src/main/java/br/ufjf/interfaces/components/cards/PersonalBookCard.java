package br.ufjf.interfaces.components.cards;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.PersonalBook;
import br.ufjf.models.Review;
import br.ufjf.models.enums.Status;
import br.ufjf.services.PersonalLibraryService;

public class PersonalBookCard extends BookCard {

    private PersonalLibraryService service = new PersonalLibraryService();

    private Review userReview;
    private PersonalBook book;

    private final Button editBook = new Button("Editar");
    private final Button removeBook = new Button("Remover");
    private final Button editReview = new Button("Editar Avaliação");

    public PersonalBookCard(PersonalBook book) {
        super(book);

        this.book = book;
        userReview = reviewService.getUserReviewByISBN(book.getISBN(), AplicationWindow.getUser());

        JLabel genero = new JLabel("Genero: " + book.getGenre().getDisplayName());
        genero.setFont(Style.getFitFont().deriveFont(Font.PLAIN));
        header.add(genero);
        header.add(drawInformationByStatus(book));

        drawButtons(book.getISBN());
    }

    private JPanel drawInformationByStatus(PersonalBook book) {

        JPanel info = new JPanel();
        info.setBackground(Style.getBackgroundColor());
        info.setFont(Style.getFitFont().deriveFont(Font.PLAIN));

        switch (book.getStatus()) {
            case LENDO:
                info.add(new JLabel("Página atual: " + book.getCurrentPage() + "/" + book.getPages() + "."));
                break;
                
            case RELENDO:
                info.add(new JLabel("Página atual: " + book.getCurrentPage() + "/" + book.getPages() + "."));
                break;

            case LIDO:
                if (userReview != null)
                    for (int i = 0; i < userReview.getStars(); i++)
                        info.add(new ImageCard("star.png", 20, 20, Style.getBackgroundColor()));
                else 
                    info.add(new JLabel("Livro sem avaliação."));
                break;

            case ABANDONEI:
                info.add(new JLabel("Livro abandonado na página " + book.getCurrentPage() + "/" + book.getPages() + "."));
                break;

            default:
                break;
        }

        return info;
    }

    @Override
    protected void drawButtons(String ISBN) {
        editBook.addActionListener(e -> AplicationWindow.showBookScreen("bookEdit", ISBN));
        removeBook.addActionListener(e -> service.removeFromPersonalLibrary(ISBN));

        seeReview.addActionListener(e -> AplicationWindow.showReviewScreen(ISBN));
        editReview.addActionListener(e -> AplicationWindow.showEditReviewScreen(ISBN));

        if(userReview == null && this.book.getStatus() == Status.LIDO)
            seeReview.setText("Avaliar livro");

        addButtons(seeReview);

        addButtons(editBook, removeBook);
    }

}
