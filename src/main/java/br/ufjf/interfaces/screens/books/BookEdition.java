package br.ufjf.interfaces.screens.books;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.screens.libraries.Library;
import br.ufjf.interfaces.screens.libraries.PersonalLibrary;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.interfaces.widgets.TextField;
import br.ufjf.models.PersonalBook;
import br.ufjf.models.Review;
import br.ufjf.models.dto.PersonalBookDTO;
import br.ufjf.models.enums.Status;
import br.ufjf.services.PersonalLibraryService;
import br.ufjf.services.ReviewService;

public class BookEdition extends BasicScreen {

    PersonalLibraryService personalLibraryService = new PersonalLibraryService();
    ReviewService reviewService = new ReviewService();

    String BOOK_ISBN = AplicationWindow.getBook();
    String USER = AplicationWindow.getUser();

    PersonalBook book;
    Review review;

    JComboBox<String> statusBox = new JComboBox<>();
    JComboBox<String> starsBox = new JComboBox<>();
    private Status selectedStatus;
    private String selectedStars;
    private TextField currentPage = new TextField(30);

    JTextArea comment = new JTextArea("");

    public BookEdition() {
        super("personalLibrary");

        addTitle(new JLabel("Editar"));

        this.book = personalLibraryService.getAsPersonalBook(BOOK_ISBN);
        this.review = reviewService.getUserReviewByISBN(BOOK_ISBN, USER);
        this.currentPage.setText(String.valueOf(book.getCurrentPage()));
        this.selectedStars = String.valueOf(review.getStars());
        this.selectedStatus = book.getStatus();

        addComponent(new JLabel("Nome: " + book.getName()), 0, 0);
        addComponent(new JLabel("Gênero: " + book.getGenre().getDisplayName()), 0, 1);
        addComponent(new JLabel("Sinopse: " + book.getSynopsis()), 0, 2);
        addComponent(new JLabel("Página atual: " + book.getCurrentPage()), 0, 3);
        addComponent(currentPage, 0, 4);

        for(Status s : Status.values()) {
            statusBox.addItem(s.getDisplayName());
        }
        statusBox.setSelectedItem(this.selectedStatus.getDisplayName());

        addComponent(new JLabel("Status: "), 0, 5);
        statusBox.addActionListener(e -> {
            this.selectedStatus = Status.fromDisplayName(statusBox.getSelectedItem().toString());
        });
        addComponent(statusBox, 0, 6);

        for(int i=1; i<=5; i++) {
            this.starsBox.addItem(String.valueOf(i));
        }
        starsBox.setSelectedItem(this.selectedStars);

        addComponent(new JLabel("Estrelas: "), 0, 7);
        starsBox.addActionListener(e -> {
            this.selectedStars = starsBox.getSelectedItem().toString();
        });
        addComponent(starsBox, 0, 8);

        comment.setText(review.getComment());
        comment.setPreferredSize(new Dimension(500, 300));
        comment.setMinimumSize(new Dimension(500, 300));
        comment.setEditable(true);
        comment.setWrapStyleWord(true);
        comment.setAutoscrolls(true);
        comment.setLineWrap(true);
        comment.setBackground(Style.getLightBackgroundColor());
        addComponent(comment, 0, 9);

        JButton save = new Button("Salvar");
        save.addActionListener(e -> handleSave());
        addButtons(save);
    }

    public void handleSave() {

        int page = Integer.parseInt(currentPage.getText());
        int stars = Integer.parseInt(selectedStars);

        System.out.println(page);
        System.out.println(stars);

        personalLibraryService.update(new PersonalBookDTO(BOOK_ISBN, USER, selectedStatus, page));
        reviewService.update(new Review(review.getId(), USER, BOOK_ISBN, stars, comment.getText()));

        AplicationWindow.reloadScreen(new Library(), "library");
        AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
    }
}
