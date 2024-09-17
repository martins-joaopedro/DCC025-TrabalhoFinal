package br.ufjf.ui.screens;

import java.awt.Dimension;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import br.ufjf.models.Livro;
import br.ufjf.services.LibraryService;
import br.ufjf.ui.Window;

public class LibraryScreenPanel extends JPanel {

    LibraryService service = new LibraryService();

    public LibraryScreenPanel() {

        add(new JLabel("Acervo"));
        
        loadBooks();
    }

    public void loadBooks() {
        List<Livro> books = service.loadAllBooks();
        System.out.println(books);
        String[] colunas = {"ISBN", "Nome", "Autor", "Sinopse", "Páginas", "Gênero"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

         for (Livro book : books) {
            model.addRow(new Object[]{
                book.getISBN(),
                book.getNome(),
                book.getAutor(),
                book.getSinopse(),
                book.getPaginas(),
                book.getGenero()
            });
        }
        JTable table = new JTable(model);
        JScrollPane container = new JScrollPane(table);
        add(container);
    }


}
