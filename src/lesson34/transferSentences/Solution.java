package lesson34.transferSentences;

import java.io.*;
import java.util.Arrays;

public class Solution {

    public void transferSentences(String pathFromFile, String pathToFile, String word) throws Exception {

        validate(pathFromFile, pathToFile);
        StringBuffer oldContentFrom = readFromFile(pathFromFile);
        StringBuffer oldContentTo = readFromFile(pathToFile);
        try {
            resultToFiles(word, pathFromFile, pathToFile);
        } catch (IOException | NullPointerException e) {
            writeSentences(pathFromFile, oldContentFrom, false);
            writeSentences(pathToFile, oldContentTo, false);
            System.err.println("File writing is interrupted");

        }

    }

    private StringBuffer readFromFile(String fileFromPath) throws Exception {  // читаємо з файлу
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(fileFromPath))) {
            String line;

            while ((line = br.readLine()) != null) {
                res.append(line).append("\r\n");

            }
            res.replace(res.length() - 1, res.length(), "");


        } catch (FileNotFoundException e) {
            System.err.println("File not exist");
        } catch (IOException e) {
            System.err.println("Reading from fileDB " + fileFromPath + " failed");

        }
        return res;

    }

    private void validate(String fileFromPath, String fileToPath) throws Exception { // валідація
        if (fileFromPath == null || fileToPath == null) {
            throw new Exception("Path can't be null");
        }
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileFromPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFromPath + " doesn't exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileToPath + " doesn't exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File: " + fileFromPath + "doesn't have permissions to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileToPath + "doesn't have permissions to be written");
        }
    }

    private void resultToFiles(String word, String pathFromFile, String pathToFile) throws Exception {

        StringBuffer bufferTo = new StringBuffer();   // баффер для правильних значень
        StringBuffer bufferFrom = new StringBuffer(); // баффер для неправильних значень

        String[] content = readFromFile(pathFromFile).toString().split("\\."); // створюється масив прочитаного контенту
        System.out.println(Arrays.toString(content));
        // розбивається по крапці
        for (String string : content) {
            if (string != null && string.length() > 10 && string.contains(word))      // логіка для правильних слів
                bufferTo.append(string).append(".");                                  // додаємо до баффера правильні слова
            else
                bufferFrom.append(string).append(".");                               // інакше додаємо до bufferFtom неправильні
        }
        writeSentences(pathFromFile, bufferFrom, false);
        writeSentences(pathToFile, bufferTo, true);

    }

    private void writeSentences(String path, StringBuffer content, boolean append) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            bw.append(content);

        } catch (IOException e) {
            System.err.println("Can not written: " + path);
        }
    }

}