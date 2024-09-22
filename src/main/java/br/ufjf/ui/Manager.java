package br.ufjf.ui;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Manager {

    public static Window window;
    Map<String, Screen> screens;
    public static Stack<String> history;

    public Manager() {
        this.screens = new HashMap<>();
        window = new Window("Bookself");
        history = new Stack<String>();
        history.push("home");
    }

    public void createScreens(Map<String, Screen> screens) {

        for(String key : screens.keySet()) {
            window.addScreen(key, screens.get(key));
        }
    }

    public static void navigateTo(String screenName) {

        history.push(screenName);
        window.showPanel(screenName);
    }

    public static void navigateBack() {
        if(!history.empty()) {
            history.pop();
            window.showPanel(history.lastElement());
        }
    }

    public void start() {
        window.start();
    }

}
