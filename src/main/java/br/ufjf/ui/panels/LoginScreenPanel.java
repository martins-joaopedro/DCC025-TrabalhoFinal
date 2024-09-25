package br.ufjf.ui.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout; 
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.ufjf.services.LoginService;
import br.ufjf.ui.Manager;

public class LoginScreenPanel extends JPanel {

    LoginService service = new LoginService();

    public LoginScreenPanel()  {

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
        formGbc.gridx = 1;
        formPanel.add(nameField, formGbc);
        
        JLabel password = new JLabel("Digite aqui sua senha:");
        formGbc.gridx = 0;
        formGbc.gridy = 1;
        formPanel.add(password, formGbc);
        
        JPasswordField passwordField = new JPasswordField(20);
        formGbc.gridx = 1;
        formPanel.add(passwordField, formGbc);
        
        JButton submit = new JButton("Logar");
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
        if(name == password && name == "adm") {
            Manager.navigateTo("configuracao");
        } else {
            Manager.navigateTo("acervo");
        }
    }

    public void signIn(String name, String password) {
        if (service.findById(name) == null) {
            JOptionPane.showMessageDialog(null, "Esse Usuário não existe. Cadastre-se!", "Erro", JOptionPane.ERROR_MESSAGE);
            //return; //para parar a execução se o usuário já existir
        }
        else {
            //conferir se a senha bate com o usuario 
            System.out.println(password);
            System.out.println(service.findById(name).getPassword());

            if (service.findById(name).getPassword().equals(password)) {
                Manager.navigateTo("biblioteca");
            }
            else {
                JOptionPane.showMessageDialog(null, "Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void loadAllUsers() {
        System.out.println(service.findAll());
    }

}