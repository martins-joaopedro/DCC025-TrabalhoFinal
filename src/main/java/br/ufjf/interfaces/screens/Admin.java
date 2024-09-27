package br.ufjf.interfaces.screens;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.services.AdmService;

public class Admin extends PersonalLibrary {

    private final AdmService service = new AdmService();

    public Admin() {
        super("Biblioteca do Admin");
    }

    @Override
    public void options() {
        Button admOptions = new Button("Opcoes de Admin");
        admOptions.addActionListener(e -> AplicationWindow.showScreen("admOptions"));

        addTopButtons(0, 4, this.getAdicionarLivro(), admOptions);
    }
    
}
