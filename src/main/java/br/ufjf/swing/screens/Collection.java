package br.ufjf.swing.screens;

import java.awt.Dimension;

import javax.swing.*;

import br.ufjf.swing.Window;

public class Collection extends JPanel {

    public Collection() {

        add(new JLabel("Acervo"));
        JPanel container1 = new JPanel();
        String[] lista = new String[100];


        for(int i=0; i<100; i++)
            lista[i] = i+" ";

        JList<String> list = new JList<>(lista);

        JScrollPane container = new JScrollPane(list);
        container.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        container.setPreferredSize(new Dimension(300, Window.HEIGHT));

       add(container);
    }
}
