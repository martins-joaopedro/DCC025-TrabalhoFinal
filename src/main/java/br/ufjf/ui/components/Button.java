package br.ufjf.ui.components;

import javax.swing.*;

import br.ufjf.ui.Manager;

public class Button extends JButton {
    public Button(String text, String screenToNavigate, Manager manager) {

        setText(text);
        addActionListener(e -> manager.navigateTo(screenToNavigate));
    }
}
