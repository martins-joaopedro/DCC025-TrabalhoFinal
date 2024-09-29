package br.ufjf.interfaces.screens.general;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;

public class Home extends BasicScreen {

    private final JLabel title = new JLabel("Bookself");

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

        JLabel image = new JLabel(Style.getHomeLogo());
        addComponent(image, 0, 2, true);
        title.setHorizontalAlignment(JLabel.CENTER);
        addComponent(title, 0, 0, Style.getTitleFont());

        login.addActionListener(e -> AplicationWindow.showScreen("login"));
        signin.addActionListener(e -> AplicationWindow.showScreen("register"));

        citacao.setPreferredSize(new Dimension(300, 300));
        citacao.setMinimumSize(new Dimension(300, 300));
        addComponent(citacao, 0, 4, true);

        addButtons(login, signin);
    }
}
