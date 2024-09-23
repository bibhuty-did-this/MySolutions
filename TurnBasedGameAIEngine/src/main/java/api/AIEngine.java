package api;

import boards.Board;
import boards.TicTacToeBoard;
import game.Cell;
import strategy.Strategy;
import strategy.StrategyFactory;
import user.Player;

public class AIEngine {

    public StrategyFactory strategyFactory = new StrategyFactory();

    public Cell suggestMove(Player player, Board board) {
        if(board instanceof TicTacToeBoard){
            TicTacToeBoard board1=(TicTacToeBoard) board;
            Strategy strategy = strategyFactory.getStrategy(board1, player);
            Cell suggestion=strategy.getOptimalMove(board1, player);
            if(suggestion!=null) return suggestion;
            throw new IllegalStateException();
        }else {
            throw new IllegalArgumentException();
        }
    }

}
