package factory;

import java.util.List;
import model.*;

public class TrainingFactory {

    private static int generateTrainingId(List<Training> allTrainings) {
        return allTrainings.stream()
                .mapToInt(t -> ((Training) t).getId())
                .max()
                .orElse(0) + 1;
    }

    public static TrainingByInternet createInternetTraining(List<Training> allTrainings, String duration,TrainingType type, List<MuscleGroup> muscleGroups, List<Exercise> exercises, String source) {
        int id = generateTrainingId(allTrainings);
        return new TrainingByInternet(id, duration, type, muscleGroups, exercises, source);
    }

    public static TrainingByInnerGym createInnerGymTraining(List<Training> allTrainings, String duration, TrainingType type, List<MuscleGroup> muscleGroups, List<Exercise> exercises, String instructor, String period) {
        int id = generateTrainingId(allTrainings);
        return new TrainingByInnerGym(id, duration, type, muscleGroups, exercises, instructor, period);
    }

    public static TrainingByPersonal createPersonalTraining(List<Training> allTrainings, String duration,TrainingType type, List<MuscleGroup> muscleGroups, List<Exercise> exercises, String instructor, String period) {
        int id = generateTrainingId(allTrainings);
        return new TrainingByPersonal(id, duration, type, muscleGroups, exercises, instructor, period);
    }
}