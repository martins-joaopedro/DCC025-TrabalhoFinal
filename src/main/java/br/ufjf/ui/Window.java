package br.ufjf.ui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

    private JPanel mainPanel;
    private CardLayout layout;

    Window(String title) {

        setTitle(title);
        setSize(UIConstants.SCREEN_WIDTH, UIConstants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.layout = new CardLayout();
        this.mainPanel = new JPanel(layout);
    }

    public void addScreen (String panelName, JPanel panel) {
        this.mainPanel.add(panelName, panel);
    }

    public void showPanel(String panelName) {
        System.out.println(panelName);
        
        this.layout.show(mainPanel, panelName);
    }

    public void start() {
        this.showPanel("home");
        add(mainPanel);
        setVisible(true);
    }
}
