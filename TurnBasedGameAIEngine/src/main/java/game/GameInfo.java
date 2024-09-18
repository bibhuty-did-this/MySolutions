package game;

import user.Player;

public class GameInfo {
    private boolean isOver;
    private String winner;
    private Player player;
    private boolean hasFork;
    private int noOfMoves;

    public GameInfo(boolean isOver, String winner, Player player, boolean hasFork, int noOfMoves) {
        this.isOver = isOver;
        this.winner = winner;
        this.player = player;
        this.hasFork = hasFork;
        this.noOfMoves = noOfMoves;
    }
}

