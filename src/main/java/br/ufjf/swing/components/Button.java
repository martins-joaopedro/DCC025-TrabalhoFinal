package br.ufjf.swing.components;

import br.ufjf.swing.Manager;

import javax.swing.*;

public class Button extends JButton {
    public Button(String text, String screenToNavigate, Manager manager) {

        setText(text);
        addActionListener(e -> manager.navigateTo(screenToNavigate));
    }
}
