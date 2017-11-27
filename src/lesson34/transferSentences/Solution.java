package lesson34.transferSentences;

import java.io.*;
import java.util.Arrays;

public class Solution {

    public void transferSentences(String pathFromFile, String pathToFile, String word) throws Exception {
        if (word == null) {
            throw new Exception("word can not be null");
        }
        validate(pathFromFile, pathToFile);
        writeSentences(pathToFile, resultToFiles(word,pathFromFile)[0] , true); // записуємо в файл нульовий елемент правильних значень по його шляху
        writeSentences(pathFromFile, resultToFiles(word,pathFromFile)[1] , false); // перезаписуэмо файл неправильними значеннями.


    }

    private StringBuffer readFromFile(String fileFromPath) throws Exception {  // читаємо з файлу
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

    private StringBuffer[] resultToFiles(String word, String pathFromFile) throws Exception {

        StringBuffer bufferTo = new StringBuffer();   // баффер для правильних значень
        StringBuffer bufferFrom = new StringBuffer(); // баффер для неправильних значень

        String[] content = readFromFile(pathFromFile).toString().split("\\."); // створюється масив прочитаного контенту
                                                                                      // розбивається по крапці
        for (String string : content) {
            if (string != null && string.length() > 10 && string.contains(word))      // логіка для правильних слів
                bufferTo.append(string).append(".");                                  // додаємо до баффера правильні слова
            else bufferFrom.append(string).append(".");                               // інакше додаємо до bufferFtom неправильні
        }
        StringBuffer[] res = new StringBuffer[]{bufferTo, bufferFrom};                // створюється результуючий масив бафферів на два елемента

        System.out.println(Arrays.toString(res));
        return res;
    }

    private void writeSentences(String path, StringBuffer content, boolean append) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            bw.append(content);

        } catch (IOException e) {
            System.err.println("Can not written: " + path);
        }
    }
}