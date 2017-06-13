package lesson14.FinalHomeWork;


public class BookRepository {
    private Book book1 = new Book("Q", 1200, 1001, "R", "D", null);
    private Book book2 = new Book("Q", 1200, 1002, "R", "D", null);
    private Book book3 = new Book("Q", 1200, 1003, "R", "D", "Видана");
    private Book book4 = new Book("Q", 1200, 1004, "R", "D", "Видана");
    private Book book5 = new Book("Q", 1200, 1005, "R", "D", null);
    private Book book6 = null;
    private Book book7 = null;

    private Book[] books = {book1, book2, book3, book4, book5, book6, book7};

    public Book[] getBooks() {
        return books;
    }

    public Book[] addBook(Book book) {
        int index = 0;
        findById(book.getBookId());
        checkArray();
        for (Book book1 : books) {
            if (book1 == null) {
                books[index] = book;
                break;
            }
            index++;
        }

        return books;


    }


    public void issuedBook(long id) {
        for (Book book : books) {
            if (findById(id) == findById(book.getBookId()) && book.getIssue() == null) {
                book.setIssue("Видана");
                System.out.println(book.getIssue());
                break;
            } else System.out.println("");

        }

    }


    public void viewIssuedBooks() {
        for (Book book : books) {
            if (book != null && book.getIssue() == "Видана")
                System.out.println(book);
            break;
        }
    }


    public boolean findById(long bookId) {
        for (Book book : books) {
            if (book != null && book.getBookId() == bookId)
                return true;

        }
        return false;
    }


    private Book[] checkArray() {
        int index = 0;
        for (Book book : books) {
            if (book != null)
                index++;
        }
        if (index == books.length - 1)
            return null;

        else
            return books;
    }


}
