package br.ufjf.models.enums;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

public enum Genre {
    FANTASIA("Fantasia"),
    ROMANCE("Romance"),
    FICCAO("Ficcao"),
    ACADEMICO("Academico"),
    DISTOPIA("Distopia"),
    SUSPENSE("Suspense"), 
    LITERATURA_JUVENIL("Literatura Juvenil"),
    FICCAO_CIENTIFICA("Ficcao Cientifica"),
    MISTERIO("Misterio"),
    HORROR("Horror");

    private String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Genre fromDisplayName(String displayName) {
        for (Genre genre : Genre.values()) {
            if (genre.displayName.equalsIgnoreCase(displayName)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + displayName);
    }
}
