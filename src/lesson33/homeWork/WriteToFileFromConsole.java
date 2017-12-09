package lesson33.homeWork;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class WriteToFileFromConsole {
    public static void writeToFileFromConsole(String path) throws Exception {

        if (path == null) {
            throw new Exception("path can't be null");
        }

        checkFile(path); // перевірка шляху і чи можна записати

        PrintWriter printWriter = null;

        try {

            printWriter = new PrintWriter(new FileWriter(path, true));


            printWriter.println(writeInConsole());


        } catch (IOException e) {
            System.err.println("Writing failed");

        } finally {
            IOUtils.closeQuietly(printWriter);

        }
    }


    private static void checkFile(String path) throws Exception {

        File file;

        file = new File(path);
        if (!file.canWrite()) {

            throw new Exception("Can't write to fileDB with path " + path);
        }

        if (!file.exists()) {

            throw new Exception("File with path " + path + " not found");
        }


    }

    private static String writeInConsole() throws IOException {


        System.out.println("Enter fileDB content to write in the fileDB:");


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String text;
            StringBuilder result = new StringBuilder();

            while (!(text = bufferedReader.readLine()).equals("wr")) {
                result.append(" ").append(text);
            }
            return result.toString();

        } catch (IOException e) {
            System.err.println("Reading failed");
            return null;
        }
    }
}
