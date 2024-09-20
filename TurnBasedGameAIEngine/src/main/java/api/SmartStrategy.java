package api;

import boards.TicTacToeBoard;
import game.Cell;
import game.Move;
import user.Player;

import java.util.Objects;

public class SmartStrategy extends Strategy{
    private RuleEngine ruleEngine=new RuleEngine();
    private BasicStrategy basicStrategy = new BasicStrategy();
    @Override
    public Cell getOptimalMove(TicTacToeBoard board, Player player) {
        Cell best = offense(player, board);
        if (Objects.nonNull(best)) return best;
        best = defense(player, board);
        if (Objects.nonNull(best)) return best;
        return basicStrategy.getOptimalMove(board,player);
    }
    private Cell offense(Player player, TicTacToeBoard board) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board.getSymbol(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player);
                    TicTacToeBoard boardCopy = board.move(move);
                    if (ruleEngine.getState(boardCopy).isOver()) {
                        return move.getCell();
                    }
                }
            }
        }
        return null;
    }

    private Cell defense(Player player, TicTacToeBoard board) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board.getSymbol(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player.flip());
                    TicTacToeBoard boardCopy = board.move(move);
                    if (ruleEngine.getState(boardCopy).isOver()) {
                        return new Cell(i, j);
                    }
                }
            }
        }
        return null;
    }

}
