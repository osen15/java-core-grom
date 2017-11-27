package lesson34.copyFileContent;

import java.io.*;

public class Solution {


    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validation(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
    }


    private StringBuffer readFromFile(String fileFromPath) throws Exception {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(fileFromPath))) {
            String line;

            while ((line = br.readLine()) != null) {
                res.append(line).append("\n");

            }
            res.replace(res.length() - 1, res.length(), "");


        } catch (FileNotFoundException e) {
            System.err.println("File not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + fileFromPath + " failed");

        }
        return res;

    }

    private void writeToFile(String fileToPath, StringBuffer contentToWrite) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToPath, true))) {

            bw.append(contentToWrite);

        } catch (IOException e) {
            System.err.println("Can't write to file");

        }
    }

    private static void validation(String fileFromPath, String fileToPath) throws Exception {
        if (fileFromPath == null || fileToPath == null) {
            throw new NullPointerException("path can't be null");
        }
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " doesn't exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " doesn't exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + "doesn't have permissions to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileFrom + "doesn't have permissions to be written");
        }
    }
}
