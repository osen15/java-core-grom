package lesson14.HomeWork;


import java.util.Arrays;
import java.util.Date;

public class Controller {
    UserRepository userRepository = new UserRepository();
    BookRepository bookRepository = new BookRepository();


    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getController() {
        return Controller.controller;
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

    public void addBook(User librarian, Book nullBook, Book addBook) {
        if (loggedIn(librarian, librarian.getId(), librarian.getPassword())) {
            nullBook = addBook;
            System.out.println(nullBook);
        } else System.err.println("помилка");
    }

    public void delBook(User librarian, Book book, long id) {
        if (loggedIn(librarian, librarian.getId(), librarian.getPassword()) && book.getBookId() == id) {
            book = null;
            System.out.println(book);
        } else System.err.println("   ");

    }

    public void viewBook(User librarian, Book book, long id) {
        if (loggedIn(librarian, librarian.getId(), librarian.getPassword()) && book.getBookId() == id) {
            System.out.println(book);
        } else System.err.println(" ");
    }

    public void issuedBook(User librarian, Book book) {
        if (loggedIn(librarian, librarian.getId(), librarian.getPassword()))
            System.out.println(book.isIssue());
        else System.err.println("   ");
    }


    public void vievIssuedBooks(User librarian) {
        if (loggedIn(librarian, librarian.getId(), librarian.getPassword())) {
            for (Book book : bookRepository.getBooks()) {
                if (book != null && book.isIssue()) {
                    System.out.println(book);
                }

            }
            System.err.println(" Немає ");
        }


    }

    public void getAllBooks(User librarian) {
        if (loggedIn(librarian, librarian.getId(), librarian.getPassword())) {
            System.out.println(Arrays.deepToString(bookRepository.getBooks()));
        }
        else System.err.println("неправильний id  чи пароль");

    }
}