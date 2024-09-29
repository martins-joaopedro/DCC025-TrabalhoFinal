package br.ufjf.interfaces.screens.libraries;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.components.cards.AdmBookCard;
import br.ufjf.interfaces.components.lists.ComponentList;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Adm extends Library {

    private final Button newBook = new Button("Adicionar novo livro");

    public Adm() {
        super(1);

        addTitle(new JLabel("Administrador"));

        newBook.addActionListener(e -> AplicationWindow.showBookScreen("newBook", null));
        addComponent(newBook, 0, 0, false);
    }

    @Override
    protected ComponentList bookList(Genre genre) {
        List<JComponent> components = new ArrayList<>();

        List<Book> books = this.service.getBooksByGenre(genre);

        for (Book book : books) {
            components.add(new AdmBookCard(book));
        }

        return new ComponentList(components, true);
    }

}
