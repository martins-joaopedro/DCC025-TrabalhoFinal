package br.ufjf.ui.panels;

import javax.swing.*;
import java.awt.*;

import br.ufjf.models.User;
import br.ufjf.ui.Manager;

public class RegisterScreenPanel extends LoginScreenPanel {

    public RegisterScreenPanel()  {
        super();
    }

    @Override
    protected JPanel createFormPanel() {
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints formGbc = new GridBagConstraints();
        formGbc.insets = new Insets(10, 10, 10, 10);
        formGbc.anchor = GridBagConstraints.CENTER;
        formGbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Digite aqui seu usuário:");
        formGbc.gridx = 0;
        formGbc.gridy = 0;
        formPanel.add(nameLabel, formGbc);

        JTextField nameField = new JTextField(20);
        this.setFieldSize(nameField);
        formGbc.gridx = 1;
        formPanel.add(nameField, formGbc);

        JLabel passwordLabel = new JLabel("Digite aqui sua senha:");
        formGbc.gridx = 0;
        formGbc.gridy = 1;
        formPanel.add(passwordLabel, formGbc);

        JPasswordField passwordField = new JPasswordField(20);
        this.setFieldSize(passwordField);
        formGbc.gridx = 1;
        formPanel.add(passwordField, formGbc);

        JButton submitButton = new JButton("Registrar");
        this.setFieldSize(submitButton);
        submitButton.addActionListener(e -> {
            String nameValue = nameField.getText();
            char[] pass = passwordField.getPassword();
            String passwordValue = new String(pass);

            System.out.println(nameValue);

            signIn(nameValue, passwordValue);

            nameField.setText("");
            passwordField.setText("");
        });
        
        formGbc.gridx = 0;
        formGbc.gridy = 2;
        formGbc.gridwidth = 2;
        formPanel.add(submitButton, formGbc);

        return formPanel;
    }

    @Override
    public void signIn(String name, String password) {
        try {
            if (this.getService().findById(name) != null) {
                JOptionPane.showMessageDialog(null, "Esse Usuário já existe. Insira outro", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (name.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insira um usuário e uma senha válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                this.getService().create(new User(name, password));
                Manager.navigateTo("acervo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao registrar o usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}