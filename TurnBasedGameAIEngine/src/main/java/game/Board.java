package game;

public interface Board {
    void move(Move move);

    Board copy();
}
