package br.ufjf.ui;

import java.util.Map;

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
