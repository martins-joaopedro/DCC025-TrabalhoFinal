package br.ufjf.swing;

import javax.swing.JPanel;
import br.ufjf.swing.Window;
import javax.swing.JTextField;
 
import java.awt.*;
import br.ufjf.swing.components.Button;

public class Screen extends JPanel {

    private int OFFSET = 100;
    JTextField title;
    JPanel mainPanel;

    Screen(String screenName, Button navigator, JPanel panel) {
        this.mainPanel = new JPanel(new BorderLayout());

        mainPanel.setPreferredSize(new Dimension(Window.WIDTH - OFFSET, Window.HEIGHT - OFFSET));
        title = new JTextField(screenName);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(navigator, BorderLayout.SOUTH);
        mainPanel.add(panel, BorderLayout.CENTER);

        add(mainPanel);
    }
}
