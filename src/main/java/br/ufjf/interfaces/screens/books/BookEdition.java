package br.ufjf.interfaces.screens.books;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.ParserExceptions;
import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.UIConstants;
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
import br.ufjf.utils.InputParser;

public class BookEdition extends BasicScreen {

    private PersonalLibraryService personalLibraryService = new PersonalLibraryService();
    private ReviewService reviewService = new ReviewService();

    private String BOOK_ISBN = AplicationWindow.getBook();
    private String USER = AplicationWindow.getUser();
    private PersonalBook book;
    private Review review;

    private JComboBox<String> statusBox = new JComboBox<>();
    private JComboBox<String> starsBox = new JComboBox<>();
    private Status selectedStatus;
    private String selectedStars;
    private TextField currentPage = new TextField(10);

    JTextArea comment = new JTextArea("");

    public BookEdition() {
        super("personalLibrary");

        addTitle(new JLabel("Editar"));

        this.book = personalLibraryService.getAsPersonalBook(BOOK_ISBN);
        this.review = reviewService.getUserReviewByISBN(BOOK_ISBN, USER);
        this.currentPage.setText(String.valueOf(book.getCurrentPage()));
        this.selectedStatus = book.getStatus();

        addComponent(new JLabel("Nome: " + book.getName()), 0, 0);
        addComponent(new JLabel("Gênero: " + book.getGenre().getDisplayName()), 0, 1);
        JTextArea synopsys = new JTextArea("Sinopse: " + book.getSynopsis());
        synopsys.setPreferredSize(new Dimension(UIConstants.TEXTBOX_WIDTH, UIConstants.TEXTBOX_HEIGHT));
        synopsys.setMinimumSize(new Dimension(UIConstants.TEXTBOX_WIDTH, UIConstants.TEXTBOX_HEIGHT));
        synopsys.setMaximumSize(new Dimension(UIConstants.TEXTBOX_WIDTH, UIConstants.TEXTBOX_HEIGHT));
        synopsys.setWrapStyleWord(true);
        synopsys.setEditable(false);
        synopsys.setAutoscrolls(true);
        synopsys.setLineWrap(true);
        synopsys.setBackground(Style.getBackgroundColor());
        addComponent(synopsys, 0, 2);

        if(book.getStatus() == Status.LENDO || book.getStatus() == Status.RELENDO) {
            addComponent(new JLabel("Página atual: " + book.getCurrentPage()), 0, 3);
            addComponent(currentPage, 0, 4);
        }

        for(Status s : Status.values()) {
            statusBox.addItem(s.getDisplayName());
        }
        statusBox.setSelectedItem(this.selectedStatus.getDisplayName());

        addComponent(new JLabel("Status: "), 0, 5);
        statusBox.addActionListener(e -> {
            this.selectedStatus = Status.fromDisplayName(statusBox.getSelectedItem().toString());
        });
        addComponent(statusBox, 0, 6);

        if(review != null)
            drawReviewEdition();

        Button save = new Button("Salvar");
        save.addActionListener(e -> updateDataController());
        addButtons(save);
    }

    public void drawReviewEdition() {

        this.selectedStars = String.valueOf(review.getStars());

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
        comment.setPreferredSize(new Dimension(UIConstants.TEXTBOX_WIDTH, UIConstants.TEXTBOX_HEIGHT+50));
        comment.setMinimumSize(new Dimension(UIConstants.TEXTBOX_WIDTH, UIConstants.TEXTBOX_HEIGHT+50));
        comment.setMaximumSize(new Dimension(UIConstants.TEXTBOX_WIDTH, UIConstants.TEXTBOX_HEIGHT+50));
        comment.setEditable(true);
        comment.setWrapStyleWord(true);
        comment.setAutoscrolls(true);
        comment.setLineWrap(true);
        comment.setBackground(Style.getLightBackgroundColor());
        addComponent(comment, 0, 9);
    }

    public void updateDataController() {
        int page = this.book.getCurrentPage();
        int stars = 0;
        try {
            page = InputParser.toInteger(currentPage.getText(), book.getPages());
            if(review != null)
                stars = InputParser.toInteger(selectedStars.toString(), 5);
        } catch (ParserExceptions e) {
            new ExceptionsController(e);
        }

        try {
            personalLibraryService.update(new PersonalBookDTO(BOOK_ISBN, USER, selectedStatus, page));
            if(review != null)
                reviewService.update(new Review(review.getId(), USER, BOOK_ISBN, stars, comment.getText()));
        } catch (Exception e) {
            new ExceptionsController(e);
        }

        AplicationWindow.reloadScreen(new Library(), "library");
        AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
    }
}
