package commands.implementations;

import event.Event;
import game.User;

public class SMSCommand {
    NotificationDetails details;
    String link;
    String templateId;
    String template;

    public SMSCommand(Event event) {
        this.details = new NotificationDetails(event.getUser(),event.getMessage());
    }

    public SMSCommand(User user, String message, String link, String templateId, String template) {
        this.details = new NotificationDetails(user,message);
        this.link = link;
        this.templateId = templateId;
        this.template = template;
    }

    public String getLink() {
        return link;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getTemplate() {
        return template;
    }

    public NotificationDetails getDetails() {
        return details;
    }

    public User getUser() {
        return details.getUser();
    }

    public String getMessage() {
        return details.getMessage();
    }
}
