
package library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        library.loadBooks();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Issued Books");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Add Book
                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, name, author);

                    library.addBook(book);

                    break;

                // View All Books
                case 2:

                    library.viewBooks();

                    break;

                // Search Book
                case 3:

                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();

                    library.searchBook(searchId);

                    break;

                // Issue Book
                case 4:

                    System.out.print("Enter Book ID: ");
                    int issueId = sc.nextInt();

                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();

                    Student student =
                        new Student(studentId, studentName);

                    library.issueBook(issueId, student);

                    break;

                // Return Book
                case 5:

                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();

                    library.returnBook(returnId);

                    break;

                // View Issued Books
                case 6:

                    library.viewIssuedBooks();

                    break;

                // Exit
                case 7:

                    System.out.println(
                        "Thank you for using Library Management System!"
                    );

                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        } while (choice != 7);

        sc.close();
    }
}
