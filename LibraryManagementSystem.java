import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean issued;
    String issuedTo;
    int daysLate;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.issuedTo = "";
        this.daysLate = 0;
    }

    void display() {
        System.out.println("------------------------------------");
        System.out.println("Book ID     : " + id);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);

        if (issued) {
            System.out.println("Status      : Issued");
            System.out.println("Issued To   : " + issuedTo);
        } else {
            System.out.println("Status      : Available");
        }
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add some default books
    static void addDefaultBooks() {
        books.add(new Book(101, "Java Programming", "James Gosling"));
        books.add(new Book(102, "Python Programming", "Guido van Rossum"));
        books.add(new Book(103, "C Programming", "Dennis Ritchie"));
        books.add(new Book(104, "Data Structures", "Seymour Lipschutz"));
        books.add(new Book(105, "Computer Networks", "Andrew Tanenbaum"));
    }

    // Add new book
    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("\nBook added successfully!");
    }

    // Display all books
    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("\nNo books available.");
            return;
        }

        System.out.println("\n========== ALL BOOKS ==========");

        for (Book b : books) {
            b.display();
        }
    }

    // Search book
    static void searchBook() {

        sc.nextLine();

        System.out.print("Enter book title or author: ");
        String search = sc.nextLine();

        boolean found = false;

        for (Book b : books) {

            if (b.title.toLowerCase().contains(search.toLowerCase())
                    || b.author.toLowerCase().contains(search.toLowerCase())) {

                b.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nBook not found.");
        }
    }

    // Issue book
    static void issueBook() {

        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {

            if (b.id == id) {

                if (b.issued) {
                    System.out.println("\nThis book is already issued.");
                    return;
                }

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                b.issued = true;
                b.issuedTo = name;

                System.out.println("\nBook issued successfully!");
                System.out.println("Book       : " + b.title);
                System.out.println("Issued To  : " + name);

                return;
            }
        }

        System.out.println("\nBook ID not found.");
    }

    // Return book
    static void returnBook() {

        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (!b.issued) {
                    System.out.println("\nThis book was not issued.");
                    return;
                }

                System.out.print("Enter number of days late: ");
                int daysLate = sc.nextInt();

                // Fine = ₹5 per late day
                int fine = daysLate * 5;

                System.out.println("\n========== RETURN DETAILS ==========");
                System.out.println("Book       : " + b.title);
                System.out.println("Issued To  : " + b.issuedTo);
                System.out.println("Late Days  : " + daysLate);
                System.out.println("Fine       : ₹" + fine);

                b.issued = false;
                b.issuedTo = "";
                b.daysLate = 0;

                System.out.println("\nBook returned successfully!");

                return;
            }
        }

        System.out.println("\nBook ID not found.");
    }

    // Remove book
    static void removeBook() {

        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (b.issued) {
                    System.out.println(
                        "\nCannot remove an issued book."
                    );
                    return;
                }

                books.remove(b);

                System.out.println(
                    "\nBook removed successfully!"
                );

                return;
            }
        }

        System.out.println("\nBook ID not found.");
    }

    // Main method
    public static void main(String[] args) {

        addDefaultBooks();

        while (true) {

            System.out.println("\n======================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    removeBook();
                    break;

                case 7:
                    System.out.println(
                        "\nThank you for using Library Management System!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println(
                        "\nInvalid choice! Please try again."
                    );
            }
        }
    }
}
