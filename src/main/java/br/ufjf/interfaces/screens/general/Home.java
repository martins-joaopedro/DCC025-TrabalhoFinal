package br.ufjf.interfaces.screens.general;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.widgets.Button;

public class Home extends BasicScreen {

    private final JLabel titulo = new JLabel("Bookself");

    private JLabel citacao = new JLabel("<html><p style='text-align:center;'>"
                                    + "Eu vivi mil vidas e amei mil amores. "
                                    + "Andei por mundos distantes e vi o fim "
                                    + "dos tempos. Porque eu li. "
                                    + "</p><p></p><p style='text-align:left;'>"
                                    + "- George R. R. Martin"
                                    + "</p></html>");

    private final JButton login = new Button("Entrar");
    private final JButton signin = new Button("Registrar");

    public Home() {
        super(null);

        addTitle(titulo);

        login.addActionListener(e -> AplicationWindow.showScreen("login"));
        signin.addActionListener(e -> AplicationWindow.showScreen("register"));

        citacao.setPreferredSize(new Dimension(300, 300));
        citacao.setMinimumSize(new Dimension(300, 300));
        addComponent(citacao, 0, 0);

        addButtons(login, signin);
    }
}
