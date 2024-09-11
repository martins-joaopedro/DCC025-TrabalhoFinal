package br.ufjf.ui;

import java.util.HashMap;
import java.util.Map;

import br.ufjf.ui.components.Button;
import br.ufjf.ui.screens.Collection;
import br.ufjf.ui.screens.Configuracao;
import br.ufjf.ui.screens.Home;
import br.ufjf.ui.screens.Login;

public class NavigationConstants {

    public static Button navToHome = new Button("Home", "home", Window.getManager());
    public static Button navToLogin = new Button("Login", "login", Window.getManager());
    public static Button navToAcervo = new Button("Acervo", "acervo", Window.getManager());

    public static Screen Configuracao = new Screen("configuracao", navToHome, new Configuracao());
    public static Screen Home = new Screen("home", navToLogin, new Home());
    public static Screen Login = new Screen("login", navToAcervo, new Login());
    public static Screen Acervo = new Screen("acervo", navToHome, new Collection());
    
}

