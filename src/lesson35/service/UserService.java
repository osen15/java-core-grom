package lesson35.service;

import lesson35.DAO.UserDAO;
import lesson35.model.User;
import lesson35.userType.UserType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    private boolean online;

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
            System.out.println("Enter a password");
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
        if (!isOnline()) {
            throw new Exception("Other user is online");
        }
        for (User user : userDAO.readFromFile()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                online = false;
                System.out.println(user.toString() + ": is login");
                System.out.println("online: " + online);
                return;
            }
        }
        System.out.println("User with this name does not exist");
    }




    private long generateID() {
        return (long) (Math.random() * 2147483647);
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
