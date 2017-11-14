package lesson33.homeWork;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadFileByConsolePath {


    public void readFileByConsolePath() throws Exception {
        ReadFileByConsolePath readFileByConsolePath = new ReadFileByConsolePath();

        System.out.println("Please, enter file path to read:");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();

        readFileByConsolePath.readFile(text);

        br.close();


    }

    public void readFile(String path) {
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

}
