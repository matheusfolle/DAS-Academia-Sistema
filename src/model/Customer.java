package model;

import interfaces.Registrable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Customer implements Registrable, Serializable {
    private int id;
    private String name;
    private LocalDate birthDate;
    private Objective objective;
    private ArrayList trainingSessions;

    public Customer(ArrayList allCustomers, String name, LocalDate birthDate, Objective objective) {
        this.id = generateCustomerId(allCustomers);
        this.name = name;
        this.birthDate = birthDate;
        this.objective = objective;
        this.trainingSessions = new ArrayList();
    }

    private int generateCustomerId(ArrayList allCustomers) {
        return allCustomers.stream()
                .mapToInt(c -> ((Customer) c).getId())
                .max()
                .orElse(0) + 1;
    }   

    public void addTraining(Object training) {
        trainingSessions.add(training);
    }

    public boolean removeTrainingById(int trainingId) {
        return trainingSessions.removeIf(t -> ((Training) t).getId() == trainingId);
    }

    public boolean isEnrolled() {
        return !trainingSessions.isEmpty();
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Objective getObjective() {
        return objective;
    }

    public ArrayList getTrainingSessions() {
        return trainingSessions;
    }

    public String getSummary() {
        return "Cliente: " + name + ", idade: " + getAge() + " anos, objetivo: " + objective.getDescricao();
    }

    public String toString() {
        String result = "Cliente:\n" +
                "ID: " + id + "\n" +
                "Nome: " + name + "\n" +
                "Idade: " + getAge() + " anos\n" +
                "Nascimento: " + birthDate + "\n" +
                "Objetivo: " + objective.getDescricao() + "\n" +
                "Treinos:\n\n";

        for (Object t : trainingSessions) {
            Training training = (Training) t;
            result += "Resumo: " + training.getSummary() + "\n\n";
        }

        return result;
    }
}