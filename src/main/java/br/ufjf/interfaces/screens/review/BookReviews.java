package br.ufjf.interfaces.screens.review;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.ParserExceptions;
import br.ufjf.exceptions.ReviewsException;
import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.UIConstants;
import br.ufjf.interfaces.components.cards.ReviewCard;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.screens.libraries.PersonalLibrary;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Review;
import br.ufjf.models.enums.Status;
import br.ufjf.services.PersonalLibraryService;
import br.ufjf.services.ReviewService;
import br.ufjf.utils.InputParser;

public class BookReviews extends BasicScreen {

    private ReviewService reviewService = new ReviewService();
    private PersonalLibraryService service = new PersonalLibraryService();

    String BOOK_ISBN = AplicationWindow.getBook();
    String USER = AplicationWindow.getUser();
    private boolean isAdm = false;

    private JTextField comment = new JTextField();
    private JComboBox<String> starsBox = new JComboBox<>();
    private String selectedStars = "1";

    public BookReviews(boolean isAdm, int onPage) {
        super(null);

        setPreferredSize(new Dimension(300, 420));
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);


        this.isAdm = isAdm;
        drawReviewsList(onPage);
    }

    public BookReviews(boolean isAdm) {
        super("adm");

        this.isAdm = true;
        
        addTitle(new JLabel("Avaliações do Livro: "));
        
        drawReviewsList(1);
    }
    
    public BookReviews() {
        super("personalLibrary");
        
        addTitle(new JLabel("Avaliações do Livro: "));

        Review review = reviewService.getUserReviewByISBN(BOOK_ISBN, USER);
        Status status = null;
        if (service.isOnPersonalLibrary(BOOK_ISBN)) {
            status = service.getAsPersonalBook(BOOK_ISBN).getStatus();

            if (review == null && status == Status.LIDO) {
            drawAddReviewPanel();
            }
        }
        drawReviewsList(review == null && status == Status.LIDO ? 1 : 0);
    }

    public void drawAddReviewPanel() {

        BasicScreen info = new BasicScreen(null, Style.getLightBackgroundColor());
        info.setPreferredSize(new Dimension(UIConstants.REVIEW_CARD_WIDTH, UIConstants.REVIEW_CARD_WIDTH));
        info.setBorder(UIConstants.ROUNDED_BORDER);
        
        info.addComponent(new JLabel("Autor: " + AplicationWindow.getUser()), 0, 0, Style.getMainFont().deriveFont(Font.BOLD, 18));
        info.addComponent(new JLabel("Comentário: "), 0, 1);
        comment.setPreferredSize(new Dimension(250, 100));
        info.addComponent(comment, 0, 2);

        info.addComponent(new JLabel("Estrelas: "), 0, 2);
        for(int i=1; i<=5; i++) {
            this.starsBox.addItem(String.valueOf(i));
        }

        this.starsBox.addActionListener(e -> {
            this.selectedStars = starsBox.getSelectedItem().toString();
        });
        info.addComponent(starsBox, 0, 3);

        Button save = new Button("Salvar");
        save.addActionListener(e -> addReviewController());
        info.addComponent(save, 0, 4, true, 15);

        addComponent(info, 0, 0);
    }

    private void addReviewController() {

        int stars = 0;
        try {
            stars = InputParser.toInteger(selectedStars, 5);
        } catch (ParserExceptions e) {
            new ExceptionsController(e);
        }

        Review data = new Review("0", USER, BOOK_ISBN, stars, comment.getText());
        try {
            this.reviewService.addUserReview(data);
            AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
        } catch (ReviewsException e) {
            new ExceptionsController(e);
        }
    }

    public void drawReviewsList(int line) {
        List<Review> reviews = reviewService.getAllReviewsByISBN(BOOK_ISBN);

        if(reviews.isEmpty() && line == 0) {
            addComponent(new JLabel("Nenhuma avaliação disponível"), 0, line);
        } else {
            int i = 0;
            for (Review review : reviews) {
                addComponent(new ReviewCard(review, this.isAdm), 0, line+i, true);
                i++;
            }
        }
    }
}


