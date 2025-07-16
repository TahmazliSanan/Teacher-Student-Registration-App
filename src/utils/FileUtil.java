package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static <T> void writeObjectToFile(String filename, List<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> readObjectFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
