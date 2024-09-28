package br.ufjf.interfaces.screens.books;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.screens.review.BookReviews;
import br.ufjf.interfaces.widgets.*;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.interfaces.components.cards.ReviewCard;
import br.ufjf.interfaces.components.lists.ComponentList;
import br.ufjf.models.*;
import br.ufjf.models.dto.PersonalBookDTO;
import br.ufjf.models.enums.Status;

import br.ufjf.services.*;

public class BookInformations extends BasicScreen {

    private String ISBN = AplicationWindow.getBook();
    private final ReviewService reviewService = new ReviewService();
    private final LibraryService libraryService = new LibraryService();
    private final PersonalLibraryService personalLibraryService = new PersonalLibraryService();
    
    private JLabel title = new JLabel("Adicionar novo livro:");
    private JLabel bookName = new JLabel();
    private JLabel autor = new JLabel();
    private JLabel numPaginas = new JLabel();
    private JLabel genero = new JLabel();
    private JLabel sinopse = new JLabel();
    private JTextArea sinopseText = new JTextArea();
    private JLabel status = new JLabel();
    private ScrollPanel avaliacoesList = new ScrollPanel();
    private JComboBox<String> statusBox = new JComboBox<String>();
    private Status selectedStatus = Status.QUERO_LER;
    private JButton adicionarLivro = new Button("Adicionar Livro");

    public BookInformations() {
        super("library");

        updateData(ISBN);

        adicionarLivro.addActionListener(e -> addBookController());
        
        addTitle(title, false);
        addComponent(bookName, 0, 0, false);
        addComponent(autor, 0, 1, false);
        addComponent(numPaginas, 0, 2, false);
        addComponent(genero, 0, 3, false);
        addComponent(sinopse, 0, 4, false);
        addComponent(sinopseText, 0, 5, false);
        addComponent(status, 0, 6, false);
        addComponent(statusBox, 0, 7, false);
        addComponent(new JLabel("Avaliações: "), 0, 8, false);
        addComponent(new BookReviews(false, new Object()), 0, 9, false);
        addButtons(adicionarLivro);
    }

    private void addBookController() {
        PersonalBookDTO book = new PersonalBookDTO(ISBN, AplicationWindow.getUser(), this.selectedStatus, 0);
        personalLibraryService.addToPersonalLibrary(book);
        AplicationWindow.showScreen("personalLibrary");
    }

    private void updateData(String ISBN) {

        Book book = libraryService.findById(ISBN);
        try {
            bookName.setText("Nome: " + book.getName());
            autor.setText("Autor: " + book.getAuthor());
            numPaginas.setText("Número de Páginas: " + book.getPages());
            genero.setText("Gênero: " + book.getGenre());
            sinopse.setText("Sinopse: ");

            sinopseText.setText(book.getSynopsis());
            sinopseText.setPreferredSize(new Dimension(300, 100));
            sinopseText.setMinimumSize(new Dimension(300, 100));
                sinopseText.setEditable(false);
                sinopseText.setWrapStyleWord(true);
                sinopseText.setAutoscrolls(true);
                sinopseText.setLineWrap(true);
                sinopseText.setBackground(Style.getBackgroundColor());

        } catch (Exception e) {
            System.out.println("Erro ao buscar informações do livro");

            bookName.setText("Nome: ");
            autor.setText("Autor: ");
            numPaginas.setText("Número de Páginas: ");
            genero.setText("Gênero: ");
            sinopse.setText("Sinopse: ");
        }   

        for(Status s : Status.values()) {
            statusBox.addItem(s.getDisplayName());
        }

        status.setText("Status: ");
        statusBox.addActionListener(e -> {
            this.selectedStatus = Status.fromDisplayName(statusBox.getSelectedItem().toString());
        });

        avaliacoesList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ComponentList list = loadReviewsList();
        if(list != null)
            avaliacoesList.setViewportView(list);
        else avaliacoesList.setViewportView(new JLabel("Nenhuma avaliação disponível!"));
    }

    private ComponentList loadReviewsList() {
        List<Review> reviews = reviewService.getAllReviewsByISBN(ISBN);
        List<JComponent> components = new ArrayList<JComponent>();

        if(reviews.isEmpty())
            return null;
        JPanel avaliacoes = new JPanel();
        avaliacoes.setLayout(new BoxLayout(avaliacoes, BoxLayout.Y_AXIS));
        avaliacoes.setBackground(Color.WHITE);
        avaliacoes.setPreferredSize(new Dimension(300, 150));
        avaliacoes.setMinimumSize(new Dimension(300, 150));

        for (Review review : reviews) {
            components.add(new ReviewCard(review, false));
        }

        return new ComponentList(components, false);
    }
}
