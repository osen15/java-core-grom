package lesson14.FinalHomeWork;


import java.util.Arrays;

public class Controller {
    UserRepository userRepository = new UserRepository();
    BookRepository bookRepository = new BookRepository();

    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getController() {
        return Controller.controller;
    }

    public User[] addLibrarian(User admin, TypeOfUser typeOfUser, User librarian) {
        if (admin.getTypeOfUser() == typeOfUser.ADMIN) {
            userRepository.login(admin.getId(), admin.getPassword());
            userRepository.addUser(librarian);
            return userRepository.getUsers();
        }
        return null;
    }

    public void viewLibrarian(User admin, TypeOfUser typeOfUser, long id) {
        if (admin.getTypeOfUser() == typeOfUser.ADMIN) {
            userRepository.login(admin.getId(), admin.getPassword());

            for (User user : userRepository.getUsers()) {
                if (user != null && userRepository.findById(user.getId()) == id && user.getTypeOfUser() == TypeOfUser.LIBRARIAN)
                    System.out.println(user);
            }
        } else System.out.println(" ");
    }

    public void deleteLibrarian(User admin, TypeOfUser typeOfUser, long id) {
        if (admin.getTypeOfUser() == typeOfUser.ADMIN) {
            userRepository.login(admin.getId(), admin.getPassword());
            for (User user : userRepository.getUsers()) {
                userRepository.delete(id);
                System.out.println(Arrays.deepToString(userRepository.getUsers()));
                break;
            }
        } else System.out.println(" ");
    }

    public void addBook(User librarian, TypeOfUser typeOfUser, Book book) {
        if (librarian.getTypeOfUser() == typeOfUser.LIBRARIAN) {
            userRepository.login(librarian.getId(), librarian.getPassword());
            bookRepository.addBook(book);
            System.out.println(Arrays.deepToString(bookRepository.getBooks()));


        } else System.out.println(" ");
    }

    public void viewBook(User librarian, TypeOfUser typeOfUser, long id) {
        if (librarian.getTypeOfUser() == typeOfUser.LIBRARIAN) {
            userRepository.login(librarian.getId(), librarian.getPassword());
            System.out.println(bookRepository.findById(id));
        } else System.out.println("  ");


    }

    public void issuedBook(User librarian, TypeOfUser typeOfUser, long id) {
        if (librarian.getTypeOfUser() == typeOfUser.LIBRARIAN) {
            userRepository.login(librarian.getId(), librarian.getPassword());
            bookRepository.issuedBook(id);
            System.out.println(bookRepository.findById(id));
        } else System.out.println("  ");


    }

    public void allIssuedBooks(User librarian, TypeOfUser typeOfUser) {
        if (librarian.getTypeOfUser() == typeOfUser.LIBRARIAN) {
            userRepository.login(librarian.getId(), librarian.getPassword());
            bookRepository.viewIssuedBooks();


        }


    }

}




























