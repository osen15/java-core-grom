package lesson35.DAO;

import lesson35.DAO.utils.ValidateFileDb;
import lesson35.DAO.utils.WriteToFile;
import lesson35.model.User;
import lesson35.userType.UserType;

import java.io.*;
import java.util.ArrayList;

public class UserDAO {
    private int lineCounter = 1;
    private String UserDB = "C://UserDB.txt";

    public User registerUser(User user) throws Exception {
        ValidateFileDb.validate(UserDB);
        return WriteToFile.WriteToFile(user, UserDB);
    }



    public ArrayList<User> readFromFile() throws Exception {
        ArrayList<User> users = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(UserDB))) {
            String line;

            while ((line = br.readLine()) != null) {
                users.add(userMapper(line));

            }

        } catch (FileNotFoundException e) {
            lineCounter = 0;
            System.err.println("File not exist");
        } catch (IOException e) {
            lineCounter = 0;
            System.err.println("Reading from fileDB " + UserDB + " failed");

        }
        lineCounter = 0;
        return users;

    }

    public User userMapper(String lineUser) throws Exception {
        String[] arrayUser = lineUser.split("\\, ");
        if (arrayUser.length != 5) {
            throw new Exception("error in file: " + lineCounter);
        }
        lineCounter++;
        return new User(Long.parseLong(arrayUser[0]), arrayUser[1], arrayUser[2], arrayUser[3], UserType.valueOf(arrayUser[4]));
    }
}

