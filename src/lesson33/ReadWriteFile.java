package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile  {

    public   void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File not exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }


    }

    public  void writeFile(String path, String content) throws InterruptedException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            Thread.sleep(3000);

            fileWriter = new FileWriter(path, true);

            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.append("\n");  // з нового рядка додає
            bufferedWriter.append(content);

        } catch (IOException e) {
            System.err.println("Can't write to file");

        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(fileWriter);
        }
    }
}
