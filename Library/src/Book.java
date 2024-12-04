public class Book {

    private int id;
    private String title;
    private boolean available;  // New field to track availability

    // Constructor with ID validation and default availability
    public Book(int id, String title) throws Exception {
        if (!isValidId(id)) {
            throw new Exception("Invalid book ID. ID must be between 100 and 999.");
        }
        this.id = id;
        this.title = title;
        this.available = true;  // Default: book is available when created
    }

    // Method to validate the book ID
    public boolean isValidId(int id) {
        return id >= 100 && id <= 999;
    }

    // Method to check if the book is available
    public boolean isAvailable() {
        return available;
    }

    // Method to mark the book as borrowed
    public void borrowBook() {
        if (available) {
            available = false;
        } else {
            throw new IllegalStateException("The book is already borrowed.");
        }
    }

    // Method to mark the book as returned
    public void returnBook() {
        if (!available) {
            available = true;
        } else {
            throw new IllegalStateException("The book was not borrowed.");
        }
    }

    // Getters for id and title
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}