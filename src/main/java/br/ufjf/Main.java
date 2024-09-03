package br.ufjf;

import java.util.HashMap;
import java.util.Map;

import br.ufjf.swing.Manager;
import br.ufjf.swing.NavigationConstants;
import br.ufjf.swing.Screen;
import br.ufjf.swing.screens.Home;

public class Main {

    private static Manager manager;

    public static void main(String[] args) {

        manager = new Manager();

        Map<String, Screen> screens = new HashMap<>();        

        screens.put("home", NavigationConstants.Home);
        screens.put("acervo", NavigationConstants.Acervo);
        screens.put("login", NavigationConstants.Login);
        screens.put("configuracao", NavigationConstants.Configuracao);
    
        manager.createScreens(screens);
        manager.start();
    }
}