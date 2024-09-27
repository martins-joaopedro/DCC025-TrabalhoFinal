package br.ufjf.interfaces.screens;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.PasswordField;
import br.ufjf.interfaces.widgets.TextField;
import br.ufjf.services.LoginService;

public class Login extends BasicScreen {

    LoginService service = new LoginService();
    
    private final JLabel title = new JLabel("Entrar");

    private JLabel userText = new JLabel("Digite seu usuário:");
    private JTextField userField = new TextField(15);

    private JLabel passwordText = new JLabel("Digite sua senha:");
    private JTextField passwordField = new PasswordField(15);

    private JButton login = new Button("Entrar");

    public Login() {
        super("home");

        login.addActionListener(e -> this.startLogin(userField.getText(), passwordField.getText()));

        addTitle(this.title);
        
        addComponent(userText, 0, 0);
        addComponent(passwordText, 0, 1);

        userField.setPreferredSize(new Dimension(100, 24)); // Define o tamanho preferido
        userField.setMinimumSize(new Dimension(100, 24)); // Define o tamanho mínimo

        passwordField.setPreferredSize(new Dimension(100, 24)); // Define o tamanho preferido
        passwordField.setMinimumSize(new Dimension(100, 24)); // Define o tamanho mínimo

        addComponent(userField, 1, 0);
        addComponent(passwordField, 1, 1);

        addButtons(login);
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
                if(user.equals("admin")) {
                    AplicationWindow.showScreen("admin", service.findById(user));
                    return;
                }

                AplicationWindow.showScreen("personalLibrary", service.findById(user));
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
