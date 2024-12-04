public class Book {

    private int id;
    private String title;
    private boolean available;

    public Book(int id, String title) throws Exception {
        if (!isValidId(id)) {
            throw new Exception("Invalid book ID. ID must be between 100 and 999.");
        }
        this.id = id;
        this.title = title;
        this.available = true; // The book is available by default
    }

    public boolean isValidId(int id) {
        return id >= 100 && id <= 999;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
        } else {
            throw new IllegalStateException("The book is already borrowed.");
        }
    }

    public void returnBook() {
        if (!available) {
            available = true;
        } else {
            throw new IllegalStateException("The book was not borrowed.");
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}