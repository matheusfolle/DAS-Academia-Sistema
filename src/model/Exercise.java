package model;

import interfaces.Registrable;
import java.io.Serializable;
import java.util.ArrayList;

public class Exercise implements Registrable, Serializable {
    private int id;
    private String name;
    private String reps;
    private String sets;

    public Exercise(String name, String reps, String sets, java.util.ArrayList allExercises) {
        this.id = generateExerciseId(allExercises);
        this.name = name;
        this.reps = reps;
        this.sets = sets;
    }

    private int generateExerciseId(ArrayList allExercises) {
        return allExercises.stream()
                .mapToInt(e -> ((Exercise) e).getId())
                .max()
                .orElse(0) + 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReps() {
        return reps;
    }

    public String getSets() {
        return sets;
    }

    public String getSummary() {
        return "Exercício: " + name + " - " + sets + "x" + reps;
    }

    public String toString() {
        return getSummary();
    }
} 
