package lesson14.FinalHomeWork;


import java.util.Arrays;


public class Demo {
    public static void main(String[] args) {
        User admin = new User("A","C", 1001, "123",TypeOfUser.ADMIN);
        User librarian = new User("Q", "W", 1005,"123",TypeOfUser.LIBRARIAN);
        Book book = new Book("W",1234, 1111,"W","R",null);


        // Адмін залогінився і додав бібліотекаря
        System.out.println(Arrays.deepToString(Controller.getController().addLibrarian(admin, TypeOfUser.ADMIN,librarian )));


        // Адмін залогінився і шукає бібліотекаря по id
        Controller.getController().viewLibrarian(admin,TypeOfUser.ADMIN, 1005);


        // Адмін залогінився і видаляє бібліотекаря
        Controller.getController().deleteLibrarian(admin, TypeOfUser.ADMIN, 1005);

        // Бібліотекар залогінився і додав книгу в список
        Controller.getController().addBook(librarian, TypeOfUser.LIBRARIAN, book );


        // Бібліотекар залогінився і шукае книгу по id, якщо є то true
        Controller.getController().viewBook(librarian, TypeOfUser.LIBRARIAN, 1111);

        // Бібліотекар залогінився  видав книжку
        Controller.getController().issuedBook(librarian, TypeOfUser.LIBRARIAN, 1111);


        // Бібліотекар залогінився і виводить всі видані книжки
        Controller.getController().allIssuedBooks(librarian,TypeOfUser.LIBRARIAN);


        // Return books
        System.out.println(Arrays.deepToString(Controller.getController().bookRepository.getBooks()));











    }

}
