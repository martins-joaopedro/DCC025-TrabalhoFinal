package br.ufjf.exceptions;

import javax.swing.*;

public class ExceptionsController {

    public ExceptionsController(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
