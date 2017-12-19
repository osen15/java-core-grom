package lesson35.DAO;

import lesson35.DAO.utils.ReadFromFile;
import lesson35.DAO.utils.ValidateFileDb;
import lesson35.DAO.utils.WriteToFile;
import lesson35.model.User;
import lesson35.userType.UserType;

import java.util.ArrayList;

public class UserDAO {
    private static int lineCounter = 1;
    private static String UserDB = "C://UserDB.txt";

    public User registerUser(User user) throws Exception {
        ValidateFileDb.validate(UserDB);
        return WriteToFile.WriteToFile(user, UserDB);
    }


    public static ArrayList<User> getAll() throws Exception {
        ValidateFileDb.validate(UserDB);
        ArrayList<User> users = new ArrayList<>();

        for (String line : ReadFromFile.readFromFile(UserDB)) {
            users.add(userMapper(line));
        }

        return users;
    }

    public static User userMapper(String line) throws Exception {
        String[] arrayUser = line.split("\\, ");
        if (arrayUser.length != 5) {
            throw new Exception("error in file: " + lineCounter);
        }
        lineCounter++;
        return new User(Long.parseLong(arrayUser[0]), arrayUser[1], arrayUser[2], arrayUser[3], UserType.valueOf(arrayUser[4]));
    }
}

