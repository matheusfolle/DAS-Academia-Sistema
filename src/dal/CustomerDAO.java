package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDAO {
    private static final String path = "src/data/Customer";

    public static void save(List<Customer> customers) throws IOException {
        File dir = new File(path);
        dir.mkdirs();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/Customers.ser"))) {
            oos.writeObject(customers);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Customer> load() throws IOException, ClassNotFoundException {
        File archive = new File(path + "/Customers.ser");
        if (!archive.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archive))) {
            return (List<Customer>) ois.readObject();
        }
    }
}