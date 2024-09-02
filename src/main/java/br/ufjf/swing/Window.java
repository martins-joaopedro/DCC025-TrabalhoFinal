package br.ufjf.swing;

import br.ufjf.swing.screens.Home;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private Manager manager;
    private final int WIDTH = 800;
    private final int HEIGHT = WIDTH;
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

    public void addPanel (String panelName, JPanel panel) {

        //JPanel j = new JPanel();

        //j.add(new Button("AAAAAAAAA"));

        this.mainPanel.add("h", new Home(this.manager));
        this.mainPanel.add(panelName, panel);

        //this.add.add("h", new Home());

    }

    public void showPanel(String panelName) {
        System.out.println(panelName);
        this.layout.show(mainPanel, panelName);
    }

    public void start() {
        this.layout.show(mainPanel, "h");
        add(mainPanel);
        setVisible(true);
    }

}
