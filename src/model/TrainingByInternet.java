package model;

import java.util.List;

public class TrainingByInternet extends Training {
    private String source;

    public TrainingByInternet(int id, String duration, TrainingType type, List<MuscleGroup> muscleGroups, List<Exercise> exercises, String source) {
        super(id, duration, type, muscleGroups, exercises);
        this.source = source;
    }

    @Override
    public String getTrainingOrigin() {
        return "Fonte online: " + source;
    }

    @Override
    public String getSummary() {
        return trainingType.getDescricao() + " (" + estimatedDuration + ") - " + getTrainingOrigin();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}