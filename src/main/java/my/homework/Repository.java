package my.homework;

import com.google.gson.Gson;

import java.io.*;

public class Repository {
    public static <T> void save(T obj) {
        try (FileOutputStream file = new FileOutputStream(obj.getClass().getName())) {
            ObjectOutputStream os = new ObjectOutputStream(file);
            os.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> void saveToJson(T obj) {
        try (FileWriter fw = new FileWriter(obj.getClass().getName()+".json")) {
            fw.write(new Gson().toJson(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object read(String name) {
        try (FileInputStream file = new FileInputStream(name)) {
            ObjectInputStream os = new ObjectInputStream(file);
            return os.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object readFromJson(String name, String className) {
        try {
            name += ".json";
            return new Gson().fromJson(new FileReader(name), Class.forName(className));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
