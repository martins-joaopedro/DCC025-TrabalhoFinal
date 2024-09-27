package br.ufjf.models.enums;

public enum Status {
    LENDO("Lendo"), 
    LIDO("Lido"), 
    QUERO_LER("Quero Ler"), 
    ABANDONEI("Abandonei");

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
        // Caso não encontre, pode retornar nulo ou lançar uma exceção
        throw new IllegalArgumentException("Nenhum Status encontrado com displayName: " + displayName);
    }
}