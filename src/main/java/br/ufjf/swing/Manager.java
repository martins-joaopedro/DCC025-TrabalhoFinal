package br.ufjf.swing;

import br.ufjf.swing.components.Button;

import br.ufjf.swing.screens.Home;
import br.ufjf.swing.screens.Login;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.swing.screens.*;

public class Manager {

    Window window;
    List<Screen> screens;

    public Manager() {
        this.screens = new ArrayList<>();
        this.window = new Window("App", this);

        addScreens();
    }

    //TODO: Rever onde vai ficar a instancia das telas e onde adicionamos elas
    public void addScreens() {
        Button navToHome = new Button("Home", "home", this);
        Button navToLogin = new Button("Login", "login", this);

        Screen login = new Login("login", navToHome);
        Screen home = new Home("home", navToLogin);

        this.window.addScreen("home", home);
        this.window.addScreen("login", login);
    }

    public void navigateTo(String screenName) {
        this.window.showPanel(screenName);
    }

    public void start() {
        this.window.start();
    }

}
