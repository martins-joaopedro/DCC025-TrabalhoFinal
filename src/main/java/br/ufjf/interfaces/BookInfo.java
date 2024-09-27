package br.ufjf.interfaces;

import javax.swing.*;
import java.awt.*;

import java.util.List;

import br.ufjf.interfaces.widgets.*;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.*;
import br.ufjf.models.enums.Status;

import br.ufjf.services.*;

public class BookInfo extends BasicScreen {

    private String ISBN = AplicationWindow.getBook();

    private final LibraryService service = new LibraryService();
    private final PersonalLibraryService personalLibraryService = new PersonalLibraryService();
    private final ReviewService reviewService = new ReviewService();

    private JLabel title = new JLabel("Adicionar novo livro:");

    private JLabel bookName = new JLabel();
    private JLabel autor = new JLabel();
    private JLabel numPaginas = new JLabel();
    private JLabel genero = new JLabel();
    private JLabel sinopse = new JLabel();
    private JTextArea sinopseText = new JTextArea();

    private JLabel status = new JLabel();
    private JComboBox<String> statusBox = new JComboBox<String>();

    private ScrollPanel avaliacoesList = new ScrollPanel();

    private JButton adicionarLivro = new Button("Adicionar Livro");
    private Status selectedStatus = Status.QUERO_LER;

    public BookInfo() {
        super("library");

        ISBN = AplicationWindow.getBook();

        updateData(ISBN);

        adicionarLivro.addActionListener(e -> {
                personalLibraryService.addToPersonalLibrary(ISBN, selectedStatus);
                AplicationWindow.showScreen("personalLibrary");
        });
        
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
        addComponent(avaliacoesList, 0, 9, false);

        addButtons(adicionarLivro);
    }

    private void updateData(String ISBN) {
        if(service.findById(ISBN) == null) {
            System.out.println("Livro não encontrado");
            return;
        }

        Book book = service.findById(ISBN);
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

        status.setText("Status: ");
        statusBox.addItem("LENDO");
        statusBox.addItem("LIDO");
        statusBox.addItem("QUERO LER");
        statusBox.addItem("ABANDONEI");

        statusBox.setSelectedItem(this.selectedStatus.toString());
        statusBox.addActionListener(e -> {
            if(statusBox.getSelectedItem().toString() == "QUERO LER")
                this.selectedStatus = Status.QUERO_LER;
            else if(statusBox.getSelectedItem().toString() == "LENDO")
                this.selectedStatus = Status.LENDO;
            else if(statusBox.getSelectedItem().toString() == "LIDO")
                this.selectedStatus = Status.LIDO;
            else if(statusBox.getSelectedItem().toString() == "ABANDONEI")
                this.selectedStatus = Status.ABANDONEI;
        });

        avaliacoesList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        avaliacoesList.setViewportView(avaliacoes(reviewService.getReviews(ISBN)));
    }

    private JPanel avaliacoes(List<Review> reviews) {
        JPanel avaliacoes = new JPanel();
        avaliacoes.setLayout(new BoxLayout(avaliacoes, BoxLayout.Y_AXIS));
        avaliacoes.setBackground(Color.WHITE);
        avaliacoes.setPreferredSize(new Dimension(300, 150));
        avaliacoes.setMinimumSize(new Dimension(300, 150));

        for (Review review : reviews) {
            JLabel avaliacao = new JLabel("@" + review.getUsername() + " - " + review.getStars() + "/ 5 estrelas.");
            avaliacoes.add(avaliacao);
        }

        return avaliacoes;
    }
    
}
