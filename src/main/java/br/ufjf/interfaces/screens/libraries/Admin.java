package br.ufjf.interfaces.screens.libraries;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.BasicScreen;
import br.ufjf.interfaces.widgets.Button;
import br.ufjf.services.AdmService;

public class Admin extends BasicScreen {

    private final AdmService service = new AdmService();

    public Admin() {
        super("home");
    }

}
