package br.ufjf.models.enums;

public enum Genre {
    FANTASIA("fantasia"), ROMANCE("romance"), FICCAO("ficcao"), ACADEMICO("academico"), DISTOPIA("distopia"), SUSPENSE("suspense"), TERROR("terror");

    String type;

    Genre(String s) {
        this.type = s;
    }

    public String getType() {
        return this.type;
    }
}
