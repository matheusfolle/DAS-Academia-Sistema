package model;

public enum MuscleGroup {
    CHEST("Peito"),
    BACK("Costas"),
    LEGS("Pernas"),
    BICEPS("Bíceps"),
    TRICEPS("Tríceps"),
    SHOULDERS("Ombros"),
    CORE("Core"); 

    private final String descricao;

    MuscleGroup(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}