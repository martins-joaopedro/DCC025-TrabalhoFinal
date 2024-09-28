package br.ufjf.interfaces.components.cards;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.models.PersonalBook;
import br.ufjf.models.enums.Status;
import br.ufjf.services.PersonalLibraryService;
import br.ufjf.services.ReviewService;

public class PersonalBookCard extends BookCard {

    private PersonalLibraryService service = new PersonalLibraryService();
    
    private final Button editBook = new Button("Editar");
    private final Button removeBook = new Button("Remover");
    private final Button addReview = new Button("Adicionar avaliação");

    public PersonalBookCard(PersonalBook book) {
        super(book);
        
        editBook.addActionListener(e -> AplicationWindow.showBookScreen("bookEdit", book.getISBN()));
        removeBook.addActionListener(e -> service.removeFromPersonalLibrary(book.getISBN()));
        addButtons(editBook, removeBook);

        addReview.addActionListener(e -> AplicationWindow.showReviewScreen(book.getISBN()));
        if(book.getStatus().equals(Status.LIDO))
            addButtons(addReview);

    }

}
