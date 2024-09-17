package game;

import user.Player;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player) {
        this.cell=cell;
        this.player=player;
    }

    public Cell getCell() {
        return cell;
    }

    public Player getPlayer() {
        return player;
    }
}
