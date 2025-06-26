package Task_3;

import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Library() {
        addSampleData();
    }

    private void addSampleData() {
        books.add(new Book("The Alchemist", "Paulo Coelho"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        users.add(new User("Anil Kumar"));
        users.add(new User("Dimple Patel"));

        System.out.println("Sample data loaded: 4 books, 2 users.");
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. View Available Books");
            System.out.println("4. View Issued Books");
            System.out.println("5. Add User");
            System.out.println("6. View All Users");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> viewAllBooks();
                    case 3 -> viewAvailableBooks();
                    case 4 -> viewIssuedBooks();
                    case 5 -> addUser();
                    case 6 -> viewAllUsers();
                    case 7 -> issueBook();
                    case 8 -> returnBook();
                    case 9 -> System.out.println("Exiting Library System...");
                    default -> System.out.println("Please choose between 1 to 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 9);
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        books.add(new Book(title, author));
        System.out.println("Book added successfully.");
    }

    private void viewAllBooks() {
        System.out.println("\nAll Books:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private void viewAvailableBooks() {
        System.out.println("\nAvailable Books:");
        boolean found = false;
        for (Book b : books) {
            if (!b.isIssued()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books.");
        }
    }

    private void viewIssuedBooks() {
        System.out.println("\nIssued Books:");
        boolean found = false;
        for (Book b : books) {
            if (b.isIssued()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No issued books.");
        }
    }

    private void addUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        users.add(new User(name));
        System.out.println("User added successfully.");
    }

    private void viewAllUsers() {
        System.out.println("\nAll Users:");
        for (User u : users) {
            System.out.println(u);
        }
    }

    private void issueBook() {
        viewAvailableBooks();
        System.out.print("Enter Book ID to issue: ");
        int bookId = scanner.nextInt();

        viewAllUsers();
        System.out.print("Enter User ID to issue to: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (user == null) {
            System.out.println("User not found.");
        } else if (book.isIssued()) {
            System.out.println("Book is already issued.");
        } else {
            book.setIssued(true);
            System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName());
        }
    }

    private void returnBook() {
        viewIssuedBooks();
        System.out.print("Enter Book ID to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isIssued()) {
            System.out.println("Book is not issued.");
        } else {
            book.setIssued(false);
            System.out.println("Book '" + book.getTitle() + "' returned successfully.");
        }
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private User findUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.showMenu();
    }
}
