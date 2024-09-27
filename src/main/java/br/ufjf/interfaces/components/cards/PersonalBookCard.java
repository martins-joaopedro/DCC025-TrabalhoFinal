package br.ufjf.interfaces.components.cards;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.PersonalBook;
import br.ufjf.services.PersonalLibraryService;

public class PersonalBookCard extends BookCard {

    PersonalLibraryService service = new PersonalLibraryService();

    private final Button editBook = new Button("Editar");
    private final Button removeBook = new Button("Remover");
    private final Button seeReview = new Button("Ver Avaliações");
    
    public PersonalBookCard(PersonalBook book) {
        super(book);
        
        editBook.addActionListener(e -> AplicationWindow.showBookScreen("bookEdit", book.getISBN()));
        removeBook.addActionListener(e -> service.removeFromPersonalLibrary(book.getISBN()));
        seeReview.addActionListener(e -> AplicationWindow.showReviewScreen(book.getISBN()));
        addButtons(editBook, removeBook, seeReview);
    }

    public void handleOptions() {

    }
}
