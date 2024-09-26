package br.ufjf.interfaces;

import javax.swing.*;

import br.ufjf.interfaces.widgets.Style;

import java.awt.*;

public class AplicationWindow {

    // CardLayout para alternar entre as telas
    static private CardLayout cardLayout;
    static private JPanel mainPanel;

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
        //mainPanel.add(new BookDetails(), "bookDetails");


        frame.add(mainPanel);
        frame.setVisible(true);
    }

    static public void showScreen(String screenName) {
        cardLayout.show(mainPanel, screenName);
    }
}
