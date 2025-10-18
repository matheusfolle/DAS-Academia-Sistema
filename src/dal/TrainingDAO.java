package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Training;

public class TrainingDAO {
    private static final String path = "src/data/Training";

    public static void save(List<Training> trainings) throws IOException {
        File dir = new File(path);
        dir.mkdirs();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/Trainings.ser"))) {
            oos.writeObject(trainings);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Training> load() throws IOException, ClassNotFoundException {
        File archive = new File(path + "/Trainings.ser");
        if (!archive.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archive))) {
            return (List<Training>) ois.readObject();
        }
    }
}