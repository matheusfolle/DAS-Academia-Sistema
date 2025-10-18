package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Exercise;

public class ExerciseDAO {
    private static final String path = "src/data/Exercise";

    public static void save(List<Exercise> exercises) throws IOException {
        File dir = new File(path);
        dir.mkdirs();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/Exercises.ser"))) {
            oos.writeObject(exercises);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Exercise> load() throws IOException, ClassNotFoundException {
        File archive = new File(path + "/Exercises.ser");
        if (!archive.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archive))) {
            return (List<Exercise>) ois.readObject();
        }
    }
}