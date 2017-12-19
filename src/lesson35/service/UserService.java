package lesson35.service;

import lesson35.DAO.UserDAO;
import lesson35.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    private static boolean online;

    public User registerUser(User user) throws Exception {
       if (checkUser(user.getId()))
           throw  new Exception("user: " + user.getId() + "already exists");

        return userDAO.registerUser(user);
    }


    public void login(String userName, String password) throws Exception {
        if (isOnline()) {
            throw new Exception("Other user is online");
        }
        for (User user : UserDAO.getAll()) {
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
        for (User user : UserDAO.getAll()) {
            if (user.getId() == id) {
                return user;
            }
        }

        throw new Exception("User with this " + id + " not found");
    }


    public static boolean checkUser(long id) throws Exception {
        for (User user : UserDAO.getAll()) {
            if (user.getId() == id) {
                return true;
            }
        }

       return false;
    }


    public static boolean isOnline() {
        return online = false;
    }

    public void setOnline(boolean online) {
        UserService.online = online;
    }


}


