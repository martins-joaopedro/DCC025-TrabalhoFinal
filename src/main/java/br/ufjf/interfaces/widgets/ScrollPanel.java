package br.ufjf.interfaces.widgets;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ScrollPanel extends JScrollPane {

    public ScrollPanel() {
        super();

        // Personaliza as barras de rolagem para remover as bordas
        getVerticalScrollBar().setUI(new CustomScrollBarUI());
        getHorizontalScrollBar().setUI(new CustomScrollBarUI());
    }

    // UI personalizada para as barras de rolagem (sem bordas e com espaçamento)
    private static class CustomScrollBarUI extends BasicScrollBarUI {

        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = Style.getBackgroundColor(); // Cor do "thumb"
            this.trackColor = new Color(0, 0, 0, 0); // Fundo transparente da trilha (track)
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            // Fundo transparente (não desenha o track)
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Pinta o "thumb" arredondado e fino
            g2.setColor(thumbColor);
            g2.fillRoundRect(thumbBounds.x + 4, thumbBounds.y + 4, thumbBounds.width - 8, thumbBounds.height - 8, 10, 10); // Afasta o thumb das bordas

            g2.dispose();
        }

        @Override
        protected Dimension getMinimumThumbSize() {
            // Define o tamanho mínimo do "thumb" (para que fique fino)
            return new Dimension(8, 30); // Largura fina (8px) e altura mínima de 30px
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createInvisibleButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createInvisibleButton();
        }

        private JButton createInvisibleButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);
            return button;
        }
    }
}
