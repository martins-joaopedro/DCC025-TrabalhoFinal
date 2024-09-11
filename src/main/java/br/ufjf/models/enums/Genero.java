package br.ufjf.models.enums;

public enum Genero {
    FANTASIA("fantasia"), ROMANCE("romance"), FICCAO("ficcao"), ACADEMICO("academico"), DISTOPIA("distopia"), SUSPENSE("suspense"), TERROR("terror");

    String tipo;

    Genero(String s) {
        this.tipo = s;
    }

    public String getTipo() {
        return this.tipo;
    }
}
