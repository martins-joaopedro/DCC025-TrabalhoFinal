package br.ufjf.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufjf.ui.Window;
import br.ufjf.ui.components.Button;

import java.awt.*;

public class Screen extends JPanel {

    private int OFFSET = 100;
    JTextField title;
    JPanel mainPanel;

    Screen(String screenName, Button navigator, JPanel panel) {
        this.mainPanel = new JPanel(new BorderLayout());

        mainPanel.setPreferredSize(new Dimension(Window.WIDTH - OFFSET, Window.HEIGHT - OFFSET));
        title = new JTextField(screenName);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(navigator, BorderLayout.SOUTH);
        mainPanel.add(panel, BorderLayout.CENTER);

        add(mainPanel);
    }
}
