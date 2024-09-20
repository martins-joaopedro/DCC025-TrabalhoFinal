package br.ufjf.ui.panels;

import java.awt.GridLayout;

import javax.swing.*;
import java.awt.*; 

import br.ufjf.models.User;
import br.ufjf.services.LoginService;
import br.ufjf.ui.Window;
import br.ufjf.ui.Manager;

public class LoginScreenPanel extends JPanel {

    LoginService service = new LoginService();

    public LoginScreenPanel()  {

        //setLayout(new GridLayout(5, 1));
        //setLayout(new BorderLayout());

        JLabel name = new JLabel("Digite aqui seu nome:");
        name.setBounds(10, 20, 80, 25); // posição x, y e tamanho (largura, altura)
        //name.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(name);
        
        JTextField nameField = new JTextField(20);  
        nameField.setPreferredSize(getPreferredSize());   
        nameField.setBounds(10, 20, 80, 25);
        //nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(nameField);


        JLabel password = new JLabel("Digite aqui sua senha:");
        password.setBounds(10, 20, 80, 25); // posição x, y e tamanho (largura, altura)
        //password.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(password);

        JPasswordField passwordField = new JPasswordField(20);  
        passwordField.setPreferredSize(getPreferredSize());
        passwordField.setBounds(10, 20, 80, 25);
        //passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(passwordField);
        

        JButton submit = new JButton();
            submit.setText("Logar");
            submit.addActionListener(e -> {

                String nameValue = nameField.getText();
                char[] pass = passwordField.getPassword();
                String passwordValue = new String(pass);
           
                System.out.println(nameValue);
                System.out.println(passwordValue);

                //handleAuthentication(nameValue, passwordValue);
                
                signIn(nameValue, passwordValue);
            }
        );
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(submit);        

        loadAllUsers();
    }

    public void handleAuthentication(String name, String password) {
        if(name == password && name == "adm")
            Window.getManager().navigateTo("configuracao");
        else Window.getManager().navigateTo("acervo");
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
                Manager.navigateTo("acervo");
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