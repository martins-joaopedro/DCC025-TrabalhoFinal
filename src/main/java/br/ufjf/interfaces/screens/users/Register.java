package br.ufjf.interfaces.screens.users;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.PasswordField;
import br.ufjf.interfaces.widgets.TextField;
import br.ufjf.models.User;
import br.ufjf.services.LoginService;

public class Register extends BasicScreen {

    LoginService service = new LoginService();
    
    private final JLabel title = new JLabel("Registrar");

    private JLabel userText = new JLabel("Digite seu usuário:");
    private JTextField userField = new TextField(15);

    private JLabel passwordText = new JLabel("Digite sua senha:");
    private JTextField passwordField = new PasswordField(15);

    private JButton register = new Button("Registrar");

    public Register() {
        super("home");

        register.addActionListener(e -> this.startRegister(userField.getText(), passwordField.getText()));

        addTitle(title);
        
        addComponent(userText, 0, 0);
        addComponent(passwordText, 0, 1);

        userField.setPreferredSize(new Dimension(100, 24)); // Define o tamanho preferido
        userField.setMinimumSize(new Dimension(100, 24)); // Define o tamanho mínimo

        passwordField.setPreferredSize(new Dimension(100, 24)); // Define o tamanho preferido
        passwordField.setMinimumSize(new Dimension(100, 24)); // Define o tamanho mínimo

        addComponent(userField, 1, 0);
        addComponent(passwordField, 1, 1);

        addButtons(register);
    }

    private void startRegister(String user, String password) {

        System.out.println(user);
        System.out.println(password);

        if (service.findById(user) != null) {
            JOptionPane.showMessageDialog(null, "Esse Usuário já existe. Insira outro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else if (user.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            service.create(new User(user, password));
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            AplicationWindow.showScreen("PersonalLibrary");
        }
    }

}