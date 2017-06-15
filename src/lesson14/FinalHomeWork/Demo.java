package lesson14.FinalHomeWork;


import java.util.Arrays;


public class Demo {
    public static void main(String[] args) {
        User admin = new User("A","C", 1001, "123",false, TypeOfUser.ADMIN);
        User librarian = new User("Q", "W", 1005,"123", false, TypeOfUser.LIBRARIAN);
        Book book = new Book("W",1234, 1111,"W","R",null);


        // login
        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.login(1001));


        //logout
        userRepository.logout(admin);

        // Адмін залогінився і додав бібліотекаря
        Controller.getController().addLibrarian(1001,librarian);



        // Адмін залогінився і шукає бібліотекаря по id
        Controller.getController().viewLibrarian(1001,1002);


        // Адмін залогінився і видаляє бібліотекаря
       // Controller.getController().deleteLibrarian(1001,1002);

        // Бібліотекар залогінився і додав книгу в список
        Controller.getController().addBook(1002, book );


        // Бібліотекар залогінився і шукае книгу по id, якщо є то true
        Controller.getController().viewBook(1002, 1111);

        // Бібліотекар залогінився  видав книжку
        Controller.getController().issuedBook(1002, 1111);


        // Бібліотекар залогінився і виводить всі видані книжки
        Controller.getController().allIssuedBooks(1002);


        // Return books
      //  System.out.println(Arrays.deepToString(Controller.getController().bookRepository.getBooks()));











    }

}
