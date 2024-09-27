package br.ufjf.interfaces;

import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

import br.ufjf.interfaces.widgets.*;
import br.ufjf.interfaces.widgets.cards.PersonalBookCard;
import br.ufjf.models.PersonalBook;
import br.ufjf.models.enums.*;

import br.ufjf.services.PersonalLibraryService;

public class PersonalLibrary extends BasicScreen {

    private final PersonalLibraryService service = new PersonalLibraryService();

    final JLabel titulo = new JLabel();

    private JLabel nomeUser = new JLabel();
    private JLabel numLivrosLidos = new JLabel();
    private JLabel numPaginasLidas = new JLabel();
    private JLabel generoFavorito = new JLabel();

    private Button adicionarLivro = new Button("Adicionar Livro");

    public PersonalLibrary() {
        super("home");

        this.titulo.setText("Biblioteca Pessoal");
        updateData();

        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        addTitle(this.titulo, false);
   
        addComponent(nomeUser, 0, 0, false);
        addComponent(numLivrosLidos, 0, 1,  false);
        addComponent(numPaginasLidas, 0, 2, false);
        addComponent(generoFavorito, 0, 3, false);

        adicionarLivro.addActionListener(e -> AplicationWindow.showScreen("library"));
        options();

        int i = 5;
        for(Status status : Status.values()) {
            addComponent(new JLabel(status.getDisplayName() + ":"), 0, i, false);
            addComponent(bookList(status), 0, i+1, false);
            i+=2;
        }
    }

    public PersonalLibrary(String titulo) {
        super("home");

        this.titulo.setText(titulo);
        updateData();

        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        addTitle(this.titulo, false);
   
        addComponent(nomeUser, 0, 0, false);
        addComponent(numLivrosLidos, 0, 1,  false);
        addComponent(numPaginasLidas, 0, 2, false);
        addComponent(generoFavorito, 0, 3, false);

        adicionarLivro.addActionListener(e -> AplicationWindow.showScreen("library"));
        options();

        int i = 5;
        for(Status status : Status.values()) {
            addComponent(new JLabel(status.getDisplayName() + ":"), 0, i, false);
            addComponent(bookList(status), 0, i+1, false);
            i+=2;
        }
    }

    public Button getAdicionarLivro() {
        return adicionarLivro;
    }

    public void options() {
        addTopButtons(0, 4, adicionarLivro);
    }

    private ComponentList bookList(Status status) {
        List<JComponent> components = new ArrayList<JComponent>();

        List<PersonalBook> books = service.getBooksByStatus(status);

        for (PersonalBook book : books) {
            components.add(new PersonalBookCard(book));
        }

        return new ComponentList(components, true);
    }

    public void updateData() {
        String userName = AplicationWindow.getUser();

        try {
            nomeUser.setText("Bem-vindo, " + userName.substring(0, 1).toUpperCase() + userName.substring(1) + "!");
        } catch (Exception e) {
            nomeUser.setText("Bem-vindo!");
        }
        
        numLivrosLidos.setText("Você já leu " + service.getNumLivrosLidos() + " livros.");
        numPaginasLidas.setText("Você já leu " + service.getNumTotalPaginasLidas() + " páginas.");

        try {
            generoFavorito.setText("Seu gênero favorito é " + service.getGenreMaisLido().getType() + ".");
        } catch (Exception e) {
            generoFavorito.setText("Você ainda não leu nenhum livro.");
            return;
        }
        
    }
}
