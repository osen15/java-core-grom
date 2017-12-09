package lesson35.demo;

import lesson35.DAO.UserDAO;
import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.service.UserService;

public class DemoUser {
    public static void main(String[] args)throws Exception {
User user = new User();
        UserService userService = new UserService();
        UserDAO userDAO = new UserDAO();
        UserController userController = new UserController();

        userService.registerUser(user);
     //   userService.login("Oleg", "1234");
     //   userController.logout();
     //   System.out.println(userDAO.readFromFile());


    }
}
