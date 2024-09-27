package br.ufjf.models.enums;

public enum Status {
    LENDO("LENDO"), 
    LIDO("LIDO"), 
    QUERO_LER("QUERO LER"), 
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