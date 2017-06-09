package lesson14.HomeWork;


import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        User user = null;
        User user1 = new User("R","S", 1234,"123",new Date());
        Controller.getController().regUser(user, user1);




    }
}
