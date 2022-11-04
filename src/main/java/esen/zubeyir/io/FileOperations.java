package esen.zubeyir.io;

import java.io.*;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 02/12/2022 - 00:20
 */

//This class is created for file operations.
//We use this class for saving results to a file.
//Singleton instance created calling operations.
//There are only 2 methods in it: readFile and writeFile.
public class FileOperations {

    private static FileOperations instance = null;

    private FileOperations() {
    }

    public static FileOperations getInstance() {
        if (instance == null)
            instance = new FileOperations();

        return instance;
    }

    //This method reads file if exists.
    //Returns object.
    public Object readFile(String file) {
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)){
            return objectIn.readObject();
        } catch (Exception ex) {
            return null;
        }
    }

    //This method creates file if file doesn't exist.
    //Then writes data object to file
    //Used Serializable interface as data type.
    public void writeFile(Serializable data, String file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(data);
        } catch (IOException ex) {
            System.err.println("Data couldn't write to file!");
        }
    }
}
