package br.ufjf.ui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufjf.models.PersonalBook;
import br.ufjf.services.PersonalLibraryService;
import br.ufjf.ui.Manager;
import br.ufjf.ui.UIConstants;
import br.ufjf.ui.components.ComponentList;
import br.ufjf.ui.components.cards.PersonalBookCard;

public class PersonalLibraryScreenPanel extends JPanel {

    PersonalLibraryService service = new PersonalLibraryService(); 
    JPanel mainPanel;
    JPanel area = new JPanel();

    public PersonalLibraryScreenPanel() {
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.red);

        JButton a = new JButton("RECARREGAR");
        a.addActionListener(e -> loadAllBookCards());
        mainPanel.add(a);
        
      
        mainPanel.add(area);
        
        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.setPreferredSize(new Dimension(UIConstants.SCREEN_WIDTH - UIConstants.OFFSET, UIConstants.SCREEN_HEIGHT-200));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
        
    }
    
    public void loadAllBookCards() {
        List<PersonalBook> books = service.getAll();
        List<PersonalBookCard> bookCards = new ArrayList<>();

        for(PersonalBook book : books)
            bookCards.add(new PersonalBookCard(book));

        area.removeAll();
        area.add(new ComponentList<>(bookCards, true));
        //area.repaint();
        //mainPanel.repaint();
        
        Manager.navigateTo("home");
        Manager.navigateTo("bibliotecaPessoal");
       
    }


}