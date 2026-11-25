# 📚 Library Management System

## Project Overview

The Library Management System is a console-based Java application developed to simplify basic library operations. It allows users to manage books, search for books, issue books to students, and return books.

The application uses Java file handling to store and retrieve book records, ensuring that the data is preserved even after the program is closed and restarted.

## Features

- **Add Books:** Add new books with Book ID, Book Name, and Author Name.
- **View Books:** Display all books available in the library.
- **Search Books:** Search for a particular book using its Book ID.
- **Issue Books:** Issue available books to students.
- **Return Books:** Return previously issued books.
- **View Issued Books:** Display issued book details along with student information.
- **Duplicate ID Validation:** Prevent adding books with an existing Book ID.
- **Data Persistence:** Save and load book records using file handling.

## Technologies Used

- Java
- Eclipse IDE
- ArrayList
- HashMap
- File Handling
- BufferedReader
- BufferedWriter

## Project Structure

| File | Description |
|---|---|
| Book.java | Stores book details and availability status. |
| Student.java | Stores student ID and student name. |
| Library.java | Handles library operations and file management. |
| Main.java | Provides the menu-driven application interface. |
| books.txt | Stores book and issued-student records. |

## Concepts Implemented

- Object-Oriented Programming (OOP)
- Classes and Objects
- Encapsulation
- Constructors
- Getters and Setters
- ArrayList and HashMap
- Loops and Conditional Statements
- Exception Handling
- File Handling

## How to Run the Project

1. Download or clone this repository.
2. Open Eclipse IDE.
3. Create or open a Java project.
4. Place the Java source files inside the `src/library` package.
5. Keep `books.txt` in the project working directory.
6. Open `Main.java`.
7. Run the application.

## Application Workflow

1. The application loads previously saved book records when it starts.
2. The user selects an operation from the menu.
3. The selected operation is performed through the Library class.
4. Book availability and student details are updated when books are issued or returned.
5. Updated records are saved to `books.txt`.

## Future Enhancements

- Add book issue and return dates.
- Implement a fine calculation system.
- Add a graphical user interface (GUI).
- Integrate a database for better data management.

---

**Developed as a Java project to practice Object-Oriented Programming and File Handling.**
