package lesson14.FinalHomeWork;


import java.util.Arrays;


public class Demo {
    private static UserRepository userRepository;
    public static   UserRepository getInstanceUser() {
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }



    private static BookRepository bookRepository;

    public static BookRepository getInstanceBook() {
        if (bookRepository == null)
            bookRepository = new BookRepository();

        return bookRepository;
    }



    public static void main(String[] args) {





        User admin = new User("A","C", 1001, "123",false, TypeOfUser.ADMIN);
        User librarian = new User("Q", "W", 1005,"123", false, TypeOfUser.LIBRARIAN);
        Book book = new Book("W",1234, 1111,"W","R",null);
        Controller controller = new Controller();


        // Адмін залогінився і додав бібліотекаря
        controller.addLibrarian(1002,librarian, "123");




        // Адмін залогінився і шукає бібліотекаря по id
        controller.viewLibrarian(1001,1002, "123");
//

        // Адмін залогінився і видаляє бібліотекаря
       controller.deleteLibrarian(1001,1002, null);

        // Бібліотекар залогінився і додав книгу в список
       controller.addBook(100, null, "123" );


        // Бібліотекар залогінився і шукае книгу по id, якщо є то true
       controller.viewBook(1002, 1002, "123");

        // Бібліотекар залогінився  видав книжку
        controller.issuedBook(1002, 1111, "123");


        // Бібліотекар залогінився і виводить всі видані книжки
        controller.allIssuedBooks(1002,"123");


        // Return books
        System.out.println(Arrays.deepToString(getInstanceBook().getBooks()));


       System.out.println(getInstanceUser().checkUser(1005));

        System.out.println(getInstanceUser().checkAndTypeOfUser(1001));

        System.out.println(getInstanceUser().registerUser(librarian));

        System.out.println(Arrays.deepToString(getInstanceBook().addBook(book)));

        System.out.println(getInstanceBook().findById(1001));
    }

}
