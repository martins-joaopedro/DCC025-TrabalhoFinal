package br.ufjf.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

import br.ufjf.ui.Window;
import br.ufjf.ui.components.Button;

import java.awt.*;

public class Screen extends JPanel {

    private int OFFSET = 100;
    JLabel title;
    //JTextField title;
    JPanel mainPanel;

    Screen(String screenName, Button navigator, JPanel panel) {
        this.mainPanel = new JPanel(new BorderLayout());

        mainPanel.setPreferredSize(new Dimension(Window.WIDTH - OFFSET, Window.HEIGHT - OFFSET));
    
        // Cria o título
        JLabel title = new JLabel(screenName, SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 24)); // Define uma fonte maior

        // Cria o painel de cabeçalho
        JPanel header = new JPanel(new BorderLayout(2, 1));
        header.setPreferredSize(new Dimension(Window.WIDTH, 50));

        System.out.println(screenName);

        if(screenName != "BOOKSELF") {
            JPanel buttonArea = new JPanel(new BorderLayout(3, 1));
            buttonArea.add(navigator, BorderLayout.WEST);
            header.add(buttonArea, BorderLayout.NORTH);
            header.add(title, BorderLayout.SOUTH);
        }
        
        mainPanel.add(header, BorderLayout.NORTH);   
        
        mainPanel.add(panel, BorderLayout.CENTER);

        add(mainPanel);
    }
}
