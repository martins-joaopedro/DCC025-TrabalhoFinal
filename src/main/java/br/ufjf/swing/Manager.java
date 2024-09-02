package br.ufjf.swing;

import br.ufjf.swing.components.Button;
import br.ufjf.swing.panels.Panel;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Manager {

    Window window;
    Map<String, JPanel> panels;

    public Manager() {
        this.panels = new HashMap<>();
        this.window = new Window("App", this);

        this.window.addPanel("2", new Panel("1", this, new Button("ir pra Tela 2", "1", this) ));
        this.window.addPanel("1", new Panel("2", this, new Button("ir p Tela 1", "2", this) ));

    }

    public void navigateTo(String screenName) {
        this.window.showPanel(screenName);
    }

    public void start() {
        this.window.start();
    }

}
