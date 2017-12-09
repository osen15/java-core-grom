package lesson34;

import java.io.*;

public class ReadWriteFile {

    public void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }


        } catch (FileNotFoundException e) {
            System.err.println("File not exist");
        } catch (IOException e) {
            System.err.println("Reading from fileDB " + path + " failed");

        }

    }

    public void writeFile(String path, String content) throws InterruptedException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            Thread.sleep(3000);

            bw.append("\n");  // з нового рядка додає
            bw.append(content);

        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }


    }
}
