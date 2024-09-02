package br.ufjf.swing.screens;

import br.ufjf.swing.Manager;
import br.ufjf.swing.components.Button;

import javax.swing.*;
import java.awt.*;

public class Home extends Screen {

    JPanel mainPanel;

    public Home(String screenName, Button navigator) {
       super(screenName, navigator);
        
        mainPanel = new JPanel();
        mainPanel.add(new JTextArea("A"));
        
        setCenterComponent(mainPanel);
    }

    
    @Override
    public void setBackground(Color bgColor) {
        super.setBackground(Color.red);
    }
}
