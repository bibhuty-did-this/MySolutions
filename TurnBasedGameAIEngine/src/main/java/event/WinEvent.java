package event;

import game.User;

public class WinEvent extends Event{
    public WinEvent(User user) {
        super(user, null, null,null);
    }
}
