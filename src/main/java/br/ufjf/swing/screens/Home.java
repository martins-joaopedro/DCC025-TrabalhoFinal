package br.ufjf.swing.screens;

import br.ufjf.swing.Manager;
import br.ufjf.swing.components.Button;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {

    JPanel mainPanel;

    public Home(Manager manager) {
        this.mainPanel = new JPanel(new BorderLayout());

        mainPanel.setPreferredSize(new Dimension(800, 800));
        mainPanel.add(new JButton("Norte"), BorderLayout.NORTH);
        mainPanel.add(new JButton("Sul"), BorderLayout.SOUTH);
        mainPanel.add(new JButton("Leste"), BorderLayout.EAST);
        mainPanel.add(new JButton("Oeste"), BorderLayout.WEST);
        mainPanel.add(new Button("A", "1", manager), BorderLayout.CENTER);

        this.add(mainPanel);

        //setBackground(Color.red);
    }

    @Override
    public void setBackground(Color bgColor) {
        super.setBackground(Color.red);
    }
}
