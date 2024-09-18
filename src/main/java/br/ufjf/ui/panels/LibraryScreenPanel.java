package br.ufjf.ui.panels;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufjf.models.Book;
import br.ufjf.services.LibraryService;

public class LibraryScreenPanel extends JPanel {

    LibraryService service = new LibraryService();

    public LibraryScreenPanel() {

        add(new JLabel("Acervo"));
        
        loadBooks();
    }

    public void loadBooks() {
        List<Book> books = service.findAll();
        System.out.println(books);
        String[] colunas = {"ISBN", "Nome", "Autor", "Sinopse", "Páginas", "Gênero"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

         for (Book book : books) {
            model.addRow(new Object[]{
                book.getISBN(),
                book.getName(),
                book.getAuthor(),
                book.getSynopsis(),
                book.getPages(),
                book.getGenre()
            });
        }
        JTable table = new JTable(model);
        JScrollPane container = new JScrollPane(table);
        add(container);
    }


}
