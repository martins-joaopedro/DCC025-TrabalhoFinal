package br.ufjf.exceptions;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import javax.swing.*;

public class ExceptionsController {

    public ExceptionsController(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
