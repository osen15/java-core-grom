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
        if (userRepository.checkAndTypeOfUser(adminId) == true && userRepository.login(adminId, pass) == true) {
            userRepository.addUser(user);
            System.out.println("OK");

        } else System.out.println("NO");

    }


    public void viewLibrarian(long adminId, long libralianId, String pass) {
        if (userRepository.checkAndTypeOfUser(adminId) == true && userRepository.login(adminId, pass) == true) {
            userRepository.checkAndTypeOfUser(libralianId);
            System.out.println("OK");
        } else System.out.println("NO");
    }

    public void deleteLibrarian(long adminId, long libralianId, String pass) {
        if (userRepository.checkAndTypeOfUser(adminId) == true && userRepository.login(adminId, pass) == true) {
            for (User user : userRepository.getUsers()) {
                if (user != null && user.getTypeOfUser() == TypeOfUser.LIBRARIAN) {
                    userRepository.delete(libralianId);
                    System.out.println(Arrays.deepToString(userRepository.getUsers()));
                } else System.out.println(" ");
            }
        }
    }

    public void addBook(long librarianId, Book book, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId) == true && userRepository.login(librarianId, pass) == true) {
            bookRepository.addBook(book);
            System.out.println(Arrays.deepToString(bookRepository.getBooks()));

        } else System.out.println("NO");
    }


    public void viewBook(long librarianId, long bookId, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId) == true && userRepository.login(librarianId, pass) == true &&
            bookRepository.findById(bookId) == true){
            System.out.println("OK");

        } else System.out.println(" NO ");
    }

    public void issuedBook(long librarianId, long id, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId) == true && userRepository.login(librarianId, pass) == true) {
            bookRepository.issuedBook(id);
            System.out.println("OK");
        } else System.out.println(" NO ");

    }

    public void allIssuedBooks(long librarianId, String pass) {
        if (userRepository.checkAndTypeOfUser(librarianId) == true && userRepository.login(librarianId, pass) == true) {
            bookRepository.viewIssuedBooks();


        }


    }

}





























