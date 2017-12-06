package lesson35.DAO;

import lesson35.DAO.utils.ValidateFileDb;
import lesson35.model.User;
import lesson35.userType.UserType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserDAO {
private int lineCounter = 1;

    public User registerUser(User user) throws Exception {
        ValidateFileDb.validate("UserDB.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("UserDB.txt", true))) {

            bw.append(user.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }
        return user;
    }


    public ArrayList<User> readFromFile() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        Files.lines(Paths.get("UserDB.txt"), StandardCharsets.UTF_8).forEach(line -> {
            try {
                users.add(userMapper(line));
            } catch (Exception e) {
                lineCounter = 1;
                e.printStackTrace();
            }
        });
        lineCounter = 1;
        return users;

    }
    public  User userMapper(String lineUser) throws  Exception {
        String[] arrayUser = lineUser.split("\\, ");
        if (arrayUser.length != 5){
            throw  new  Exception("error in file: " + lineCounter);
        }
        lineCounter++;
        return new User(Long.parseLong(arrayUser[0]), arrayUser[1], arrayUser[2], arrayUser[3], UserType.valueOf(arrayUser[4]));
    }
}

