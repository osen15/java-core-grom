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

    public void addLibrarian(long adminId, User user, String pass) {
        if (userRepository.checkAndTypeOfUser(adminId)) {
            userRepository.login(adminId, pass);
            userRepository.addUser(user);
            System.out.println(Arrays.deepToString(userRepository.getUsers()));
        } else System.out.println(" ");
    }


    public void viewLibrarian(long adminId, long libralianId, String pass) {
        if (userRepository.checkAndTypeOfUser(adminId)) {
            userRepository.login(adminId, pass);
            userRepository.checkAndTypeOfUser(libralianId);
            System.out.println("OK");
        } else System.out.println(" ");
    }

    public void deleteLibrarian(long adminId, long libralianId, String pass) {
        if (userRepository.checkAndTypeOfUser(adminId)) {
            userRepository.login(adminId, pass);
            userRepository.delete(libralianId);
            System.out.println(Arrays.deepToString(userRepository.getUsers()));


        } else System.out.println(" ");
    }

    public void addBook(long librarianId, Book book, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId)) {
            userRepository.login(librarianId, pass);
            bookRepository.addBook(book);
            System.out.println(Arrays.deepToString(bookRepository.getBooks()));

        } else System.out.println(" ");
    }


    public void viewBook(long librarianId, long bookId, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId)) {
            userRepository.login(librarianId, pass);
            bookRepository.findById(bookId);
            System.out.println("OK");

        } else System.out.println("  ");
    }

    public void issuedBook(long librarianId, long id, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId)) {
            userRepository.login(librarianId, pass);
            bookRepository.issuedBook(id);
            System.out.println("OK");
        } else System.out.println("  ");

    }

    public void allIssuedBooks(long librarianId, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId)) {
            userRepository.login(librarianId, pass);
            bookRepository.viewIssuedBooks();


        }


    }

}





























