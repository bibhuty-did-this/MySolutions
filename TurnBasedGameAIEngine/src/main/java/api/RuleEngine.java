package api;

import boards.Board;
import boards.CellBoard;
import boards.TicTacToeBoard;
import boards.TicTacToeBoard.Symbol;
import game.*;
import placements.DefensivePlacement;
import placements.OffensivePlacement;
import user.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class RuleEngine {

    Map<String, RuleSet> ruleMap = new HashMap<>();

    public RuleEngine() {
        ruleMap.put(TicTacToeBoard.class.getName(), TicTacToeBoard.getRules());
    }

    public GameState getState(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard tBoard = (TicTacToeBoard) board;
            RuleSet<TicTacToeBoard> rules = ruleMap.get(TicTacToeBoard.class.getName());
            for (Rule rule : rules) {
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

    public GameInfo getInfo(CellBoard board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard=(TicTacToeBoard)board;
            GameState gameState = getState(board);
            for (Symbol symbol: Symbol.values()) {
                Player player = new Player(symbol.marker());
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        if (Objects.nonNull(board.getSymbol(i, j))) {
                            Cell forkCell = new Cell(i,j);
                            TicTacToeBoard b = ticTacToeBoard.move(new Move(forkCell, player));
                            DefensivePlacement defense=DefensivePlacement.get();
                            Optional<Cell> defensiveCell=defense.place(b, player.flip());
                            if(defensiveCell.isPresent()){
                                OffensivePlacement offense=OffensivePlacement.get();
                                Optional<Cell> offensiveCell=offense.place(b, player);
                                if(offensiveCell.isPresent()){
                                    return new GameInfoBuilder()
                                            .isOver(gameState.isOver())
                                            .winner(gameState.getWinner())
                                            .hasFork(true)
                                            .player(player.flip())
                                            .forkCell(forkCell)
                                            .build();
                                }
                            }

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


