package api;

import commands.implementations.EmailCommand;
import game.User;

public class EmailService {
    private void sendEmail(User user, String message) {

    }
    public Void send(EmailCommand command){
        sendEmail(command.getUser(), command.getMessage());
        return null;
    }
}
