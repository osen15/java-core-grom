package lesson14.FinalHomeWork;


import java.util.Arrays;

public class Controller {
        private UserRepository userRepository;
        public  UserRepository getInstanceUser() {
            if (userRepository == null)
                userRepository = new UserRepository();
            return userRepository;
    }



        private BookRepository bookRepository;

        public BookRepository getInstanceBook() {
            if (bookRepository == null)
                bookRepository = new BookRepository();

            return bookRepository;
        }


    public void addLibrarian(long userId, User user, String pass) {
        if (getInstanceUser().checkAndTypeOfUser(userId) && getInstanceUser().login(userId, pass)) {
            getInstanceUser().registerUser(user);
            System.out.println("OK");

        } else System.out.println("ERROR");

    }


    public void viewLibrarian(long adminId, long libralianId, String pass) {
        if (getInstanceUser().checkAndTypeOfUser(adminId) && getInstanceUser().login(adminId, pass)) {
            getInstanceUser().checkAndTypeOfUser(libralianId);
            System.out.println("OK");
        } else System.out.println("ERROR");
    }

    public void deleteLibrarian(long adminId, long libralianId, String pass) {
        if (getInstanceUser().checkAndTypeOfUser(adminId) && getInstanceUser().login(adminId, pass)) {
            for (User user : getInstanceUser().getUsers()) {
                if (user != null && user.getTypeOfUser() == TypeOfUser.LIBRARIAN) {
                    getInstanceUser().delete(libralianId);
                    System.out.println("OK");
                } else System.out.println("ERROR");
            }
        }
    }

    public void addBook(long librarianId, Book book, String pass) {
        if (getInstanceUser().checkAndTypeOfUser(librarianId) && getInstanceUser().login(librarianId, pass)) {
            getInstanceBook().addBook(book);
            System.out.println("OK");

        } else System.out.println("ERROR");
    }


    public void viewBook(long librarianId, long bookId, String pass) {
        if (getInstanceUser().checkAndTypeOfUser(librarianId) && getInstanceUser().login(librarianId, pass)) {
            getInstanceBook().findById(bookId);
            System.out.println("OK");

        } else System.out.println("ERROR");
    }

    public void issuedBook(long librarianId, long id, String pass) {
        if (getInstanceUser().checkAndTypeOfUser(librarianId) && getInstanceUser().login(librarianId, pass)) {
            getInstanceBook().issuedBook(id);
            System.out.println("OK");
        } else System.out.println("ERROR");

    }

    public void allIssuedBooks(long librarianId, String pass) {
        if (getInstanceUser().checkAndTypeOfUser(librarianId) && getInstanceUser().login(librarianId, pass)) {
            getInstanceBook().viewIssuedBooks();
            System.out.println("OK");

        }else System.out.println("ERROR");


    }

}





























