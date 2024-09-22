package br.ufjf.ui;

import br.ufjf.ui.components.Button;
import br.ufjf.ui.panels.HomeScreenPanel;
import br.ufjf.ui.panels.LibraryScreenPanel;
import br.ufjf.ui.panels.LoginScreenPanel;
import br.ufjf.ui.panels.PersonalLibraryScreenPanel;
import br.ufjf.ui.panels.RegisterScreenPanel;
import br.ufjf.ui.panels.TesteScreenPanel;

public class NavigationConstants {

    //public static Screen Configuracao = new Screen("configuracao", navToHome, new ConfigurationScreenPanel());
    public static Screen Home = new Screen("BOOKSELF", new HomeScreenPanel());
    public static Screen PersonalLibrary = new Screen("ACERVO PESSOAL", new Button("Voltar"), new PersonalLibraryScreenPanel());
    public static Screen Login = new Screen("LOGIN", new Button("Voltar"), new LoginScreenPanel());
    public static Screen Register = new Screen("REGISTRAR", new Button("Voltar"), new RegisterScreenPanel());
    public static Screen Library = new Screen("BIBLIOTECA", new Button("Voltar"), new LibraryScreenPanel());
    public static Screen Teste = new Screen("TESTE", new Button("Voltar"), new TesteScreenPanel());
    
}

