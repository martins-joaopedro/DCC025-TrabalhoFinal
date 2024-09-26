package br.ufjf.interfaces.widgets;

import java.awt.*;
import javax.swing.ImageIcon;

public class Style {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private static final Color backgroundColor = new Color(173, 216, 230);
    private static final Color buttonColor = new Color(135, 206, 250);

    private static final Font titleFont = new Font("Serif", Font.BOLD, 30); // Fonte para os títulos
    private static final Font mainFont = new Font("Serif", Font.PLAIN, 16); // Fonte padrão para os componentes

    private static ImageIcon logo = new ImageIcon(new ImageIcon(Style.class.getResource("/br/ufjf/interfaces/resources/bookself_logo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

    public static int getWidth() { return WIDTH; }
    public static int getHeight() { return HEIGHT; }

    public static Color getBackgroundColor() { return backgroundColor; }
    public static Color getButtonColor() { return buttonColor; }

    public static Font getTitleFont() { return titleFont; }
    public static Font getMainFont() { return mainFont; }

    public static ImageIcon getLogo() { return logo; }
}
