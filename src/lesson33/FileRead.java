package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileRead {
    public static void main(String[] args) throws InterruptedException {


      //  readFile("C:/Test.txt");
        writeFile("C:/Test1.txt");

    }


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

    private static void writeFile(String path) throws InterruptedException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            Thread.sleep(3000);

            fileWriter = new FileWriter(path, true);

            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.append("\n");  // з нового рядка додає
            bufferedWriter.append("PPPPPPPPP");

        } catch (IOException e) {
            System.err.println("Can't write to file");

        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(fileWriter);
        }
    }
}