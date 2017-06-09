package lesson14.HomeWork;


public class Book {
    private String bookName;
    private int yearOfPublication;
    private long bookId;
    private String typeOfBook;
    private String author;
    private boolean issue;


    public String getBookName() {
        return bookName;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public long getBookId() {
        return bookId;
    }

    public String getTypeOfBook() {
        return typeOfBook;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssue() {
        return issue;
    }

    public Book(String bookName, int yearOfPublication, long bookId, String typeOfBook, String author, boolean issue) {
        this.bookName = bookName;
        this.yearOfPublication = yearOfPublication;
        this.bookId = bookId;
        this.typeOfBook = typeOfBook;
        this.author = author;
        this.issue = issue;


    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", bookId=" + bookId +
                ", typeOfBook='" + typeOfBook + '\'' +
                ", author='" + author + '\'' +
                ", issue=" + issue +
                '}';
    }
}