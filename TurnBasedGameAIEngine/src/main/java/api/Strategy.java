package api;

import boards.TicTacToeBoard;
import game.Cell;
import user.Player;

public abstract class Strategy {
    public abstract Cell getOptimalMove(TicTacToeBoard board, Player player);
}
