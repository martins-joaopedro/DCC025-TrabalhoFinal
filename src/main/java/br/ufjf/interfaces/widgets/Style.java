package br.ufjf.interfaces.widgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Style {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 950;

    private static final Color lightBackgroundColor = new Color(235, 243, 245);
    private static final Color primaryColor = new Color(30, 0, 100);
    private static final Color backgroundColor = new Color(173, 216, 230);
    private static final Color buttonColor = new Color(135, 206, 250);

    private static Font titleFont;
    private static Font mainFont;
    private static Font fitFont;

    // Carrega a fonte "AlbertSans" do diretório de recursos
    static {
        try { 
            File file = new File("resources/albert_sans_font.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, file);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font); 
            
            titleFont = font.deriveFont(Font.BOLD, 30); 
            mainFont = font.deriveFont(Font.PLAIN, 16); 
            fitFont = font.deriveFont(Font.PLAIN, 14); 

        } catch (Exception e) {
            e.printStackTrace();
            
            titleFont = new Font("Serif", Font.BOLD, 30); 
            mainFont = new Font("Serif", Font.PLAIN, 16); 
            fitFont = new Font("Serif", Font.PLAIN, 14); 
        }
    }

    private static final int borderRadius = 20; 


    private static ImageIcon homeLogo = new ImageIcon(new ImageIcon("./resources/bookself_logo.png").getImage().getScaledInstance(145, 145, Image.SCALE_DEFAULT));
    private static ImageIcon logo = new ImageIcon(new ImageIcon("./resources/bookself_logo.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    private static ImageIcon backIcon = new ImageIcon(new ImageIcon("./resources/back_icon.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));

    public static int getWidth() { return WIDTH; }
    public static int getHeight() { return HEIGHT; }

    public static Color getPrimaryColor() { return primaryColor; }
    public static Color getBackgroundColor() { return backgroundColor; }
    public static Color getButtonColor() { return buttonColor; }
    public static Color getLightBackgroundColor() {
        return lightBackgroundColor;
    }

    public static Font getTitleFont() { return titleFont; }
    public static Font getMainFont() { return mainFont; }
    public static Font getFitFont() { return fitFont; }

    // Método para retornar uma borda arredondada
    public static int getBorderRadius() { return borderRadius; }

    public static ImageIcon getHomeLogo() { return homeLogo; }
    public static ImageIcon getLogo() { return logo; }
    public static Icon getBackIcon() { return backIcon; }
}
