package QuanLyLaiXe;

import java.io.*;
import java.util.List;

public class FileUtil {
    public static <T> void write(String file, List<T> data) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(data);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> read(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        }
    }
}