package br.ufjf.interfaces.widgets;

import java.awt.*;
import javax.swing.*;

public class Style {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private static final Color backgroundColor = new Color(173, 216, 230);
    private static final Color buttonColor = new Color(135, 206, 250);

    private static final Font titleFont = new Font("Serif", Font.BOLD, 30); // Fonte para os títulos
    private static final Font mainFont = new Font("Serif", Font.PLAIN, 16); // Fonte padrão para os componentes

    private static final int borderRadius = 20; // Raio para a curvatura das bordas arredondadas

    // Carrega ícones para logo e botão "Voltar"
    private static ImageIcon logo = new ImageIcon(new ImageIcon(Style.class.getResource("/br/ufjf/interfaces/resources/bookself_logo.png"))
            .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    private static ImageIcon backIcon = new ImageIcon(new ImageIcon(Style.class.getResource("/br/ufjf/interfaces/resources/back_icon.png"))
            .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

    public static int getWidth() { return WIDTH; }
    public static int getHeight() { return HEIGHT; }

    public static Color getBackgroundColor() { return backgroundColor; }
    public static Color getButtonColor() { return buttonColor; }

    public static Font getTitleFont() { return titleFont; }
    public static Font getMainFont() { return mainFont; }

    // Método para retornar uma borda arredondada
    public static int getBorderRadius() { return borderRadius; }

    public static ImageIcon getLogo() { return logo; }
    public static Icon getBackIcon() { return backIcon; }
}
