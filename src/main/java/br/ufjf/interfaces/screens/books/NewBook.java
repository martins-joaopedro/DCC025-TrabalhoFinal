package br.ufjf.interfaces.screens.books;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.ParserExceptions;
import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.UIConstants;

import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.screens.libraries.Adm;
import br.ufjf.interfaces.screens.review.BookReviews;
import br.ufjf.services.AdmService;
import br.ufjf.services.LibraryService;
import br.ufjf.utils.InputParser;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.interfaces.widgets.TextField;
import br.ufjf.models.Book;
import br.ufjf.models.enums.Genre;
import br.ufjf.interfaces.widgets.Button;

import javax.swing.*;

import java.awt.*;

import br.ufjf.exceptions.LibraryException;

public class NewBook extends BasicScreen {

    private String ISBN = AplicationWindow.getBook();
    
    private final AdmService service = new AdmService();
    private final LibraryService libraryService = new LibraryService();
    
    private JLabel title = new JLabel("Informações do livro:");
    private TextField bookName = new TextField(30);
    private TextField autor = new TextField(30);
    private TextField isbnText = new TextField(30);
    private TextField numPaginas = new TextField(30);
    private JComboBox<String> genreBox = new JComboBox<String>();
    private Genre selectedGenre = Genre.FANTASIA;
    private JTextArea sinopseText = new JTextArea();
    private boolean isEditing = false;
    private JButton saveBook;

    public NewBook() {
        super("adm");

        ISBN = AplicationWindow.getBook();

        updateData(ISBN);
        
        addTitle(title, false);

        BasicScreen info = new BasicScreen(null);
        info.addComponent(new JLabel("Nome do livro: "), 0, 0, false);
        info.addComponent(bookName, 1, 0, false);
        
        info.addComponent(new JLabel("Autor: "), 0, 1, false);
        info.addComponent(autor, 1, 1, false);

        info.addComponent(new JLabel("ISBN: "), 0, 2, false);
        info.addComponent(isbnText, 1, 2, false);

        info.addComponent(new JLabel("Número de páginas: "), 0, 3, false);
        info.addComponent(numPaginas, 1, 3, false);

        info.addComponent(new JLabel("Gênero: "), 0, 4, false);
        info.addComponent(genreBox, 1, 4, false);
        
        addComponent(info, 0, 0);
        addComponent(new JLabel("Sinopse: "), 0, 1, false);
        addComponent(sinopseText, 0, 2, false);
        
        addComponent(new JLabel("Avaliações: "), 0, 3, false);
        addComponent(new BookReviews(true, new Object()), 0, 4, false);

        if(isEditing)
            this.saveBook = new Button("Editar Livro");
        else this.saveBook = new Button("Adicionar Livro");
        saveBook.addActionListener(e -> addBookController());

        addButtons(saveBook);
    }

    private void addBookController() {

        try {
            Book data = InputParser.toBook(bookName.getText(), autor.getText(), isbnText.getText(), sinopseText.getText(), numPaginas.getText(), this.selectedGenre);
            
            try {
                if(this.isEditing)
                    service.update(data);
                else service.addBook(data);
            } catch (LibraryException e) {
                new ExceptionsController(e);
            }
        
        } catch (ParserExceptions e) {
            new ExceptionsController(e);
            AplicationWindow.showScreen("adm");
            return;
        }
        
        AplicationWindow.reloadScreen(new Adm(), "adm");
    }

    private void updateData(String ISBN) {

        Book book = libraryService.findById(ISBN);

        if(book != null)
            this.isEditing = true;

        for(Genre g : Genre.values()) {
            genreBox.addItem(g.getDisplayName());
        }

        try {
            bookName.setText(book.getName());
            autor.setText(book.getAuthor());
            isbnText.setText(book.getISBN());
            numPaginas.setText(Integer.toString(book.getPages()));

            this.selectedGenre = book.getGenre();
            
            sinopseText.setText(book.getSynopsis());
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar dados do livro");
        }
        
        sinopseText.setPreferredSize(new Dimension(300, 200));
        sinopseText.setMinimumSize(new Dimension(300, 200));
        sinopseText.setEditable(true);
        sinopseText.setWrapStyleWord(true);
        sinopseText.setAutoscrolls(true);
        sinopseText.setLineWrap(true);
        sinopseText.setBackground(Color.WHITE);
        sinopseText.setFont(Style.getFitFont());
        sinopseText.setBorder(UIConstants.ROUNDED_BORDER);
        
        genreBox.setSelectedItem(this.selectedGenre.getDisplayName());
        genreBox.addActionListener(e -> {
            this.selectedGenre = Genre.fromDisplayName(genreBox.getSelectedItem().toString());
        });
    }
}
