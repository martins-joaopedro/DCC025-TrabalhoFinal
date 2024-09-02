package br.ufjf;

import br.ufjf.swing.Manager;

public class Main {

    private static Manager manager;

    public static void main(String[] args) {

        manager = new Manager();
        manager.start();
    }
}