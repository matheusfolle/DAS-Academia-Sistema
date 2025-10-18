package model;

import java.io.Serializable;
import java.util.List;

public abstract class Training implements Serializable {
    protected int id;
    protected String estimatedDuration;
    protected TrainingType trainingType;
    protected List<MuscleGroup> muscleGroups;
    protected List<Exercise> exercises;

    public Training(int id, String estimatedDuration, TrainingType trainingType, List<MuscleGroup> muscleGroups, List<Exercise> exercises) {
        this.id = id;
        this.estimatedDuration = estimatedDuration;
        this.trainingType = trainingType;
        this.muscleGroups = muscleGroups;
        this.exercises = exercises;
    }

    public abstract String getSummary();

    public String getSummary(boolean incluirQtdExercicios) {
        if (incluirQtdExercicios) {
            return getSummary() + " | Exercícios: " + countExercises();
        }
        return getSummary();
    }
    
    public abstract String getTrainingOrigin();

    public int countExercises() {
        return (exercises != null) ? exercises.size() : 0;
    }

    public boolean hasExercise(int id) {
        for (Exercise ex : exercises) {
            if (ex.getId() == id) 
            return true;
        }
        return false;
    }

    public boolean removeExerciseById(int id) {
        return exercises.removeIf(ex -> ex.getId() == id);
    }

    public int getId() {
        return id;
    }

    public String getEstimatedDuration() {
        return estimatedDuration;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public List<MuscleGroup> getMuscleGroups() {
        return muscleGroups;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstimatedDuration(String estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public void setMuscleGroups(List<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        String result = "Treino:\n" +
                "ID: " + id + "\n" +
                "Duração estimada: " + estimatedDuration + "\n" +
                "Tipo de treino: " + trainingType.getDescricao() + "\n" +
                "Grupos Musculares:\n";

        for (MuscleGroup m : muscleGroups) {
            result += "- " + m.toString() + "\n";
        }

        result += "Exercícios:\n";
        for (Exercise e : exercises) {
            result += "- " + e.toString() + "\n";
        }

        return result;
    }
}