package lesson14.HomeWork;


import java.util.Date;

public class Controller {
    UserRepository userRepository = new UserRepository();


    private static Controller controller;

    private Controller() {
    }

    public static  Controller getController() {
        if (getController() == null)
            controller = new Controller();
        return controller;
    }


    public void regUser(User nullUser, User user1) {

        if (nullUser == null)
            nullUser = user1;
        System.out.println((nullUser));
    }

    public void delUser(User user, long id) {
        if (user.getId() == id) {
            user = null;
            System.out.println(user);
        } else System.err.println("wrong");
    }

    public boolean loggedIn(User user, long id, String password) {
        if (user.getId() == id && user.getPassword() == password)
            return true;
        return false;
    }

    public boolean loggedOut(User user) {
        if (loggedIn(user, user.getId(), user.getPassword())) ;
        return false;
    }

    public User[] addLibrarian(User admin, User librarian) {
        int index = 0;
        if (loggedIn(admin, admin.getId(), admin.getPassword())) {
            for (User user : userRepository.getUsers()) {
                if (user == null) {
                    userRepository.getUsers()[index] = librarian;
                    break;
                }
            }
            index++;
        }
        return userRepository.getUsers();


    }

    public User[] delLibrarian(User admin, User librarian, long id) {
        int index = 0;
        if (loggedIn(admin, admin.getId(), admin.getPassword())) {
            for (User user : userRepository.getUsers()) {
                if (user != null && librarian.getId() == id) {
                    userRepository.getUsers()[index] = null;
                    break;
                }
            }
            index++;
        }
        return userRepository.getUsers();

    }

    public void viewLibrarian(User admin, User librarian, long id) {
        if (loggedIn(admin, admin.getId(), admin.getPassword())) {
            for (User user : userRepository.getUsers()) {
                if (user != null && librarian.getId() == id)
                    System.out.println(librarian);

                else System.err.println("Немає");
                break;
            }


        }


    }



}