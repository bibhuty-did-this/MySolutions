package api;

import boards.TicTacToeBoard;
import game.*;
import user.Player;

import java.util.HashMap;
import java.util.Map;

public class RuleEngine {

    Map<String, RuleSet> ruleMap = new HashMap<>();

    public RuleEngine() {
        ruleMap.put(TicTacToeBoard.class.getName(), TicTacToeBoard.getRules());
    }

    public GameState getState(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard tBoard = (TicTacToeBoard) board;
            RuleSet<TicTacToeBoard> rules = ruleMap.get(TicTacToeBoard.class.getName());
            for (Rule<TicTacToeBoard> rule : rules) {
                GameState gameState = rule.condition.apply(tBoard);
                if (gameState.isOver()) {
                    return new GameState(true, gameState.getWinner());
                }
            }
            return new GameState(false, "-");
        } else {
            throw new IllegalArgumentException();
        }
    }

    public GameInfo getInfo(Board board) {
        if (board instanceof TicTacToeBoard) {
            GameState gameState = getState(board);
            String[] players = new String[]{"X", "O"};
            for (int index = 0; index < 2; ++index) {
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        Board b = board.copy();
                        Player player = new Player(players[index]);
                        b.move(new Move(new Cell(i, j), player));
                        boolean canStillWin = false;
                        for (int k = 0; k < 3; ++k) {
                            for (int l = 0; l < 3; ++l) {
                                Board b1 = b.copy();
                                b1.move(new Move(new Cell(k, l), player.flip()));
                                if (getState(b1).getWinner().equals(player.flip().symbol())) {
                                    canStillWin = true;
                                    break;
                                }
                            }
                            if (canStillWin) {
                                break;
                            }
                        }
                        if (canStillWin) {
                            return new GameInfoBuilder()
                                    .isOver(gameState.isOver())
                                    .winner(gameState.getWinner())
                                    .hasFork(true)
                                    .player(player.flip())
                                    .build();
                        }
                    }
                }
            }
            return new GameInfoBuilder()
                    .isOver(gameState.isOver())
                    .winner(gameState.getWinner())
                    .hasFork(false)
                    .build();
        } else {
            throw new IllegalArgumentException();
        }
    }

}


