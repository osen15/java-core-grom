package lesson34.transferFileContent;

import java.io.*;

public class Solution {

    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
        cleanContentInFile(fileFromPath);
    }


    private boolean fileNewOrNot(String path) {
        return new File(path).length() == 0;
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
            System.err.println("Reading from fileDB " + fileFromPath + " failed");

        }
        return res;

    }
    private void writeToFile(String fileToPath, StringBuffer contentToWrite) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToPath, true))) {

            bw.append(contentToWrite);
            bw.newLine();

        } catch (IOException e) {
            System.err.println("Can't write to fileDB");

        }
    }


    private void validate(String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileFromPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFromPath + " doesn't exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileToPath + " doesn't exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFromPath + "doesn't have permissions to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileToPath + "doesn't have permissions to be written");
        }
    }

    private void cleanContentInFile(String pathFromFile) {
        try (BufferedWriter res = new BufferedWriter(new FileWriter(pathFromFile))) {
            res.write("");

        } catch (IOException e) {
            System.err.println("Can not clean a fileDB: " + pathFromFile);
        }
    }
}
