package lesson35.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    public void saveToFile(String fileToPath, StringBuffer contentToWrite) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToPath, true))) {

            bw.append(contentToWrite);
            bw.newLine();

        } catch (IOException e) {
            System.err.println("Can't write to fileDB");

        }
    }
}
