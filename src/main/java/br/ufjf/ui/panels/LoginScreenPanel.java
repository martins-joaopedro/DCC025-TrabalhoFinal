package br.ufjf.ui.panels;

import javax.swing.*;
import java.awt.*;

import br.ufjf.services.LoginService;
import br.ufjf.ui.Manager;

public class LoginScreenPanel extends JPanel {

    private final LoginService service = new LoginService();

    public LoginScreenPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel formPanel = createFormPanel();
        add(formPanel, gbc);

        loadAllUsers();
    }

    protected LoginService getService() {
        return service;
    }

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
        setFieldSize(nameField);
        formGbc.gridx = 1;
        formPanel.add(nameField, formGbc);

        JLabel passwordLabel = new JLabel("Digite aqui sua senha:");
        formGbc.gridx = 0;
        formGbc.gridy = 1;
        formPanel.add(passwordLabel, formGbc);

        JPasswordField passwordField = new JPasswordField(20);
        setFieldSize(passwordField);
        formGbc.gridx = 1;
        formPanel.add(passwordField, formGbc);

        JButton submitButton = new JButton("Logar");
        setFieldSize(submitButton);
        submitButton.addActionListener(e -> signIn(nameField.getText(), new String(passwordField.getPassword())));
        formGbc.gridx = 0;
        formGbc.gridy = 2;
        formGbc.gridwidth = 2;
        formPanel.add(submitButton, formGbc);

        return formPanel;
    }

    protected void setFieldSize(JComponent component) {
        Dimension size = new Dimension(200, 24);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
    }

    public void handleAuthentication(String name, String password) {
        if(name == password && name == "adm") {
            Manager.navigateTo("configuracao");
        } else {
            Manager.navigateTo("acervo");
        }
    }

    protected void signIn(String name, String password) {
        if (service.findById(name) == null) {
            showMessage("Esse Usuário não existe. Cadastre-se!", "Erro");
        } else if (service.findById(name).getPassword().equals(password)) {
            Manager.navigateTo("acervo");
        } else {
            showMessage("Senha incorreta", "Erro");
        }
    }

    private void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    private void loadAllUsers() {
        System.out.println(service.findAll());
    }
}
