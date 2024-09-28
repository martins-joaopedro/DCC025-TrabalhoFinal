package br.ufjf.interfaces.screens.review;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.ParserExceptions;
import br.ufjf.exceptions.ReviewsException;
import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.screens.libraries.Library;
import br.ufjf.interfaces.screens.libraries.PersonalLibrary;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Review;
import br.ufjf.services.ReviewService;
import br.ufjf.utils.InputParser;

public class ReviewEdition extends BasicScreen {

    private ReviewService service = new ReviewService();
    private String BOOK_ISBN = AplicationWindow.getBook();
    private String USER = AplicationWindow.getUser();
    private Review review;

    private JComboBox<String> starsBox = new JComboBox<>();
    private String selectedStars;
    private JTextArea comment = new JTextArea();

    public ReviewEdition() {
        super("personalLibrary");

        addTitle(new JLabel("Avaliações"));
        this.review = service.getUserReviewByISBN(BOOK_ISBN, USER);
        this.comment.setText(review.getComment());
        this.selectedStars = String.valueOf(review.getStars());

        for(int i=1; i<=5; i++) {
            this.starsBox.addItem(String.valueOf(i));
        }

        addComponent(new JLabel("Estrelas: "), 0, 1);
        starsBox.addActionListener(e -> {
            this.selectedStars = starsBox.getSelectedItem().toString();
        });
        starsBox.setSelectedItem(this.selectedStars);
        addComponent(starsBox, 0, 3);

        comment.setPreferredSize(new Dimension(300, 80));
        comment.setMinimumSize(new Dimension(300, 80));
        comment.setEditable(true);
        comment.setWrapStyleWord(true);
        comment.setAutoscrolls(true);
        comment.setLineWrap(true);
        comment.setBackground(Style.getLightBackgroundColor());
        addComponent(comment, 0, 5);

        JButton save = new JButton("Salvar");
        save.addActionListener(e -> updateDataController());
        addComponent(save, 0, 7);
    }

    public void updateDataController() {

        int stars = 0;
        try {
            stars = InputParser.toInteger(selectedStars.toString(), 5);
        } catch (ParserExceptions e) {
            new ExceptionsController(e);
        }

        try {
            service.update(new Review(review.getId(), USER, BOOK_ISBN, stars, comment.getText()));
        } catch (ReviewsException e) {
            new ExceptionsController(e);
        }

        AplicationWindow.reloadScreen(new Library(), "library");
        AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
    }
}
