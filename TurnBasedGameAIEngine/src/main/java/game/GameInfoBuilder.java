package game;

import user.Player;

public class GameInfoBuilder {
    private boolean isOver;
    private String winner;
    private Player player;
    private boolean hasFork;
    private int noOfMoves;
    private Cell forkCell;

    public GameInfoBuilder player(Player player) {
        this.player = player;
        return this;
    }

    public GameInfoBuilder winner(String winner) {
        this.winner = winner;
        return this;
    }

    public GameInfoBuilder isOver(boolean isOver) {
        this.isOver = isOver;
        return this;
    }

    public GameInfoBuilder hasFork(boolean hasFork) {
        this.hasFork = hasFork;
        return this;
    }

    public GameInfoBuilder noOfMoves(int noOfMoves) {
        this.noOfMoves = noOfMoves;
        return this;
    }

    public GameInfoBuilder forkCell(Cell forkCell){
        this.forkCell = forkCell;
        return this;
    }

    public GameInfo build() {
        return new GameInfo(isOver, winner, player, hasFork, noOfMoves, forkCell);
    }
}
