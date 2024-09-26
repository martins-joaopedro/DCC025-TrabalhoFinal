package br.ufjf.interfaces;

import javax.swing.*;

import br.ufjf.interfaces.widgets.TelaBase;
import br.ufjf.services.LoginService;

import java.awt.*;

public class Login extends TelaBase {

    LoginService service = new LoginService();
    
    private final JLabel title = new JLabel("Entrar");

    private JLabel userText = new JLabel("Digite seu usuário:");
    private JTextField userField = new JTextField(15);

    private JLabel passwordText = new JLabel("Digite sua senha:");
    private JTextField passwordField = new JPasswordField(15);

    private JButton login = new JButton("Entrar");
    private JButton voltar = new JButton("Voltar");

    public Login() {
        login.addActionListener(e -> this.startLogin(userField.getText(), passwordField.getText()));
        voltar.addActionListener(e -> AplicationWindow.showScreen("telaInicial"));

        addTitle(this.title);
        
        addComponent(userText, 0, 0);
        addComponent(passwordText, 0, 1);

        userField.setPreferredSize(new Dimension(100, 24)); // Define o tamanho preferido
        userField.setMinimumSize(new Dimension(100, 24)); // Define o tamanho mínimo

        passwordField.setPreferredSize(new Dimension(100, 24)); // Define o tamanho preferido
        passwordField.setMinimumSize(new Dimension(100, 24)); // Define o tamanho mínimo

        addComponent(userField, 1, 0);
        addComponent(passwordField, 1, 1);

        addButtons(voltar, login);
    }

    private void startLogin(String user, String password) {

        System.out.println(user);
        System.out.println(password);

        if (service.findById(user) == null) {
            JOptionPane.showMessageDialog(null, "Esse Usuário não existe. Cadastre-se!", "Erro", JOptionPane.ERROR_MESSAGE);
            // return; //para parar a execução se o usuário já existir
        } else {
            // conferir se a senha bate com o usuario
            System.out.println(password);
            System.out.println(service.findById(user).getPassword());

            if (service.findById(user).getPassword().equals(password)) {
                AplicationWindow.showScreen("telaInicial");
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
