package lesson35.DAO.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOldContentInToFile {
    public static void writeOldContentToFile(StringBuffer stringBuffer, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {

            bw.append(stringBuffer.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }

    }

}

