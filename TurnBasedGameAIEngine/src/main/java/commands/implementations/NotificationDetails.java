package commands.implementations;

import game.User;

public class NotificationDetails {
    User user;
    String message;

    public NotificationDetails(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
