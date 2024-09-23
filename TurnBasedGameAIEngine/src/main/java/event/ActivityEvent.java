package event;

import game.User;

public class ActivityEvent extends Event {
    public ActivityEvent(User user) {
        super(user, null, null, null);

    }
}
