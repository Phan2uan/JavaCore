package QuanLyLaiXe;

import java.io.*;
import java.util.List;

public class FileUtil {
    public static <T> void write(String file, List<T> data) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
            o.writeObject(data);
        } catch (Exception e) {
            System.out.println("Lỗi ghi file!");
        }
    }

    public static <T> List<T> read(String file) {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) o.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}