package br.ufjf.ui.screens;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import br.ufjf.ui.Window;

public class Login extends JPanel {

    public Login()  {

        JTextPane name = new JTextPane();
        name.setText("Digite aqui seu nome");
        name.setEditable(false);
        add(name);   
        
        JTextField nameField = new JTextField("");  
        nameField.setPreferredSize(getPreferredSize());   
        add(nameField);

        JTextPane password = new JTextPane();
        password.setText("Digite aqui sua senha");
        password.setEditable(false);
        add(password);

        JTextField passwordField = new JTextField("");     
        passwordField.setPreferredSize(getPreferredSize());
        add(passwordField);

        JButton submit = new JButton();
            submit.setText("Logar");
            submit.addActionListener(e -> {

                String nameValue = nameField.getText();
                String passwordValue = passwordField.getText();
                System.out.println(nameValue);
                System.out.println(passwordValue);

                handleAuthentication(nameValue, passwordValue);
            });

        add(submit);
    }

    public void handleAuthentication(String name, String password) {
        if(name == password && name == "adm")
            Window.getManager().navigateTo("configuracao");
        else Window.getManager().navigateTo("acervo");
    }

}
