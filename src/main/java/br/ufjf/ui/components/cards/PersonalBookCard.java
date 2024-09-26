package br.ufjf.ui.components.cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import br.ufjf.models.enums.Status;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufjf.models.PersonalBook;
import br.ufjf.models.dto.PersonalBookDTO;
import br.ufjf.services.PersonalLibraryService;
import br.ufjf.ui.UIConstants;
import br.ufjf.ui.panels.PersonalLibraryScreenPanel;

public class PersonalBookCard extends BookCard {

    PersonalLibraryService service = new PersonalLibraryService();

    public PersonalBookCard(PersonalBook book) {
        super(book);

        setMaximumSize(new Dimension(UIConstants.BOOKCARD_WIDTH, UIConstants.BOOKCARD_HEIGHT*3/2));
        JPanel informations = new JPanel();
        informations.setLayout(new GridLayout(3, 1));
        //informations.setPreferredSize(new Dimension(UIConstants.BOOKCARD_WIDTH, UIConstants.BOOKCARD_HEIGHT));
        informations.setBackground(Color.red);

        informations.add(new JLabel("Status: " + book.getStatus().name()));
        informations.add(new JLabel("Página atual: " + String.valueOf(book.getCurrentPage())));
        
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(0, 3));

        JButton remove = new JButton("remover");
        remove.addActionListener(e -> {
            service.removeFromPersonalLibrary(book.getISBN()); 
            PersonalLibraryScreenPanel.reload();
        });

        JButton update = new JButton("atualizar");
        update.addActionListener(e -> {
            service.updateBook(new PersonalBookDTO(book.getISBN(), book.getStatus(), book.getCurrentPage()));
            PersonalLibraryScreenPanel.reload();
        });

        options.add(remove);
        options.add(update);

        informations.add(options);
        add(informations);

        String[] s = new String[Status.values().length];
        List<String> o = new ArrayList<>();
        for(Status value : Status.values()) {
            o.add(value.getDisplayName());
        }

        s = o.toArray(new String[0]);
        JComboBox<String> comboBox = new JComboBox<>(s);
        comboBox.addActionListener(e -> {
            book.setStatus( Status.fromDisplayName(comboBox.getSelectedItem().toString()) );
        });

        add(comboBox);
    }

}
