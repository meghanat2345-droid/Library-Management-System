
package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private HashMap<Integer, Student> issuedBooks = new HashMap<>();

    // 1. Add Book
    public void addBook(Book book) {

        for (Book b : books) {
            if (b.getBookId() == book.getBookId()) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        books.add(book);
        saveBooks();

        System.out.println("Book added successfully!");
    }

    // 2. View All Books
    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            b.displayBookDetails();
        }
    }

    // 3. Search Book
    public void searchBook(int id) {

        for (Book b : books) {
            if (b.getBookId() == id) {
                System.out.println("Book Found!");
                b.displayBookDetails();
                return;
            }
        }

        System.out.println("Book not found!");
    }

    // 4. Issue Book
    public void issueBook(int bookId, Student student) {

        for (Book b : books) {

            if (b.getBookId() == bookId) {

                if (b.isAvailable()) {

                    b.setAvailable(false);
                    issuedBooks.put(bookId, student);

                    saveBooks();

                    System.out.println("Book issued successfully!");

                } else {
                    System.out.println("Book is already issued!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // 5. Return Book
    public void returnBook(int bookId) {

        for (Book b : books) {

            if (b.getBookId() == bookId) {

                if (!b.isAvailable()) {

                    b.setAvailable(true);
                    issuedBooks.remove(bookId);

                    saveBooks();

                    System.out.println("Book returned successfully!");

                } else {
                    System.out.println("This book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // 6. View Issued Books
    public void viewIssuedBooks() {

        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
            return;
        }

        for (Book b : books) {

            if (issuedBooks.containsKey(b.getBookId())) {

                System.out.println("Book ID: " + b.getBookId());
                System.out.println("Book Name: " + b.getBookName());

                Student s = issuedBooks.get(b.getBookId());

                System.out.println("Student ID: " + s.getStudentId());
                System.out.println("Student Name: " + s.getStudentName());

                System.out.println("-------------------------");
            }
        }
    }

    // 7. Save All Books and Issue Details
    private void saveBooks() {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter("books.txt"))) {

            for (Book b : books) {

                Student student = issuedBooks.get(b.getBookId());

                int studentId = -1;
                String studentName = "None";

                if (student != null) {
                    studentId = student.getStudentId();
                    studentName = student.getStudentName();
                }

                writer.write(
                    b.getBookId() + "|" +
                    b.getBookName() + "|" +
                    b.getAuthorName() + "|" +
                    b.isAvailable() + "|" +
                    studentId + "|" +
                    studentName
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving books!");
            e.printStackTrace();
        }
    }

    // 8. Load Books and Issue Details
    public void loadBooks() {

        books.clear();
        issuedBooks.clear();

        File file = new File("books.txt");

        if (!file.exists()) {
            System.out.println("No previous records found. Starting fresh.");
            return;
        }

        try (BufferedReader reader =
                new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length != 6) {
                    System.out.println("Skipping invalid record: " + line);
                    continue;
                }

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String author = data[2];
                boolean available = Boolean.parseBoolean(data[3]);

                Book book = new Book(id, name, author);
                book.setAvailable(available);

                books.add(book);

                if (!available) {

                    int studentId = Integer.parseInt(data[4]);
                    String studentName = data[5];

                    Student student =
                            new Student(studentId, studentName);

                    issuedBooks.put(id, student);
                }
            }

            System.out.println("Records loaded successfully!");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading records!");
            e.printStackTrace();
        }
    }



    // 2. View All Books
    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            b.displayBookDetails();
        }
    }

    // 3. Search Book
    public void searchBook(int id) {

        for (Book b : books) {

            if (b.getBookId() == id) {
                System.out.println("Book Found!");
                b.displayBookDetails();
                return;
            }
        }

        System.out.println("Book not found!");
    }

    // 4. Issue Book
    public void issueBook(int bookId, Student student) {

        for (Book b : books) {

            if (b.getBookId() == bookId) {

                if (b.isAvailable()) {

                    b.setAvailable(false);

                    issuedBooks.put(bookId, student);

                    System.out.println("Book issued successfully!");

                } else {

                    System.out.println("Book is already issued!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // 5. Return Book
    public void returnBook(int bookId) {

        for (Book b : books) {

            if (b.getBookId() == bookId) {

                if (!b.isAvailable()) {

                    b.setAvailable(true);

                    issuedBooks.remove(bookId);

                    System.out.println("Book returned successfully!");

                } else {

                    System.out.println("This book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // 6. View Issued Books
    public void viewIssuedBooks() {

        if (issuedBooks.isEmpty()) {

            System.out.println("No books are currently issued.");
            return;
        }

        for (Book b : books) {

            if (issuedBooks.containsKey(b.getBookId())) {

                System.out.println("Book Name: " + b.getBookName());

                Student s = issuedBooks.get(b.getBookId());

                System.out.println("Student ID: " + s.getStudentId());

                System.out.println("Student Name: " + s.getStudentName());

                System.out.println("-------------------------");
            }
        }
    }
}
