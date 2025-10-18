package model;

import java.util.List;

public class TrainingByPersonal extends Training {
    private String instructor;
    private String period;

    public TrainingByPersonal(int id, String duration, TrainingType type, List<MuscleGroup> muscleGroups, List<Exercise> exercises, String instructor, String period) {
        super(id, duration, type, muscleGroups, exercises);
        this.instructor = instructor;
        this.period = period;
    }

    @Override
    public String getTrainingOrigin() {
        return "Personal Trainer: " + instructor + ", período: " + period;
    }

    @Override
    public String getSummary() {
        return trainingType.getDescricao() + " (" + estimatedDuration + ") - " + getTrainingOrigin();
    }

    public String getInstructor() {
        return instructor;
    }

    public String getPeriod() {
        return period;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}