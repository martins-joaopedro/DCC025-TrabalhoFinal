package br.ufjf.ui.panels;

import javax.swing.JPanel;

import br.ufjf.ui.Manager;

import javax.swing.*;
import java.awt.*;    


public class HomeScreenPanel extends JPanel {

    public HomeScreenPanel() {
        
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel header = new JLabel("BOOKSELF");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Serif", Font.BOLD, 30));
        mainPanel.add(header, BorderLayout.NORTH);

        JLabel title = new JLabel("Seja bem-vindo(a)!");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(header);

        title.setFont(new Font("Serif", Font.PLAIN, 18)); // Adjust font size if needed
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);

        add(mainPanel, BorderLayout.CENTER);
        
        JPanel navigations = new JPanel();
            navigations.setLayout(new GridLayout(1, 2, 30, 0));
            navigations.setPreferredSize(new Dimension(Window.WIDTH, 30));
    
        JButton navLogin = new JButton("Logar");            
            navLogin.addActionListener(e -> Manager.navigateTo("login"));

        JButton navRegister = new JButton("Registrar");
            navRegister.addActionListener(e -> Manager.navigateTo("register"));
            
        navigations.add(navLogin);
        navigations.add(navRegister);

        add(navigations, BorderLayout.SOUTH);
    }
}
