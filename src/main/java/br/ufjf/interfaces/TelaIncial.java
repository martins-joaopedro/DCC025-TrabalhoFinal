package br.ufjf.interfaces;

import java.awt.Dimension;

import javax.swing.*;

import br.ufjf.interfaces.widgets.TelaBase;

public class TelaIncial extends TelaBase {

    private final JLabel titulo = new JLabel("Bookself");

    private JLabel citacao = new JLabel("<html><p style='text-align:center;'>"
                                    + "Eu vivi mil vidas e amei mil amores. "
                                    + "Andei por mundos distantes e vi o fim "
                                    + "dos tempos. Porque eu li. "
                                    + "</p><p></p><p style='text-align:left;'>"
                                    + "- George R. R. Martin"
                                    + "</p></html>");

    // private JLabel citacao = new JLabel("A leitura é uma fonte inesgotável de
    // prazer mas por incrível que pareça, a quase totalidade, não sente esta
    // sede.");

    private final JButton login = new JButton("Entrar");
    private final JButton signin = new JButton("Cadastrar");

    public TelaIncial() {

        login.addActionListener(e -> AplicationWindow.showScreen("login"));
        signin.addActionListener(e -> AplicationWindow.showScreen("signin"));

        addTitle(titulo);

        citacao.setPreferredSize(new Dimension(300, 300)); // Define o tamanho preferido
        citacao.setMinimumSize(new Dimension(300, 300)); // Define o tamanho mínimo        
        addComponent(citacao, 0, 0);

        addButtons(signin, login);
    }
}
