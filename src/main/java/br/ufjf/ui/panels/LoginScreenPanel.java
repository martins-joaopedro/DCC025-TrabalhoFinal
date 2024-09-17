package br.ufjf.ui.panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import br.ufjf.models.Usuario;
import br.ufjf.services.LoginService;
import br.ufjf.ui.Window;

public class LoginScreenPanel extends JPanel {

    LoginService service = new LoginService();

    public LoginScreenPanel()  {

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

                //handleAuthentication(nameValue, passwordValue);
                signIn(nameValue, passwordValue);
            }
        );

        JButton delete = new JButton("deletar");
        delete.addActionListener(e -> service.clearAll());

        add(submit);
        add(delete);

        loadAllUsers();
    }

    public void handleAuthentication(String name, String password) {
        if(name == password && name == "adm")
            Window.getManager().navigateTo("configuracao");
        else Window.getManager().navigateTo("acervo");
    }

    //TODO: adiconar validações importante aqui
    public void signIn(String name, String password) {
        service.create(new Usuario(name, password));
    }

    public void loadAllUsers() {
        System.out.println(service.findAll());
    }

}
