package br.ufjf.interfaces.widgets;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;

import br.ufjf.interfaces.BasicScreen;;

public class ComponentList extends ScrollPanel {

    List<JComponent> components;
    boolean isHorizontal;
    
    public ComponentList(List<JComponent> components, boolean isHorizontal) {
        
        this.components = components;
        this.isHorizontal = isHorizontal;

        setPreferredSize(new Dimension(150, 180));
        setMinimumSize(new Dimension(150, 180));
        setBackground(Color.WHITE);

        if(isHorizontal) {
            setViewportView(drawHorizontalList());
        } else {
            setViewportView(drawVerticalList());
        }
    }

    private BasicScreen drawHorizontalList() {
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        BasicScreen listContainer = new BasicScreen(null, Color.WHITE);
        listContainer.setBackground(Color.WHITE);

        int i = 0;
        for (JComponent component : this.components) {
            listContainer.addComponent(component, i, 0, false, 5);
            i++;
        }

        return listContainer;
    }

    private BasicScreen drawVerticalList() {
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        BasicScreen listContainer = new BasicScreen(null, Color.WHITE);
        listContainer.setBackground(Color.WHITE);

        int i = 0;
        for (JComponent component : this.components) {
            listContainer.addComponent(component, 0, i, false, 5);
            i++;
        }

        return listContainer;
    }
}