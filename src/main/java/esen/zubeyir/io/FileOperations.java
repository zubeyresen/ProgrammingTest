package esen.zubeyir.io;

import java.io.*;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 02/12/2022 - 00:20
 */
public class FileOperations {

    private static FileOperations instance = null;

    private FileOperations() {
    }

    public static FileOperations getInstance() {
        if (instance == null)
            instance = new FileOperations();

        return instance;
    }

    public Object readFile(String file) {
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)){
            return objectIn.readObject();
        } catch (Exception ex) {
            return null;
        }
    }

    public void writeFile(Serializable data, String file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(data);
        } catch (IOException ex) {
            System.err.println("Data couldn't write to file!");
        }
    }
}
