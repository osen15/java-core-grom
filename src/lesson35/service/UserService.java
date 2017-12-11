package lesson35.service;

import lesson35.DAO.UserDAO;
import lesson35.model.User;
import lesson35.userType.UserType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static lesson35.service.utils.IDGenerate.generateID;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    private static boolean online;

    public User registerUser(User user) throws Exception {
        user.setId(generateID());
        BufferedReader brName = new BufferedReader(new InputStreamReader(System.in));

        try {

            System.out.println("Enter your name: ");
            user.setUserName(brName.readLine());
        } catch (IOException e) {
            System.err.println("Can not set value name");
        } catch (NullPointerException e) {
            System.err.println("User is null");
        }

        BufferedReader brPass = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a password: ");
            user.setPassword(brPass.readLine());
        } catch (IOException e) {
            System.err.println("Can not set value password");
        }

        BufferedReader brCountry = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter your country");
            user.setCountry(brCountry.readLine());
        } catch (IOException e) {
            System.err.println("Can not set value country");
        } finally {
            brName.close();
            brPass.close();
            brCountry.close();
        }


        user.setUserType(UserType.valueOf("USER"));
        System.out.println(user.toString());

        return userDAO.registerUser(user);
    }


    public void login(String userName, String password) throws Exception {
        if (isOnline()) {
            throw new Exception("Other user is online");
        }
        for (User user : UserDAO.readFromFile()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                setOnline(true);
                System.out.println(user.toString() + ": is login");
                System.out.println("online: " + online);
                return;
            }
        }
        System.out.println("User with this name does not exist");
    }


    public static User findUserByID(long id) throws Exception {
        for (User user : UserDAO.readFromFile()) {
            if (user.getId() == id) {
                return user;
            }
        }

        throw new Exception("object with this " + id + " not found");
    }


    public static boolean isOnline() {
        return online = false;
    }

    public void setOnline(boolean online) {
        UserService.online = online;
    }


}


