package br.ufjf.ui.panels;

import java.util.List;

import javax.swing.*;
import java.awt.*;

import br.ufjf.models.Book;
import br.ufjf.services.LibraryService;

import br.ufjf.ui.components.BookCard;

public class LibraryScreenPanel extends JPanel {

    LibraryService service = new LibraryService();

    public LibraryScreenPanel() {

        add(new JLabel("Acervo"));
        
        loadBooks();
    }

    public void loadBooks() {
        List<Book> books = service.findAll();
        
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        container.setPreferredSize(new Dimension(Window.WIDTH, 200)); 

        for (Book book : books) {
           container.add(new BookCard(book));
        }   

        JScrollPane scroll = new JScrollPane(container);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Define o scroll horizontal
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Remove o scroll vertical

        // Define o tamanho preferido para o painel
        // Define a altura e largura da área de visualização

        add(scroll);
       /*  String[] colunas = {"ISBN", "Nome", "Autor", "Sinopse", "Páginas", "Gênero"};
        //DefaultTableModel model = new DefaultTableModel(colunas, 0);

        
        JTable table = new JTable(model);
        
        
        add(container); */
    }
}
