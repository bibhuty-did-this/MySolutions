package api;

import boards.TicTacToeBoard;
import game.Board;
import game.Cell;
import game.Move;
import user.Player;

public class AIEngine {
    public Move suggestMove(Player player, Board board) {
        if(board instanceof TicTacToeBoard){
            TicTacToeBoard board1=(TicTacToeBoard) board;
            Move suggestion;
            if(countMoves(board1, 3)) {
                suggestion = suggestBasicMove(player, board1);
            }else{
                suggestion = suggestSmartMove(player, board1);
            }
            if(suggestion!=null) return suggestion;
            throw new IllegalStateException();
        }else {
            throw new IllegalArgumentException();
        }
    }

    private Move suggestSmartMove(Player player, TicTacToeBoard board) {
        RuleEngine ruleEngine=new RuleEngine();

        // Victorious move
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(board.getSymbol(i, j)!=null){
                    Move move = new Move(new Cell(i, j), player);
                    TicTacToeBoard boardCopy=board.copy();
                    boardCopy.move(move);
                    if(ruleEngine.getState(boardCopy).isOver()){
                        return move;
                    }
                }
            }
        }

        // Defensive move
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(board.getSymbol(i, j)!=null){
                    Move move = new Move(new Cell(i, j), player.flip());
                    TicTacToeBoard boardCopy=board.copy();
                    boardCopy.move(move);
                    if(ruleEngine.getState(boardCopy).isOver()){
                        return new Move(new Cell(i,j), player);
                    }
                }
            }
        }
        return null;
    }

    private boolean countMoves(TicTacToeBoard board, int threshold) {
        int moves=0;
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(board.getSymbol(i, j)!=null){
                    ++moves;
                }
            }
        }
        return moves<threshold;
    }

    public Move suggestBasicMove(Player computer, TicTacToeBoard board) {
        if(board != null){
            for(int i=0;i<3;++i){
                for(int j=0;j<3;++j){
                    if(board.getSymbol(i, j)==null){
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
