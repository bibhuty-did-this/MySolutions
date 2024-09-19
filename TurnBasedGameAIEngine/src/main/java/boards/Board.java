package boards;

import game.Move;

public interface Board {

    void move(Move move);
    Board copy();
}
