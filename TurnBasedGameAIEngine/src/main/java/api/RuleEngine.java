package api;

import boards.TicTacToeBoard;
import game.Board;
import game.GameState;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RuleEngine {
    public GameState getState(Board board){
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard tBoard = (TicTacToeBoard) board;

            // Rows
            GameState rowWin = outerTraversal(tBoard::getSymbol);
            if (rowWin.isOver()) return rowWin;

            // Col
            GameState colWin = outerTraversal((i, j)->tBoard.getSymbol(j,i));
            if (colWin.isOver()) return colWin;

            // Diag
            GameState diagonalWin = findDiagonalStreak(i->tBoard.getSymbol(i,i));
            if (diagonalWin.isOver()) return diagonalWin;

            // Rev Diag
            GameState reverseDiagonalWin = findDiagonalStreak(i->tBoard.getSymbol(i,2-i));
            if (reverseDiagonalWin.isOver()) return reverseDiagonalWin;

            int countOfFilledCells=0;
            for(int i=0;i<3;++i){
                for(int j=0;j<3;++j){
                    if(tBoard.getSymbol(i,j)!=null){
                        ++countOfFilledCells;
                    }
                }
            }
            if(countOfFilledCells==9){
                return new GameState(true, "-");
            }else{
                return new GameState(false, "-");
            }
        }else{
            return new GameState(false, "-");
        }
    }

    private GameState findDiagonalStreak(Function<Integer, String> diagonal) {
        return traverse(diagonal);
    }

    private GameState outerTraversal(BiFunction<Integer, Integer, String> next) {
        GameState result=new GameState(false, "-");
        for (int i = 0; i < 3; ++i) {
            final int ii = i;
            GameState traversal = traverse(j->next.apply(ii, j));
            if (traversal.isOver()){
                result = traversal;
                break;
            }
        }
        return result;
    }

    private static GameState traverse(Function<Integer, String> traversal) {
        GameState result=new GameState(false, "-");
        boolean possibleStreak = true;
        for (int j = 0; j < 3; ++j) {
            if (Objects.isNull(traversal.apply(j)) || !Objects.equals(traversal.apply(0), traversal.apply(j))) {
                possibleStreak = false;
                break;
            }
        }
        if (possibleStreak) {
            result = new GameState(true, traversal.apply(0));
        }
        return result;
    }
}
