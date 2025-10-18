package controller;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class ExerciseController {
    private ArrayList exercises;

    public ExerciseController(ArrayList list) {
        this.exercises = (list != null) ? list : new ArrayList();
    }

    public void registerExercise(String name, String repetitions, String sets) {
        Exercise e = new Exercise(name, repetitions, sets, exercises);
        exercises.add(e);
    }

    public boolean removeExercise(int id) {
        return exercises.removeIf(e -> ((Exercise) e).getId() == id);
    }

    public List<Exercise> getAllExercises() {
        return exercises;
    }

    public Exercise findExerciseById(int id) {
        for (Object e : exercises) {
            if (((Exercise) e).getId() == id) return (Exercise) e;
        }
        return null;
    }
}