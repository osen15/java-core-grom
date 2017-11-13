package lesson33.homeWork;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class WriteToFileFromConsole {
    public void writeToFileFromConsole(String path) throws Exception {

        System.out.println("Enter file content to write in the file:");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String text = bufferedReader.readLine();

        File file;

        file = new File("C:/Test.txt");
        if (!file.canWrite()) {
            bufferedReader.close();
            throw new Exception("Can't write to file with path " + path);
        }

        if (!file.exists()) {
            bufferedReader.close();
            throw new Exception("File with path " + path + " not found");
        }

        PrintWriter printWriter = null;

        try {

            printWriter = new PrintWriter(new FileWriter(path, true));

            printWriter.println(text);

        } catch (IOException e) {
            System.err.println("Can't write to file");

        } finally {
            IOUtils.closeQuietly(printWriter);

            IOUtils.closeQuietly(bufferedReader);
        }
    }
}
