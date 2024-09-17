package br.ufjf.ui;

import br.ufjf.ui.components.Button;
import br.ufjf.ui.panels.ConfigurationScreenPanel;
import br.ufjf.ui.panels.HomeScreenPanel;
import br.ufjf.ui.panels.LibraryScreenPanel;
import br.ufjf.ui.panels.LoginScreenPanel;

public class NavigationConstants {

    public static Button navToHome = new Button("Home", "home", Window.getManager());
    public static Button navToLogin = new Button("Login", "login", Window.getManager());
    public static Button navToAcervo = new Button("Acervo", "acervo", Window.getManager());

    public static Screen Configuracao = new Screen("configuracao", navToHome, new ConfigurationScreenPanel());
    public static Screen Home = new Screen("home", navToLogin, new HomeScreenPanel());
    public static Screen Login = new Screen("login", navToAcervo, new LoginScreenPanel());
    public static Screen Acervo = new Screen("acervo", navToHome, new LibraryScreenPanel());
    
}

