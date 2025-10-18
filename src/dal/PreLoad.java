package dal;

import java.time.LocalDate;
import java.util.*;
import model.*;

public class PreLoad {
    public static void main(String[] args) {
        try {
            ArrayList<Customer> customers = new ArrayList<>();
            customers.add(new Customer(customers, "João Silva", LocalDate.of(1990, 5, 20), Objective.HYPERTROPHY));
            customers.add(new Customer(customers, "Maria Oliveira", LocalDate.of(1985, 8, 10), Objective.WEIGHT_LOSS));
            CustomerDAO.save(customers);

            ArrayList<Exercise> exercises = new ArrayList<>();
            exercises.add(new Exercise("Supino Reto", "12", "3", exercises));
            exercises.add(new Exercise("Agachamento Livre", "10", "4", exercises));
            ExerciseDAO.save(exercises);

            List<Training> trainings = new ArrayList<>();
            trainings.add(new TrainingByInternet(1, "45 min", TrainingType.STRENGTH, List.of(MuscleGroup.CHEST), List.of(exercises.get(0)), "YouTube"));

            trainings.add(new TrainingByInnerGym(2, "1h", TrainingType.FULL_BODY, List.of(MuscleGroup.LEGS, MuscleGroup.BACK), List.of(exercises.get(1)), "Rogério", "Manhã"));

            TrainingDAO.save(trainings);

            customers.get(0).addTraining(trainings.get(0));
            customers.get(1).addTraining(trainings.get(1));
            CustomerDAO.save(customers);

            System.out.println("Pré-carga concluída com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro na pré-carga: " + e.getMessage());
        }
    }
}
