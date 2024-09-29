package br.ufjf.interfaces.components.cards;

import javax.swing.*;
import java.awt.*;

import br.ufjf.exceptions.ExceptionsController;
import br.ufjf.exceptions.LibraryException;
import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.UIConstants;
import br.ufjf.interfaces.screens.libraries.Adm;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.widgets.Style;
import br.ufjf.models.Book;
import br.ufjf.services.AdmService;
import br.ufjf.services.LibraryService;

public class AdmBookCard extends BookCard {

    private final AdmService admService = new AdmService();
    private final LibraryService libraryService = new LibraryService();
    
    public AdmBookCard(Book book) {
        super(book);

        JTextArea sinopsysArea = new JTextArea(book.getSynopsis());
            sinopsysArea.setFont(Style.getFitFont().deriveFont(Font.PLAIN, 10));
            sinopsysArea.setEditable(false);
            sinopsysArea.setWrapStyleWord(true);sinopsysArea.setAutoscrolls(true);
            sinopsysArea.setLineWrap(true);
            sinopsysArea.setPreferredSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, 50));
            sinopsysArea.setMinimumSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, 50));
            sinopsysArea.setMaximumSize(new Dimension(UIConstants.BOOK_CARD_WIDTH, 50));
            sinopsysArea.setBackground(Style.getBackgroundColor());
        add(sinopsysArea);

        int averageStars = reviewService.getAverageStarsByISBN(book.getISBN());
        
        JPanel starsPanel = new JPanel();
        starsPanel.setOpaque(false);
        for(int i=0; i<averageStars; i++)
            starsPanel.add(new ImageCard("star.png", 20, 20, getBackground()));
        add(starsPanel);

        drawButtons(book.getISBN());
    }

    @Override
    protected void drawButtons(String ISBN) {
        Button editBook = new Button("Editar livro");
        Button removeBook = new Button("Remover livro");

        editBook.addActionListener(e -> AplicationWindow.showBookScreen("newBook", ISBN));
        removeBook.addActionListener(e -> {
            try {
                admService.removeBook(libraryService.findById(ISBN));
                AplicationWindow.reloadScreen(new Adm(), "adm");
            
            } catch (LibraryException err) {    
                new ExceptionsController(err);
            }
        });

        addButtons(editBook, removeBook);
    }
}
