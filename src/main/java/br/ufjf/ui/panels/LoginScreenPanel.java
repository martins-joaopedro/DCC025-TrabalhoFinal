package br.ufjf.ui.panels;

import javax.swing.*;
import java.awt.*;

import br.ufjf.services.LoginService;
import br.ufjf.ui.Manager;

public class LoginScreenPanel extends JPanel {

    LoginService service = new LoginService();

    public LoginScreenPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints formGbc = new GridBagConstraints();
        formGbc.insets = new Insets(10, 10, 10, 10);
        formGbc.anchor = GridBagConstraints.CENTER;
        formGbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel name = new JLabel("Digite aqui seu usuário:");
        formGbc.gridx = 0;
        formGbc.gridy = 0;
        formPanel.add(name, formGbc);

        JTextField nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(200, 24)); // Define o tamanho preferido
        nameField.setMinimumSize(new Dimension(200, 24)); // Define o tamanho mínimo
        formGbc.gridx = 1;
        formPanel.add(nameField, formGbc);

        JLabel password = new JLabel("Digite aqui sua senha:");
        formGbc.gridx = 0;
        formGbc.gridy = 1;
        formPanel.add(password, formGbc);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(200, 24)); // Define o tamanho preferido
        passwordField.setMinimumSize(new Dimension(200, 24)); // Define o tamanho mínimo
        formGbc.gridx = 1;
        formPanel.add(passwordField, formGbc);

        JButton submit = new JButton("Logar");
        submit.setPreferredSize(new Dimension(200, 24)); // Define o tamanho preferido
        submit.setMinimumSize(new Dimension(200, 24)); // Define o tamanho mínimo
        submit.addActionListener(e -> {
            String nameValue = nameField.getText();
            char[] pass = passwordField.getPassword();
            String passwordValue = new String(pass);

            System.out.println(nameValue);
            System.out.println(passwordValue);

            signIn(nameValue, passwordValue);
        });
        formGbc.gridx = 0;
        formGbc.gridy = 2;
        formGbc.gridwidth = 2;
        formPanel.add(submit, formGbc);

        add(formPanel, gbc);

        loadAllUsers();
    }

    public void handleAuthentication(String name, String password) {
        if(name.equals(password) && name.equals("adm")) {
            Manager.navigateTo("configuracao");
        } else {
            Manager.navigateTo("acervo");
        }
    }

    public void signIn(String name, String password) {
        if (service.findById(name) == null) {
            JOptionPane.showMessageDialog(null, "Esse Usuário não existe. Cadastre-se!", "Erro", JOptionPane.ERROR_MESSAGE);
            // return; //para parar a execução se o usuário já existir
        } else {
            // conferir se a senha bate com o usuario
            System.out.println(password);
            System.out.println(service.findById(name).getPassword());

            if (service.findById(name).getPassword().equals(password)) {
                Manager.navigateTo("acervo");
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void loadAllUsers() {
        System.out.println(service.findAll());
    }
}