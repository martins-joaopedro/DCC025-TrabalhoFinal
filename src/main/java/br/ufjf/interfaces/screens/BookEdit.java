package br.ufjf.interfaces.screens;

import javax.swing.JLabel;

public class BookEdit extends BasicScreen {
    public BookEdit() {
        super("personalLibrary");

        addTitle(new JLabel("Editar Livro"), false);
    }
    
}
