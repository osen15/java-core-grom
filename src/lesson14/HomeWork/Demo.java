package lesson14.HomeWork;


import java.util.Arrays;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        User user = null;
        User user1 = new User("R","S", 1234,"123",new Date());
        Admin admin = new Admin("Q", "D", 12345,"123", new Date());
        Librarian librarian = new Librarian("S", "B", 321, "123", new Date());
        Book book = null;
        Book book1 = new Book("A",2000,1000,"G","C", true);
        // Регіструється юзер
        Controller.getController().regUser(user, user1);

        // Видаляється юзер
        Controller.getController().delUser(user1, 1234);


        // Логіниться Адмін чи бібліотекар
        System.out.println(Controller.getController().loggedIn(user1, 1234, "123"));


        // Логаут
        System.out.println(Controller.getController().loggedOut(user1));


        //Амін додає бібліотекаря
        System.out.println(Arrays.deepToString(Controller.getController().addLibrarian(admin, librarian)));


        //Адмін видаляє бібліотекаря зі списку юзерів
        System.out.println(Arrays.deepToString(Controller.getController().delLibrarian(admin, librarian, librarian.getId())));


        //Адмін дивиться на цікавого йому бібліотекаря в списку юзерів
        Controller.getController().viewLibrarian(admin, librarian, librarian.getId());

        // Бібліотекар логіниться додає книгу
        Controller.getController().addBook(librarian,book,book1);

        // Бібліотекар логіниться видаляє книгу
        Controller.getController().delBook(librarian,book1,1000);


        // Бібліотекар логіниться і дивиться книгу
        Controller.getController().viewBook(librarian,book1,1000);


        // Бібліотекар логіниться і дивиться чи дана книга видана, якщо true, то видана
        Controller.getController().issuedBook(librarian, book1);

        // Бібліотекар логіниться і дивиться всі видані книги
        Controller.getController().vievIssuedBooks(librarian);


        // Бібліотекар логіниться виводить весь масив книг
        Controller.getController().getAllBooks(librarian);








    }
}
