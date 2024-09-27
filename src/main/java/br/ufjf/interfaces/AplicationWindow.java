package br.ufjf.interfaces;

import javax.swing.*;

import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.*;

import java.awt.*;

public class AplicationWindow {

    // CardLayout para alternar entre as telas
    static private CardLayout cardLayout;
    static private JPanel mainPanel;

    static private String book;

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
        mainPanel.add(new PersonalLibrary(), "personalLibrary");
        mainPanel.add(new Library(), "library");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    static public void showScreen(String screenName) {
        cardLayout.show(mainPanel, screenName);
    }

    static public void showScreen(String screenName, String book) {
        AplicationWindow.book = book;
        mainPanel.add(new BookInfo(), "bookInfo");
        cardLayout.show(mainPanel, screenName);
    }

    static public String getBook() {
        return book;
    }
}
