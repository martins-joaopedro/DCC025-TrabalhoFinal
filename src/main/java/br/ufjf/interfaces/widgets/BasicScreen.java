package br.ufjf.interfaces.widgets;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import br.ufjf.interfaces.AplicationWindow;

public class BasicScreen extends JPanel {

    private JPanel centerPanel; // Painel central para centralizar os componentes
    private JButton back = new JButton(); // Botão de voltar
    private Component emptyArea = Box.createRigidArea(new Dimension(50, 50));

    public BasicScreen(String backScreen) {
        setLayout(new BorderLayout());  // Define o layout como BorderLayout
        setBackground(Style.getBackgroundColor()); // Define a cor de fundo

        // Painel central com GridBagLayout para centralizar os componentes e ocupar o espaço restante
        this.centerPanel = new JPanel(new GridBagLayout());
        this.centerPanel.setBackground(Style.getBackgroundColor());

        if (backScreen != null) {
            this.back.addActionListener(e -> AplicationWindow.showScreen(backScreen)); // Adiciona a ação de voltar
        } else {
            this.back.setVisible(false); // Esconde o botão de voltar se não houver tela anterior
            this.emptyArea.setVisible(false);
        }

        // Adiciona o painel central ao centro da tela (com BorderLayout.CENTER)
        add(centerPanel, BorderLayout.CENTER);
    }

    public void addTitle(JLabel titleLabel) {
        addTitle(titleLabel, true);
    }

    public void addTitle(JLabel titleLabel, boolean isIconVisible) {
        JPanel titlePanel = new JPanel(new BorderLayout(10,10));
        titlePanel.setBackground(Style.getBackgroundColor()); // Define a cor de fundo
        titlePanel.setBorder(new EmptyBorder(20, 10, 10, 10)); // Margem ao redor do título

        back.setIcon(Style.getBackIcon()); // Define o ícone do botão de voltar
        back.setBackground(Style.getBackgroundColor()); // Define a cor de fundo do botão
        back.setBorderPainted(false); // Remove a borda do botão

        titlePanel.add(back, BorderLayout.WEST); // Adiciona o botão de voltar ao painel de título

        titleLabel.setFont(Style.getTitleFont()); // Define a fonte do título

        if (isIconVisible)
            titleLabel.setIcon(Style.getLogo()); // Adiciona o ícone do título

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto
        titlePanel.add(titleLabel, BorderLayout.CENTER); // Adiciona o título ao painel

        titlePanel.add(emptyArea, BorderLayout.EAST); // Adiciona um espaço horizontal

        // Adiciona o painel de título ao topo da tela com o layout BorderLayout
        add(titlePanel, BorderLayout.NORTH);
    }

    // Adiciona botões na base da tela
    public void addButtons(JComponent... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0)); // Cria um painel com FlowLayout
        buttonPanel.setBackground(Style.getBackgroundColor()); // Define a cor de fundo
        buttonPanel.setBorder(new EmptyBorder(0, 0, 20, 0)); // Adiciona margem

        for (JComponent button : buttons) { // Adiciona cada botão ao painel
            button.setFont(Style.getMainFont());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.SOUTH); // Adiciona o painel de botões na base da tela
    }

    public void addComponent(JComponent component, int gridx, int gridy) {
        addComponent(component, gridx, gridy, true);
    }

    // Adiciona um componente centralizado no painel central
    public void addComponent(JComponent component, int gridx, int gridy, boolean isInCenter) {

        component.setFont(Style.getMainFont()); // Define a fonte do componente

        // Define as constraints para centralizar o componente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche horizontalmente

        if(isInCenter)
            gbc.anchor = GridBagConstraints.CENTER; // Centraliza o componente
        else {
            //centerPanel.setAlignmentY(TOP_ALIGNMENT);
            gbc.anchor = GridBagConstraints.NORTHWEST; // Alinha à esquerda
            gbc.weightx = 1; // Ocupa o espaço restante
        }

        gbc.insets = new Insets(10, 10, 10, 10);  // Margens ao redor do componente
        gbc.gridx = gridx;
        gbc.gridy = gridy;

        centerPanel.add(component, gbc);  // Adiciona o componente ao painel central
    }
}
