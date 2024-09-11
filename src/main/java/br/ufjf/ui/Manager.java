package br.ufjf.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufjf.ui.components.Button;
import br.ufjf.ui.screens.Collection;
import br.ufjf.ui.screens.Configuracao;
import br.ufjf.ui.screens.Home;
import br.ufjf.ui.screens.Login;

public class Manager {

    Window window;
    Map<String, Screen> screens;

    public Manager() {
        this.screens = screens;
        this.window = new Window("App", this);
    }

    public void createScreens(Map<String, Screen> screens) {

        for(String key : screens.keySet()) {
            this.window.addScreen(key, screens.get(key));
        }
    }

    public void navigateTo(String screenName) {

        System.out.println(screenName);

        this.window.showPanel(screenName);
    }

    public void start() {
        this.window.start();
    }

}
