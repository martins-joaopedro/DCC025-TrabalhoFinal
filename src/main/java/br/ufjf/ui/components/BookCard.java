package br.ufjf.ui.components;

import javax.swing.*;
import java.awt.*;  

import br.ufjf.models.Book;

public class BookCard extends JPanel {

    public BookCard(Book book) {
        
        setPreferredSize(new Dimension(Window.WIDTH/3, 45));
        setLayout(new GridLayout(5, 1, 15, 15));
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createTitledBorder(book.getName()));

        add(new JLabel(book.getAuthor()));
        add(new JLabel(book.getSynopsis()));

    }    
}