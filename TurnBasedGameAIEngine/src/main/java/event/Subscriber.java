package event;

import java.util.function.Function;

public class Subscriber {
    Function<Event, Void> function;

    public Subscriber(Function<Event, Void> function) {
        this.function = function;
    }
}
