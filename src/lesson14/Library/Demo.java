package lesson14.Library;


import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        Admin admin = new Admin("O", "D", 1001, "123");
        // login admin
        System.out.println(admin.logInAdmin(admin, 1001, "123"));
        // logout admin
        System.out.println(admin.logOutAdmin(admin));
        Librarian librarian = new Librarian("K", "Z", 1002, "1234");
        // add librarian
        System.out.println(Arrays.deepToString(admin.addLibrarian(admin, librarian)));
        // delete librarian
        System.out.println(Arrays.deepToString(admin.deleteLibrarian(admin, 1002)));
        // view librarian
        admin.viewLibrarian(admin,1002);
        // login librarian
        System.out.println(librarian.logInLibrarian(librarian, 1002, "1234"));
        // logout librarian
        System.out.println(librarian.logOutLibrarian(librarian));

        Book book = new Book("A",2017,1111,"Z","A",true);

        // add book
        System.out.println(Arrays.deepToString(librarian.addBook(librarian,book)));
        // delete book
        System.out.println(Arrays.deepToString(librarian.deleteBook(librarian)));

        //view book
        librarian.viewBook(librarian);

        // issued book
        librarian.issuedBook(librarian, 1111);

        // view issued books
        System.out.println(Arrays.deepToString(librarian.viewIssuedBooks(librarian)));




    }


}
