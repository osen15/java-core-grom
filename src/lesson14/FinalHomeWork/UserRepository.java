package lesson14.FinalHomeWork;


import java.util.Date;

public class UserRepository {
    private User user1 = new User("A", "Q", 1001, "123", false, TypeOfUser.ADMIN);
    private User user2 = new User("A", "Q", 1002, "123", false, TypeOfUser.LIBRARIAN);
    private User user3 = new User("A", "Q", 1003, "123", false, null);
    private User user4 = null;
    private User user5 = null;
    private User[] users = {user1, user2, user3, user4, user5};

    private static UserRepository userRepository = new UserRepository();

    private UserRepository() {
    }

    public static   UserRepository getUserRepository() {
        return UserRepository.userRepository  ;
    }


    public void delete(long id) {

        int index = 0;
        for (User user : users) {
            if (user != null && checkUser(id)) {
                users[index] = null;

            }
            index++;
        }
    }

    public boolean registerUser(User user) {
        int index = 0;
        checkArray();
        for (User user1 : users) {
            if (user1 == null && user != null) {
                users[index] = user;
                return true;

            }
            index++;

        }

        return false;
    }


    public boolean login(long id, String pass) {
        if (checkLogin(id)) {
            for (User user : getUsers()) {
                if (user != null && user.getPassword() == pass) {
                    user.setLogin(true);
                    return user.isLogin();
                }
            }

        }
        return false;

    }


    public void logout(User user) {
        if (checkLogin(user.getId())) {
            System.err.println("");
        } else user.setLogin(false);
        System.out.println(user.isLogin());
    }

    public boolean checkAndTypeOfUser(long id) {
        for (User user : getUsers()) {
            if (user != null && user.getId() == id && user.getTypeOfUser() == TypeOfUser.ADMIN)
                return true;
            if (user != null && user.getId() == id && user.getTypeOfUser() == TypeOfUser.ADMIN)
                return true;
        }
        return false;

    }

    public User[] getUsers() {
        return users;
    }

    private User[] checkArray() {
        int index = 0;
        for (User user : users) {
            if (user != null)
                index++;
        }
        if (index == users.length - 1)
            return null;

        else
            return users;
    }

    public boolean checkUser(long id) {
        for (User user : getUsers()) {
            if (user != null && user.getId() == id)
                return true;
        }
        return false;
    }

    private boolean checkLogin(long id) {
        if (checkUser(id)) {
            for (User user : getUsers()) {
                if (user.isLogin() == false)
                    return true;
            }

        }
        return false;


    }
}








