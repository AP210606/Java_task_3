package Task_3;

public class User {
    private int id;
    private String name;

    private static int nextUserId = 1;

    public User(String name) {
        this.id = nextUserId++;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User ID: " + id + ", Name: '" + name + "'";
    }
}