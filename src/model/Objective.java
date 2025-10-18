package model;

public enum Objective {
    HYPERTROPHY("Hipertrofia"),
    WEIGHT_LOSS("Emagrecimento"),
    CONDITIONING("Condicionamento físico"),
    GENERAL_HEALTH("Saúde geral");

    private final String descricao;

    Objective(String descricao) {
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