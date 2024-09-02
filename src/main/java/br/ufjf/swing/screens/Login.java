package br.ufjf.swing.screens;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufjf.swing.components.Button;


public class Login extends Screen {
    
    JPanel mainPanel;

    public Login(String screenName, Button navigator)  {
        super(screenName, navigator);

        mainPanel = new JPanel();

        mainPanel.add(new JTextField("LOGINNNNNNNNNNN"));

        setCenterComponent(mainPanel);
    }
}
