package br.ufjf.ui.components;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufjf.ui.UIConstants;

// preciso passar que T vai extender da classe JPanel pra linha 19 funcionar
public class ComponentList<T extends JPanel> extends JPanel {

    List<T> components;
    boolean isHorizontal;

    public ComponentList(List<T> components, boolean isHorizontal) {
        
        this.components = components;
        this.isHorizontal = isHorizontal;

        if(isHorizontal) 
            drawHorizontal();            
        else drawVertical();        
    }

    public void drawHorizontal() {

        JPanel listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.X_AXIS));

        for (T component : components) {
            listContainer.add(component);
            listContainer.add(Box.createRigidArea(new Dimension(10, 0)));
        }
        
        JScrollPane scrollPane = new JScrollPane(listContainer);
        //scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        //scrollPane.setPreferredSize(new Dimension(100,150));
        //scrollPane.setMaximumSize(new Dimension(100,150));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        add(listContainer);
    }

    public void drawVertical() {
        JPanel listContainer = new JPanel();
        listContainer.setLayout(new GridLayout(0, 2, 10, 10));

        for (T component : components) 
            listContainer.add(component);
        
        JScrollPane scrollPane = new JScrollPane(listContainer);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(500,100));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane);
    }
}
