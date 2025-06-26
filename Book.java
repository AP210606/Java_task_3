package Task_3;
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    private static int nextBookId = 1;

    public Book(String title, String author) {
        this.id = nextBookId++;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() { // Getter for the boolean field
        return isIssued;
    }

    // Setter for issue status
    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "Book ID: " + id +
               ", Title: '" + title + "'" +
               ", Author: '" + author + "'" +
               ", Status: " + (isIssued ? "Issued" : "Available");
    }
}