package api;

import commands.implementations.SMSCommand;
import game.User;

public class SMSService {
    private void sendSMS(User user, String message) {
    }
    public Void send(SMSCommand command){
        sendSMS(command.getUser(), command.getMessage());
        return null;
    }
}
