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

    String type;

    Genre(String s) {
        this.type = s;
    }

    public String getType() {
        try {
            return this.type;
        } catch (Exception e) {
            return "Genero não encontrado";
        }
    }
}
