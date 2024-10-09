package restart.mc.splitwise.models;

public class User {
    private final String id, firstName, lastName, email, imageUrl;
    public User(String id, String firstName, String lastName, String email, String imageUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
    }
}
