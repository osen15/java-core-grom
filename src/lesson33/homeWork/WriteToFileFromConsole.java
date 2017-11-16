package lesson33.homeWork;

import org.apache.commons.io.IOUtils;

import java.io.*;

public  class WriteToFileFromConsole {
    public static void writeToFileFromConsole(String path) throws Exception {


        checkFile(path); // перевірка шляху і чи можна записати

        PrintWriter printWriter = null;

        try {

            printWriter = new PrintWriter(new FileWriter(path, true));


            printWriter.println(writeInConsole());


        } catch (IOException e) {
            System.err.println("Can't write to file");

        } finally {
            IOUtils.closeQuietly(printWriter);

        }
    }


    private static void checkFile(String path) throws Exception {

        File file;

        file = new File(path);
        if (!file.canWrite()) {

            throw new Exception("Can't write to file with path " + path);
        }

        if (!file.exists()) {

            throw new Exception("File with path " + path + " not found");
        }


    }


    private static String writeInConsole() throws IOException {


        System.out.println("Enter file content to write in the file:");

        String result = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String text;
            result = "";

            while (!(text = bufferedReader.readLine()).equals("wr")) {
                result = result + " " + text;

            }

        } catch (IOException e) {
            System.err.println("error");
        }
        return result;

    }
}
