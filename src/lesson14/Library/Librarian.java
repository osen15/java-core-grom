package lesson14.Library;


public class Librarian extends User {
    private Book[] books = new Book[10];


    public Librarian(String name, String lastName, long id, String password) {
        super(name, lastName, id, password);

    }

    public boolean logInLibrarian(Librarian librarian, long id, String password) {
        return (librarian.getId() == id && librarian.getPassword() == password);
    }

    public boolean logOutLibrarian(Librarian librarian) {
        return (logInLibrarian(librarian, librarian.getId(), getPassword())) ? false : true;
    }

    public Book[] addBook(Librarian librarian, Book book1) {
        int index = 0;
        if (librarian.logInLibrarian(librarian, librarian.getId(), librarian.getPassword())) {
            for (Book book : books) {
                if (book == null)
                    book = book1;
                books[index] = book;
                break;
            }
            index++;
        }
        return books;
    }

    public Book[] deleteBook(Librarian librarian) {
        int index = 0;
        if (librarian.logInLibrarian(librarian, librarian.getId(), librarian.getPassword())) {
            for (Book book : books) {
                if (book != null && librarian.findBookById(book.getBookId()) == true) {
                    book = null;
                    books[index] = book;
                }
                index++;
            }
        }
        return books;
    }

    public void viewBook(Librarian librarian) {
        if (librarian.logInLibrarian(librarian, librarian.getId(), librarian.getPassword())) {
            for (Book book : books) {
                if (book != null && librarian.findBookById(book.getBookId()))
                    System.out.println(book);
                else System.err.println("такого id немає в базі");
                break;
            }
        }
    }

    public void issuedBook(Librarian librarian, long id) {
        if (librarian.logInLibrarian(librarian, librarian.getId(), librarian.getPassword())) {
            for (Book book : books) {
                if (book != null && librarian.findBookById(id) && book.isIssue()) {
                    System.out.println("Kнига видана користувачу");
                    break;

                } else System.out.println(":-) ");
                break;
            }


        }
    }

    public Book[] viewIssuedBooks(Librarian librarian) {
        int index = 0;
        Book[] issuedBooks = new Book[5];
        if (librarian.logInLibrarian(librarian, librarian.getId(), librarian.getPassword())) {
            for (Book book : books) {
                if (book != null && book.isIssue()) {
                    issuedBooks[index] = book;
                    break;
                }
            }
            index++;

        }
        return issuedBooks;
    }

    public Book[] getAllBooks(Librarian librarian) {
        return (librarian.logInLibrarian(librarian, librarian.getId(), librarian.getPassword())) ? books : null;
    }

    private boolean findBookById(long id) {
        for (Book book : books) {
            if (book.getBookId() == id)
                return true;
        }
        return false;
    }


}

























