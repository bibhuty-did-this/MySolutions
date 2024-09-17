package api;

import boards.TicTacToeBoard;
import game.Board;
import game.Cell;
import game.Move;
import user.Player;

public class AIEngine {
    public Move suggestMove(Player computer, Board board) {
        if(board instanceof TicTacToeBoard){
            TicTacToeBoard board1=(TicTacToeBoard) board;
            for(int i=0;i<3;++i){
                for(int j=0;j<3;++j){
                    if(board1.getCell(i, j)==null){
                        return new Move(new Cell(i, j), computer);
                    }
                }
            }
            throw new IllegalStateException();
        }else {
            throw new IllegalArgumentException();
        }
    }
}
