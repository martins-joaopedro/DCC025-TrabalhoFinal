package br.ufjf.models.enums;

/*
 * autores:
    João Pedro Martins Cruz, 202365552C
    Júlia Zoffoli Caçador, 202365520B
    Robert Gonçalves Vieira de Souza, 202365505B
 */

public enum Status {
    LENDO("LENDO"), 
    LIDO("LIDO"), 
    QUERO_LER("QUERO LER"),
    RELENDO("RELENDO"),
    ABANDONEI("ABANDONEI");

    private String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Status fromDisplayName(String displayName) {
        for (Status status : Status.values()) {
            if (status.displayName.equalsIgnoreCase(displayName)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + displayName);
    }
}