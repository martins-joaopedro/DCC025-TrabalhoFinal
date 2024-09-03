package br.ufjf.swing;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.swing.components.Button;
import br.ufjf.swing.screens.Collection;
import br.ufjf.swing.screens.Home;
import br.ufjf.swing.screens.Login;

public class Manager {

    Window window;
    List<Screen> screens;

    public Manager() {
        this.screens = new ArrayList<>();
        this.window = new Window("App", this);

        createScreens();
    }

    //TODO: Rever onde vai ficar a instancia das telas e onde adicionamos elas
    public void createScreens() {
        Button navToHome = new Button("Home", "home", this);
        Button navToLogin = new Button("Acervo", "acervo", this);

        Screen Login = new Screen("login", navToHome, new Login());
        Screen Home = new Screen("home", navToLogin, new Home());
        Screen Acervo = new Screen("acervo", navToHome, new Collection());

        this.window.addScreen("home", Home);
        this.window.addScreen("login", Login);
        this.window.addScreen("acervo", Acervo);
    }

    public void navigateTo(String screenName) {
        this.window.showPanel(screenName);
    }

    public void start() {
        this.window.start();
    }

}
