package br.ufjf.swing;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public static Manager manager;
    public static final int WIDTH = 500;
    public static final int HEIGHT = WIDTH;
    private JPanel mainPanel;
    private CardLayout layout;

    Window(String title, Manager manager) {
        this.manager = manager;

        setTitle(title);
        setSize(WIDTH, HEIGHT);
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
        this.layout.show(mainPanel, "home");
        add(mainPanel);
        setVisible(true);
    }

    public static Manager getManager() {
        return manager;
    }

}
