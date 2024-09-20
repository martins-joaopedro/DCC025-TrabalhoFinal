package br.ufjf.ui.components;

import javax.swing.*;

import br.ufjf.ui.Manager;
import br.ufjf.ui.UIConstants;

import java.awt.*;

public class Button extends JButton {

    public Button(String text) {
        addActionListener(e -> Manager.navigateBack());
        setPreferredSize(new Dimension(30, 30));
        setMargin(new Insets(0, 0, 0, 0));
        add(new Image("content/icon.png", UIConstants.ICON_SIZE, UIConstants.ICON_SIZE));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setBackground(Color.WHITE);
    }

    public Button(String text, String screenToNav) {
        setText(text);
        addActionListener(e -> Manager.navigateTo(screenToNav));
    }
}
