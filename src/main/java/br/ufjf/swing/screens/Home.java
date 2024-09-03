package br.ufjf.swing.screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import br.ufjf.swing.Window;



public class Home extends JPanel {

    public Home() {
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
