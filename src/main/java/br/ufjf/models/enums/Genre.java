package br.ufjf.models.enums;

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
