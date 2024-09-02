package br.ufjf.swing.panels;

import br.ufjf.swing.Manager;
import br.ufjf.swing.components.Button;

import javax.swing.*;

public class Panel extends JPanel {

    private JLabel title;
    private Button navigator;

    public Panel(String screenName, Manager manager, Button navigator) {

        this.title = new JLabel("Esta é a " + screenName);
        this.navigator = navigator;

        add(title);
        add(navigator);
    }
}
