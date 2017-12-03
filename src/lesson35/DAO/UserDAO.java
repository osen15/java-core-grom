package lesson35.DAO;

import lesson35.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserDAO {


    private ValidateFileDb validateFile = new ValidateFileDb();

    public User registerUser(User user) throws Exception {
        validateFile.validate("C:/UserDB.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:/UserDB.txt", true))) {

            bw.append(user.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }
        return user;
    }


    public ArrayList<User> readFromFile() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        Files.lines(Paths.get("C:/UserDB.txt"), StandardCharsets.UTF_8).forEach(line -> users.add(User.stringToUser(line)));
        return users;
    }
}

