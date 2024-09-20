package br.ufjf.ui;

import br.ufjf.ui.components.Button;
import br.ufjf.ui.panels.*;

public class NavigationConstants {

    //public static Screen Configuracao = new Screen("configuracao", navToHome, new ConfigurationScreenPanel());
    public static Screen Home = new Screen("BOOKSELF", new HomeScreenPanel());
    public static Screen Login = new Screen("LOGIN", new Button("Voltar"), new LoginScreenPanel());
    public static Screen Register = new Screen("REGISTRAR", new Button("Voltar"), new RegisterScreenPanel());
    public static Screen Acervo = new Screen("ACERVO", new Button("Voltar"), new LibraryScreenPanel());
    public static Screen Teste = new Screen("TESTE", new Button("Voltar"), new TesteScreenPanel());
    
}

