package controller;

import factory.TrainingFactory;
import model.*;

import java.util.ArrayList;


public class TrainingController {

    public TrainingByInternet createInternet(ArrayList allTrainings, String duration, TrainingType type, ArrayList muscleGroups, ArrayList exercises, String source) {
        return TrainingFactory.createInternetTraining(allTrainings, duration, type, muscleGroups, exercises, source);
    }

    public TrainingByInnerGym createInnerGym(ArrayList allTrainings, String duration, TrainingType type, ArrayList muscleGroups, ArrayList exercises, String instructor, String period) {
        return TrainingFactory.createInnerGymTraining(allTrainings, duration, type, muscleGroups, exercises, instructor, period);
    }

    public TrainingByPersonal createPersonal(ArrayList allTrainings, String duration, TrainingType type, ArrayList muscleGroups, ArrayList exercises, String instructor, String period) {
        return TrainingFactory.createPersonalTraining(allTrainings, duration, type, muscleGroups, exercises, instructor, period);
    }
}