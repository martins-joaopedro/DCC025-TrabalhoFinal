package br.ufjf.ui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufjf.models.PersonalBook;
import br.ufjf.services.PersonalLibraryService;
import br.ufjf.ui.Manager;
import br.ufjf.ui.UIConstants;
import br.ufjf.ui.components.ComponentList;
import br.ufjf.ui.components.cards.PersonalBookCard;

public class PersonalLibraryScreenPanel extends JPanel {

    public static PersonalLibraryService service = new PersonalLibraryService(); 
    JPanel mainPanel;
    static JPanel area = new JPanel();

    public PersonalLibraryScreenPanel() {
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.red);   
        mainPanel.add(area);
        
        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.setPreferredSize(new Dimension(UIConstants.SCREEN_WIDTH - UIConstants.OFFSET, UIConstants.SCREEN_HEIGHT-200));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
        
        drawAllPersonalBooks();
    }
    
    public static void reload() {
        drawAllPersonalBooks();
        Manager.navigateTo("home");
        Manager.navigateBack();
    }

    public static void drawAllPersonalBooks() {

        area.removeAll();

        List<PersonalBook> books = service.getAll();
        List<PersonalBookCard> bookCards = new ArrayList<>();

        Map<String, List<PersonalBookCard>> list = new HashMap<>();

        for(PersonalBook book : books) {
            
            if(!list.containsKey(book.getStatus())) {
                list.put(book.getStatus().name(), new ArrayList<>());
            } 

            list.get(book.getStatus().name()).add(new PersonalBookCard(book));
        }

        for(String key : list.keySet()) {
            System.out.println("AAAAAAA" + key);
            JPanel panel = new JPanel();
            panel.add(new JLabel("STATUS: " + key));
            System.out.println(list.get(key));
            panel.add(new ComponentList<>(list.get(key), true));
            area.add(panel);
        }

    }
}

//o que era pra ser varias listagens ta sendo um componente so