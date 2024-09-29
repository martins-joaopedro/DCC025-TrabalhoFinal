package br.ufjf.interfaces;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.screens.books.BookEdition;
import br.ufjf.interfaces.screens.books.BookInformations;
import br.ufjf.interfaces.screens.books.NewBook;
import br.ufjf.interfaces.screens.general.Home;
import br.ufjf.interfaces.screens.libraries.Adm;
import br.ufjf.interfaces.screens.libraries.Library;
import br.ufjf.interfaces.screens.libraries.PersonalLibrary;
import br.ufjf.interfaces.screens.review.BookReviews;
import br.ufjf.interfaces.screens.review.ReviewEdition;
import br.ufjf.interfaces.screens.users.Login;
import br.ufjf.interfaces.screens.users.Register;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.User;

public class AplicationWindow {

    // CardLayout para alternar entre as telas
    private static CardLayout cardLayout;
    private static JPanel mainPanel;

    private static String book;
    private static String user;

    public AplicationWindow() {
        JFrame frame = new JFrame("Bookself");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Style.getWidth(), Style.getHeight());
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();

        mainPanel = new JPanel(cardLayout);
        mainPanel.add(new Home(), "home");
        mainPanel.add(new Login(), "login");
        mainPanel.add(new Register(), "register");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    static public void showScreen(String screenName) {
        if(screenName.equals("library"))
            mainPanel.add(new Library(), "library");
        else if(screenName.equals("personalLibrary"))
            mainPanel.add(new PersonalLibrary(), "personalLibrary");

        cardLayout.show(mainPanel, screenName);
    }

    static public void showBookScreen(String screenName, String book) {
        AplicationWindow.book = book;

        if(screenName.equals("bookInfo"))
            mainPanel.add(new BookInformations(), "bookInfo");
        else if(screenName.equals("bookEdit"))
            mainPanel.add(new BookEdition(), "bookEdit");
        else if(screenName.equals("newBook"))
            mainPanel.add(new NewBook(), "newBook");

        cardLayout.show(mainPanel, screenName);
    }

    public static void showReviewScreen(String ISBN) {
        AplicationWindow.book = ISBN;
        if(user.equals("admin"))
            mainPanel.add(new BookReviews(true), "bookReviews");
        else
            mainPanel.add(new BookReviews(), "bookReviews");

        cardLayout.show(mainPanel, "bookReviews");
    }

    public static void showEditReviewScreen(String ISBN) {
        AplicationWindow.book = ISBN;
        mainPanel.add(new ReviewEdition(), "reviewEdition");

        cardLayout.show(mainPanel, "reviewEdition");
    }

    static public String getBook() {
        return book;
    }

    static public void showScreen(String screenName, User user) {
        AplicationWindow.user = user.getUsername();

        if(user.getUsername().equals("admin"))
            mainPanel.add(new Adm(), "adm");
        else if(screenName.equals("personalLibrary"))
            mainPanel.add(new PersonalLibrary(), "personalLibrary");
        
        cardLayout.show(mainPanel, screenName);
    }

    static public String getUser() {
        return user;
    }

    static public void reloadScreen(BasicScreen screen, String screenName) {
        mainPanel.add(screen, screenName);
        cardLayout.show(mainPanel, screenName);
    }
}
