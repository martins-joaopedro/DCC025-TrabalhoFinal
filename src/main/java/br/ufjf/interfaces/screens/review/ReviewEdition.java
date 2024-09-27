package br.ufjf.interfaces.screens.review;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.screens.libraries.Library;
import br.ufjf.interfaces.screens.libraries.PersonalLibrary;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Review;
import br.ufjf.models.dto.PersonalBookDTO;
import br.ufjf.models.enums.Status;
import br.ufjf.services.ReviewService;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

public class ReviewEdition extends BasicScreen {

    ReviewService service = new ReviewService();

    JComboBox<String> starsBox = new JComboBox<>();
    private String selectedStars;
    private JTextArea comment = new JTextArea();

    Review review;
    String BOOK_ISBN = AplicationWindow.getBook();
    String USER = AplicationWindow.getUser();

    public ReviewEdition() {
        super("personalLibrary");

        review = service.getUserReviewByISBN(BOOK_ISBN, USER);
        comment.setText(review.getComment());
        selectedStars = String.valueOf(review.getStars());

        for(int i=1; i<=5; i++) {
            this.starsBox.addItem(String.valueOf(i));
        }

        addComponent(new JLabel("Estrelas: "), 0, 7);
        starsBox.addActionListener(e -> {
            this.selectedStars = starsBox.getSelectedItem().toString();
        });
        addComponent(starsBox, 0, 8);

        comment.setPreferredSize(new Dimension(300, 80));
        comment.setMinimumSize(new Dimension(300, 80));
        comment.setEditable(true);
        comment.setWrapStyleWord(true);
        comment.setAutoscrolls(true);
        comment.setLineWrap(true);
        comment.setBackground(Style.getLightBackgroundColor());
        addComponent(comment, 0, 8);

        JButton save = new JButton("Salvar");
        save.addActionListener(e -> handleSave());
        addComponent(save, 0, 9);
    }

    public void handleSave() {

        int stars = Integer.parseInt(selectedStars);

        service.update(new Review(review.getId(), USER, BOOK_ISBN, stars, comment.getText()));

        AplicationWindow.reloadScreen(new Library(), "library");
        AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
    }
}
