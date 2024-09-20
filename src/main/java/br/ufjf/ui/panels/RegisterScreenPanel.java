package br.ufjf.ui.panels;

import javax.swing.*;

import br.ufjf.models.User;
import br.ufjf.services.LoginService;
import br.ufjf.ui.Manager;

public class RegisterScreenPanel extends JPanel {

    LoginService service = new LoginService();

    public RegisterScreenPanel()  {

        JLabel name = new JLabel("Digite aqui seu nome:");
        name.setBounds(10, 20, 80, 25); // posição x, y e tamanho (largura, altura)
        add(name);
        
        JTextField nameField = new JTextField(20);  
        nameField.setPreferredSize(getPreferredSize());   
        nameField.setBounds(10, 20, 80, 25);
        add(nameField);

        JLabel password = new JLabel("Digite aqui sua senha:");
        password.setBounds(10, 20, 80, 25); // posição x, y e tamanho (largura, altura)
        add(password);

        JPasswordField passwordField = new JPasswordField(20);  
        passwordField.setPreferredSize(getPreferredSize());
        passwordField.setBounds(10, 20, 80, 25);
        add(passwordField);


        JButton submit = new JButton();
            submit.setText("Registrar");
            submit.addActionListener(e -> {

                String nameValue = nameField.getText();
                char[] pass = passwordField.getPassword();
                String passwordValue = new String(pass);
           
                System.out.println(nameValue);
                System.out.println(passwordValue);
                
                signIn(nameValue, passwordValue);
            }
        );

        JButton delete = new JButton("Deletar Usuário");
        delete.addActionListener(e -> service.clearAll());

        add(submit);
        add(delete);

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
        if (service.findById(name) != null) {
            JOptionPane.showMessageDialog(null, "Esse Usuário já existe. Insira outro", "Erro", JOptionPane.ERROR_MESSAGE);
            //return; //para parar a execução se o usuário já existir
        }
        else {
            service.create(new User(name, password));
            Manager.navigateTo("acervo");
             
        }
    }

    public void loadAllUsers() {
        System.out.println(service.findAll());
    }

}