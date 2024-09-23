package commands.implementations;

import event.Event;
import game.User;

public class EmailCommand {
    NotificationDetails details;
    String link;
    String templateId;
    String template;

    public EmailCommand(NotificationDetails details, String link, String templateId, String template) {
        this.details = details;
        this.link = link;
        this.templateId = templateId;
        this.template = template;
    }

    public EmailCommand(User user, String message, String link, String templateId, String template) {
        this.details = new NotificationDetails(user,message);
        this.link = link;
        this.templateId = templateId;
        this.template = template;
    }

    public EmailCommand(Event event) {
        this.details = new NotificationDetails(event.getUser(), event.getMessage());
        this.link=event.getLink();
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
