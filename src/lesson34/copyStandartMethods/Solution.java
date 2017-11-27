package lesson34.copyStandartMethods;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Solution {


    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToPath, true))) {

            bw.append(readFromFile(fileFromPath));

        } catch (IOException e) {
            System.err.println("Can't write to file: " + fileToPath);
        }
    }

    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        try {
            FileUtils.writeLines(new File(fileToPath), FileUtils.readLines(new File(fileFromPath), "UTF-8"), true);

        } catch (IOException e) {
            System.err.println("Can't write to file: " + fileToPath);
        }
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

    private void validate(String fileFromPath, String fileToPath) throws Exception {
        if (fileFromPath == null) {
            throw new Exception("Path can't be null");
        }
        if (fileToPath == null) {
            throw new Exception("Path can't be null");
        }
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileFromPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " doesn't exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " doesn't exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File: " + fileFrom.getName() + " doesn't have permissions to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File: " + fileTo.getName() + " doesn't have permissions to be written");
        }
    }
}









