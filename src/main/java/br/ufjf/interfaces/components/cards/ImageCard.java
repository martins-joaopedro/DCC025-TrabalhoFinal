package br.ufjf.interfaces.components.cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageCard extends JPanel {

    int width;
    int height;
    int x;
    int y;
    BufferedImage img;
    Color color;
    String mainPath = "src" + File.separator + "main" 
        + File.separator + "java" + File.separator + "br" 
        + File.separator + "ufjf" + File.separator + "interfaces"
        + File.separator + "resources" + File.separator;

    public ImageCard(String path, int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.color = color;

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        
        try {
            this.img = ImageIO.read(new File(mainPath+path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, this.x, this.y, this.width, this.height, this.color, this);
    }
}
