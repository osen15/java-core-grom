package lesson35.DAO.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadFromFile {

    public static List<String> readFromFile(String fileName) throws Exception {
        return Files.readAllLines(Paths.get(fileName), UTF_8);

    }


}
