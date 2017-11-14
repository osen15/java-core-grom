package lesson33.homeWork;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;

public class WriteToFileFromConsole {
    public void writeToFileFromConsole(String path) throws Exception {
        WriteToFileFromConsole writeToFileFromConsole = new WriteToFileFromConsole();

        writeToFileFromConsole.checkFile(path); // перевірка шляху і чи можна записати

        PrintWriter printWriter = null;

        try {

            printWriter = new PrintWriter(new FileWriter(path, true));


            for (String str : writeInConsole()) {  // виводить кожний введений рядок у файл з нового рядка
                printWriter.println(str);


            }

        } catch (IOException e) {
            System.err.println("Can't write to file");

        } finally {
            IOUtils.closeQuietly(printWriter);

        }
    }



    private void checkFile(String path) throws Exception {

        File file;

        file = new File("C:/Test.txt");
        if (!file.canWrite()) {

            throw new Exception("Can't write to file with path " + path);
        }

        if (!file.exists()) {

            throw new Exception("File with path " + path + " not found");
        }


    }




    private ArrayList<String> writeInConsole() throws IOException {
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Enter file content to write in the file:");

        String text;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {


            while (!(text = bufferedReader.readLine()).equals("write")) {
                list.add(text);
            }

        } catch (IOException e) {
            System.err.println("error");
        }
        return list;

    }
}
