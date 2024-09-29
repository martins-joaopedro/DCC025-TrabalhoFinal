package br.ufjf.interfaces.components.lists;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.ScrollPaneConstants;

import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.widgets.ScrollPanel;
;

public class ComponentList extends ScrollPanel {

    List<JComponent> components;
    boolean isHorizontal;
    
    public ComponentList(List<JComponent> components, boolean isHorizontal) {
        
        this.components = components;
        this.isHorizontal = isHorizontal;

        setPreferredSize(new Dimension(150, 350));
        setMinimumSize(new Dimension(150, 350));
        setBackground(Color.WHITE);

        if(isHorizontal) {
            setViewportView(drawHorizontalList());
        } else {
            setViewportView(drawVerticalList());
        }
    }

    public ComponentList(List<JComponent> components, boolean isHorizontal, int width, int height ) {

        this.components = components;
        this.isHorizontal = isHorizontal;

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
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
        getHorizontalScrollBar().setUnitIncrement(16);

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
        getVerticalScrollBar().setUnitIncrement(16);

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