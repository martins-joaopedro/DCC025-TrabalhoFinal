package br.ufjf.interfaces.widgets;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;

public class TelaBase extends JPanel {

    private JPanel centerPanel; // Painel central para centralizar os componentes

    public TelaBase() {
        setLayout(new BorderLayout());  // Define o layout como BorderLayout
        setBackground(Style.getBackgroundColor()); // Define a cor de fundo

        // Cria um painel central com GridBagLayout para centralizar os componentes
        this.centerPanel = new JPanel(new GridBagLayout()); 
        this.centerPanel.setBackground(Style.getBackgroundColor());

        // Adiciona o painel central ao centro da tela (com BorderLayout.CENTER)
        add(centerPanel, BorderLayout.CENTER);
    }

    // Adiciona um título ao topo da tela
    public void addTitle(JLabel titleLabel) {
        JPanel titlePanel = new JPanel(new GridBagLayout()); // Cria um painel para o título
        titlePanel.setBackground(Style.getBackgroundColor()); // Define a cor de fundo
        titlePanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // Adiciona margem

        titleLabel.setFont(Style.getTitleFont()); // Define a fonte do título

        // Define as constraints para a imagem
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;  // Não preencher, para manter o tamanho natural do componente
        gbc.anchor = GridBagConstraints.CENTER;  // Centraliza o componente no grid
        gbc.insets = new Insets(10, 5, 10, 5);  // Margens ao redor do componente

        gbc.gridx = 0;  // Posição da imagem
        gbc.gridy = 0; 
        titlePanel.add(new JLabel(Style.getLogo()), gbc); // Adiciona a imagem ao painel
        
        gbc.gridx = 1;  // Posição do título
        titleLabel.setMinimumSize(new Dimension(titleLabel.getPreferredSize().width + 10, titleLabel.getPreferredSize().height)); // Define o tamanho mínimo
        titleLabel.setPreferredSize(new Dimension(titleLabel.getPreferredSize().width + 10, titleLabel.getPreferredSize().height)); // Define o tamanho preferido

        titlePanel.add(titleLabel, gbc); // Adiciona o título ao painel

        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o painel
        add(titlePanel, BorderLayout.NORTH); // Adiciona o painel ao topo da tela
    }


    // Adiciona botões na base da tela
    public void addButtons(JComponent... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0)); // Cria um painel com FlowLayout
        
        buttonPanel.setBackground(Style.getBackgroundColor()); // Define a cor de fundo
        buttonPanel.setBorder(new EmptyBorder(0, 0, 20, 0)); // Adiciona margem

        for (JComponent button : buttons) { // Adiciona cada botão ao painel
            button.setFont(Style.getMainFont()); // Define a fonte do botão
            button.setBackground(Style.getButtonColor()); // Define a cor de fundo do botão
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.SOUTH); // Adiciona o painel à base da tela
    }

    // Adiciona um componente centralizado no painel central
    public void addComponent(JComponent component, int gridx, int gridy) {

        component.setFont(Style.getMainFont()); // Define a fonte do componente

        // Define as constraints para centralizar o componente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Não preencher, para manter o tamanho natural do componente
        gbc.anchor = GridBagConstraints.CENTER;  // Centraliza o componente no grid
        gbc.insets = new Insets(10, 10, 10, 10);  // Margens ao redor do componente

        gbc.gridx = gridx;
        gbc.gridy = gridy;

        centerPanel.add(component, gbc);  // Adiciona o componente ao painel central
    }
}
