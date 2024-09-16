package br.ufjf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.ufjf.persistence.FileManager;
import br.ufjf.ui.Manager;
import br.ufjf.ui.NavigationConstants;
import br.ufjf.ui.Screen;

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

        FileManager f = new FileManager();
        try {
            f.write();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}