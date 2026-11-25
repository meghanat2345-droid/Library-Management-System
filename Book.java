package library;


public class Book {

    private int bookId;
    private String bookName;
    private String authorName;
    private boolean available;

    // Constructor
    public Book(int bookId, String bookName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.available = true;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Display book details
    public void displayBookDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + authorName);
        System.out.println("Status: " +
                (available ? "Available" : "Issued"));
        System.out.println("-------------------------");
    }
}
