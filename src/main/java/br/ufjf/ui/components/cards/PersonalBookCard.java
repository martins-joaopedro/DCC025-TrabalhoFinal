package br.ufjf.ui.components.cards;

import javax.swing.JButton;
import javax.swing.JLabel;

import br.ufjf.models.PersonalBook;
import br.ufjf.services.PersonalLibraryService;

public class PersonalBookCard extends BookCard {

    PersonalLibraryService service = new PersonalLibraryService();

    public PersonalBookCard(PersonalBook book) {
        super(book);
        
        add(new JLabel("Status: " + book.getStatus().name()));
        add(new JLabel("Página atual: " + String.valueOf(book.getCurrentPage())));
        
        JButton remove = new JButton("remover");
        remove.addActionListener(e -> service.removeFromPersonalLibrary(book.getISBN()));
        add(remove);

        //Manager.navigateTo("bibliotecaPessoal");
    }

}
