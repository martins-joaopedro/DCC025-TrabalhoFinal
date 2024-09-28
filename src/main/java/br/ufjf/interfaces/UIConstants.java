package br.ufjf.interfaces;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class UIConstants {
    
    public static int REVIEW_CARD_WIDTH = 300;
    public static int REVIEW_CARD_HEIGHT = 320;
    public static int BOOK_CARD_WIDTH = 300;
    public static int BOOK_CARD_HEIGHT = 350;
    
    public static Border roundedBorder = BorderFactory.createLineBorder(Color.GRAY, 2, true); // true para cantos arredondados
    public static Border padding = BorderFactory.createEmptyBorder(5, 2, 2, 2); // Espaçamento interno
    public static Border ROUNDED_BORDER = BorderFactory.createCompoundBorder(roundedBorder, padding);
    
}
