package br.ufjf.interfaces.screens;

import br.ufjf.interfaces.components.cards.ReviewCard;
import br.ufjf.models.Review;

import java.awt.*;

public class Teste extends BasicScreen {

    public Teste() {
        super("a");

        Review r = new Review("22","22","22",3, "AAAAAAAAAAA");

        addComponent(new ReviewCard(r), 0, 1);
    }
}
