package br.ufjf.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.ufjf.ui.components.Button;

public class Screen extends JPanel {

    String screenName;
    JPanel mainPanel;
    JPanel centerPanel;
    Button navigator;

    public Screen(String screenName, Button navigator, JPanel panel) {
        this.screenName = screenName;
        this.navigator = navigator;
        this.centerPanel = panel;

        draw();
    }

    public Screen(String screenName, JPanel panel) {
        this.screenName = screenName;
        this.navigator = null;
        this.centerPanel = panel;

        draw();
    }

    public void draw() {
        this.mainPanel = new JPanel();

        mainPanel.setPreferredSize(new Dimension(UIConstants.SCREEN_WIDTH - UIConstants.OFFSET, UIConstants.SCREEN_HEIGHT - UIConstants.OFFSET));

        // Cria o título
        JLabel title = new JLabel(screenName, SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 24)); // Define uma fonte maior

        // Cria o painel de cabeçalho
        JPanel header = new JPanel(new BorderLayout(2, 1));
        header.setPreferredSize(new Dimension(UIConstants.SCREEN_WIDTH  - UIConstants.OFFSET, 75));

        System.out.println(screenName);

        if(navigator != null) {
            JPanel buttonArea = new JPanel(new BorderLayout(3, 1));
            buttonArea.add(navigator, BorderLayout.WEST);
            header.add(buttonArea, BorderLayout.NORTH);
            header.add(title, BorderLayout.SOUTH);
        }

        mainPanel.add(header);
        mainPanel.add(centerPanel);

        add(mainPanel);
    }

}
