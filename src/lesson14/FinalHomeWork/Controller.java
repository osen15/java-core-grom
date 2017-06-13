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

    public void addLibrarian(long adminId, User user) {
        for (User admin : userRepository.getUsers()) {
            if (admin != null && TypeOfUser.ADMIN == admin.getTypeOfUser()) {
                userRepository.login(adminId);
                userRepository.addUser(user);
                System.out.println(Arrays.deepToString(userRepository.getUsers()));
            } else System.out.println(" ");
        }
    }

    public void viewLibrarian(long adminId, long libralianId) {
        for (User admin : userRepository.getUsers()) {
            if (admin != null && TypeOfUser.ADMIN == admin.getTypeOfUser()) {
                userRepository.login(adminId);
                userRepository.findById(libralianId);
                System.out.println("OK");
            } else System.out.println(" ");
        }
    }


    public void deleteLibrarian(long adminId, long libralianId) {
        for (User admin : userRepository.getUsers()) {
            if (admin != null && TypeOfUser.ADMIN == admin.getTypeOfUser()) {
                userRepository.login(adminId);
                userRepository.delete(libralianId);
                System.out.println(Arrays.deepToString(userRepository.getUsers()));


            } else System.out.println(" ");
        }
    }

    public void addBook(long librarianId, Book book) {
        for (User librarian : userRepository.getUsers()) {
            if (librarian != null && TypeOfUser.LIBRARIAN == librarian.getTypeOfUser()) {
                userRepository.login(librarianId);
                bookRepository.addBook(book);
                System.out.println(Arrays.deepToString(bookRepository.getBooks()));
                break;


            } else System.out.println(" ");
        }
    }

    public void viewBook(long librarianId, long bookId) {
        for (User librarian : userRepository.getUsers()) {
            if (librarian != null && TypeOfUser.LIBRARIAN == librarian.getTypeOfUser()) {
                userRepository.login(librarianId);
                System.out.println("OK");
                break;
            } else System.out.println("  ");

        }
    }

    public void issuedBook(long librarianId, long id) {
        for (User librarian : userRepository.getUsers()) {
            if (librarian != null && TypeOfUser.LIBRARIAN == librarian.getTypeOfUser()) {
                userRepository.login(librarianId);
                bookRepository.issuedBook(id);
                System.out.println("OK");
                break;
            } else System.out.println("  ");

        }
    }

    public void allIssuedBooks(long librarianId) {
        for (User librarian : userRepository.getUsers()) {
            if (librarian != null && TypeOfUser.LIBRARIAN == librarian.getTypeOfUser()) {
                userRepository.login(librarianId);
                bookRepository.viewIssuedBooks();


            }


        }

    }
}




























