package br.ufjf.interfaces.screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

    protected JPanel mainPanel; // Painel principal para o BorderLayout
    protected JPanel centerPanel; // Painel central para centralizar os componentes
    
    private JButton back = new JButton(); // Botão de voltar
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
        this.centerPanel.setOpaque(false); // Define o fundo como transparente

        if (backScreen != null) {
            this.back.addActionListener(e -> AplicationWindow.showScreen(backScreen)); // Adiciona a ação de voltar
        } else {
            this.back.setVisible(false); // Esconde o botão de voltar se não houver tela anterior
            this.emptyArea.setVisible(false);
        }

        // Adiciona o painel central ao centro da tela (com BorderLayout.CENTER)
        mainPanel.add(centerPanel, BorderLayout.CENTER);
    }

    public void addTitle(JLabel titleLabel) {
        addTitle(titleLabel, true);
    }

    public void addTitle(JLabel titleLabel, boolean isIconVisible) {
        JPanel titlePanel = new JPanel(new BorderLayout(10, 10));
        titlePanel.setBackground(this.backgroundColor); // Define a cor de fundo
        titlePanel.setBorder(new EmptyBorder(20, 10, 10, 10)); // Margem ao redor do título

        back.setIcon(Style.getBackIcon()); // Define o ícone do botão de voltar
        back.setBackground(this.backgroundColor); // Define a cor de fundo do botão
        back.setBorderPainted(false); // Remove a borda do botão

        titlePanel.add(back, BorderLayout.WEST); // Adiciona o botão de voltar ao painel de título

        titleLabel.setFont(Style.getTitleFont()); // Define a fonte do título
        titleLabel.setForeground(Style.getPrimaryColor()); // Define a cor do título

        if (isIconVisible)
            titleLabel.setIcon(Style.getLogo()); // Adiciona o ícone do título

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto
        titlePanel.add(titleLabel, BorderLayout.CENTER); // Adiciona o título ao painel

        titlePanel.add(emptyArea, BorderLayout.EAST); // Adiciona um espaço horizontal

        // Adiciona o painel de título ao topo da tela com o layout BorderLayout
        mainPanel.add(titlePanel, BorderLayout.NORTH);
    }

    // Adiciona botões na base da tela
    public void addButtons(JComponent... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20)); // Cria um painel com FlowLayout
        buttonPanel.setBackground(this.backgroundColor); // Define a cor de fundo
        buttonPanel.setBorder(new EmptyBorder(0, 0, 20, 0)); // Adiciona margem

        for (JComponent button : buttons) { // Adiciona cada botão ao painel
            button.setFont(Style.getMainFont());
            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Adiciona o painel de botões na base da tela
    }

    public void addTopButtons(int gridx, int gridy, JComponent... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20)); // Cria um painel com FlowLayout
        buttonPanel.setBackground(this.backgroundColor); // Define a cor de fundo
        buttonPanel.setBorder(new EmptyBorder(5, 0, 5, 0)); // Adiciona margem

        for (JComponent button : buttons) { // Adiciona cada botão ao painel
            button.setFont(Style.getMainFont());
            buttonPanel.add(button);
        }

        addComponent(buttonPanel, gridx, gridy); // Adiciona o painel de botões na base da tela
    }

    public void addComponent(JComponent component, int gridx, int gridy) {
        addComponent(component, gridx, gridy, true, 20);
    }

    public void addComponent(JComponent component, int gridx, int gridy, boolean isInCenter) {
        addComponent(component, gridx, gridy, isInCenter, 20);
    }

    public void addComponent(JComponent component, int gridx, int gridy, boolean isInCenter, int margem) {
        component.setFont(Style.getMainFont());

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
