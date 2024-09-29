package br.ufjf.interfaces.screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.ScrollPanel;
import br.ufjf.interfaces.widgets.Style;

public class BasicScreen extends ScrollPanel {

    public JPanel mainPanel;
    public JPanel centerPanel;
    private JButton back = new JButton();
    private Component emptyArea = Box.createRigidArea(new Dimension(50, 50));
    
    private Color backgroundColor; // Cor de fundo da tela
    
    public BasicScreen(String backScreen) {
        this(backScreen, Style.getBackgroundColor());
    }

    public BasicScreen(String backScreen, Color backgroundColor) {
      
        mainPanel = new JPanel(new BorderLayout());

        this.backgroundColor = backgroundColor;
        mainPanel.setBackground(this.backgroundColor);

        setViewportView(mainPanel);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        getHorizontalScrollBar().setUnitIncrement(20);
        getVerticalScrollBar().setUnitIncrement(20);

        // Painel central com GridBagLayout para centralizar os componentes e ocupar o espaço restante
        this.centerPanel = new JPanel(new GridBagLayout());
        this.centerPanel.setOpaque(false);

        if(backScreen == "homeUser") {
            String backPage = AplicationWindow.getUser() == "admin" ? "adm" : "personalLibrary";
            this.back.addActionListener(e -> AplicationWindow.showScreen(backPage));
        } else if (backScreen != null) {
            this.back.addActionListener(e -> AplicationWindow.showScreen(backScreen)); // Adiciona a ação de voltar
        } else {
            this.back.setVisible(false);
            this.emptyArea.setVisible(false);
        }
        mainPanel.add(centerPanel, BorderLayout.CENTER);
    }

    public void addTitle(JLabel titleLabel) {
        addTitle(titleLabel, true);
    }

    public void addTitle(JLabel titleLabel, boolean isIconVisible) {
        JPanel titlePanel = new JPanel(new BorderLayout(10, 10));
        titlePanel.setBackground(Style.getBackgroundColor());
        titlePanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        titlePanel.add(back, BorderLayout.WEST);
            titleLabel.setFont(Style.getTitleFont());
            titleLabel.setForeground(Style.getPrimaryColor());
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.add(emptyArea, BorderLayout.EAST);

        back.setIcon(Style.getBackIcon());
        back.setBackground(Style.getBackgroundColor());
        back.setBorderPainted(false);
        if (isIconVisible)
            titleLabel.setIcon(Style.getLogo());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
    }

    public void addButtons(JComponent... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        buttonPanel.setBackground(Style.getBackgroundColor());
        buttonPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        for (JComponent button : buttons) {
            button.setFont(Style.getMainFont());
            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addTopButtons(int gridx, int gridy, JComponent... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        buttonPanel.setBackground(this.backgroundColor);
        buttonPanel.setBorder(new EmptyBorder(5, 0, 5, 0));

        for (JComponent button : buttons) {
            button.setFont(Style.getMainFont());
            buttonPanel.add(button);
        }

        addComponent(buttonPanel, gridx, gridy);
    }

    public void addComponent(JComponent component, int gridx, int gridy) {
        addComponent(component, gridx, gridy, true, 20, Style.getMainFont());
    }
    
    public void addComponent(JComponent component, int gridx, int gridy, Font font) {
        addComponent(component, gridx, gridy, true, 20, font);
    }
    
    public void addComponent(JComponent component, int gridx, int gridy, boolean isInCenter) {
        addComponent(component, gridx, gridy, isInCenter, 20, Style.getMainFont());
    }
    
    public void addComponent(JComponent component, int gridx, int gridy, boolean isInCenter, int margem) {
        addComponent(component, gridx, gridy, isInCenter, margem, Style.getMainFont());
    }

    public void addComponent(JComponent component, int gridx, int gridy, boolean isInCenter, int margem, Font font) {
        component.setFont(font);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        if(isInCenter)
            gbc.anchor = GridBagConstraints.CENTER;
        else {
            gbc.anchor = GridBagConstraints.NORTHWEST;
            if(margem >= 20) 
                gbc.weightx = 1;
        }

        gbc.insets = new Insets(5, margem, 5, margem);
        gbc.gridx = gridx;
        gbc.gridy = gridy;

        centerPanel.add(component, gbc);
    }    
}
