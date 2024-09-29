package br.ufjf.interfaces;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class UIConstants {

    public static final int WINDOW_WIDTH = 550;
    public static final int WINDOW_HEIGHT = 800;
    
    public static int REVIEW_CARD_WIDTH = 400;
    public static int REVIEW_CARD_HEIGHT = 250;

    public static int BOOK_CARD_WIDTH = 300;
    public static int BOOK_CARD_HEIGHT = 320;

    public static int TEXTBOX_WIDTH = WINDOW_WIDTH-100;
    public static int TEXTBOX_HEIGHT = 200;
    
    public static Border roundedBorder = BorderFactory.createLineBorder(Color.GRAY, 2, true); // true para cantos arredondados
    public static Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10); // Espaçamento interno
    public static Border ROUNDED_BORDER = BorderFactory.createCompoundBorder(roundedBorder, padding);
    
}
