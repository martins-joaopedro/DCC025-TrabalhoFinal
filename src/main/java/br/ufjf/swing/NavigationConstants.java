package br.ufjf.swing;

import java.util.HashMap;
import java.util.Map;

import br.ufjf.swing.components.Button;
import br.ufjf.swing.screens.Collection;
import br.ufjf.swing.screens.Configuracao;
import br.ufjf.swing.screens.Home;
import br.ufjf.swing.screens.Login;

public class NavigationConstants {

    public static Button navToHome = new Button("Home", "home", Window.getManager());
    public static Button navToLogin = new Button("Login", "login", Window.getManager());
    public static Button navToAcervo = new Button("Acervo", "acervo", Window.getManager());

    public static Screen Configuracao = new Screen("configuracao", navToHome, new Configuracao());
    public static Screen Home = new Screen("home", navToLogin, new Home());
    public static Screen Login = new Screen("login", navToAcervo, new Login());
    public static Screen Acervo = new Screen("acervo", navToHome, new Collection());
    
}

