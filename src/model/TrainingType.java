package model;

public enum TrainingType {
    STRENGTH("Musculação"),
    AEROBIC("Aeróbico"),
    FULL_BODY("Corpo inteiro"),
    HYBRID("Treino híbrido");

    private final String descricao;

    TrainingType(String descricao) {
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