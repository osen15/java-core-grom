package lesson14.FinalHomeWork;


import java.util.Arrays;

public class Controller {
    private UserRepository userRepository = new UserRepository();
    private BookRepository bookRepository = new BookRepository();


    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getController() {
        return Controller.controller;
    }

    public void addLibrarian(long userId, User user, String pass) {
        if (userRepository.checkAndTypeOfUser(userId) && userRepository.login(userId, pass)) {
            userRepository.registerUser(user);
            System.out.println("OK");

        } else System.out.println("ERROR");

    }


    public void viewLibrarian(long adminId, long libralianId, String pass) {
        if (userRepository.checkAndTypeOfUser(adminId) && userRepository.login(adminId, pass)) {
            userRepository.checkAndTypeOfUser(libralianId);
            System.out.println("OK");
        } else System.out.println("ERROR");
    }

    public void deleteLibrarian(long adminId, long libralianId, String pass) {
        if (userRepository.checkAndTypeOfUser(adminId) && userRepository.login(adminId, pass)) {
            for (User user : userRepository.getUsers()) {
                if (user != null && user.getTypeOfUser() == TypeOfUser.LIBRARIAN) {
                    userRepository.delete(libralianId);
                    System.out.println("OK");
                } else System.out.println("ERROR");
            }
        }
    }

    public void addBook(long librarianId, Book book, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId) && userRepository.login(librarianId, pass)) {
            bookRepository.addBook(book);
            System.out.println("OK");

        } else System.out.println("ERROR");
    }


    public void viewBook(long librarianId, long bookId, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId) && userRepository.login(librarianId, pass)) {
            bookRepository.findById(bookId);
            System.out.println("OK");

        } else System.out.println("ERROR");
    }

    public void issuedBook(long librarianId, long id, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId) && userRepository.login(librarianId, pass)) {
            bookRepository.issuedBook(id);
            System.out.println("OK");
        } else System.out.println("ERROR");

    }

    public void allIssuedBooks(long librarianId, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId) && userRepository.login(librarianId, pass)) {
            bookRepository.viewIssuedBooks();
            System.out.println("OK");

        }else System.out.println("ERROR");


    }

}





























