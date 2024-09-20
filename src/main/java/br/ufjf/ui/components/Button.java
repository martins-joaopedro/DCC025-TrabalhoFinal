package br.ufjf.ui.components;

import javax.swing.*;

import br.ufjf.ui.Manager;

public class Button extends JButton {
    
    
    public Button(String text) {

        ImageIcon icon = new ImageIcon("content/icon.png");

        setIcon(icon);
        
        addActionListener(e -> Manager.navigateBack());
    }

    public Button(String text, String screenToNav) {

        setText(text);
        addActionListener(e -> Manager.navigateTo(screenToNav));
    }
}
