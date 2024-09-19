package api;

import boards.TicTacToeBoard;
import boards.Board;
import game.Cell;
import game.Move;
import placements.OffensivePlacement;
import placements.Placement;
import user.Player;

import java.util.Objects;
import java.util.Optional;

public class AIEngine {

    public RuleEngine ruleEngine;

    public AIEngine(){
        this.ruleEngine=new RuleEngine();
    }

    public Cell suggestMove(Player player, Board board) {
        if(board instanceof TicTacToeBoard){
            TicTacToeBoard board1=(TicTacToeBoard) board;
            Cell suggestion;
            int threshold = 3;
            if(countMoves(board1, threshold)) {
                suggestion = suggestBasicMove(board1);
            }else if(countMoves(board1, threshold+1)){
                suggestion = getCellToPlay(player, board1);
            }else{
                suggestion = suggestOptimalMove(player, board1);
            }
            if(suggestion!=null) return suggestion;
            throw new IllegalStateException();
        }else {
            throw new IllegalArgumentException();
        }
    }

    private Cell suggestOptimalMove(Player player, TicTacToeBoard board1) {
        Placement placement= OffensivePlacement.get();

        while (placement.next()!=null){
            Optional<Cell> place=placement.place(board1, player);
            if(place.isPresent()){
                return place.get();
            }
            placement=placement.next();
        }

        return null;
    }

    private Cell getCellToPlay(Player player, TicTacToeBoard board) {
        Cell best=offense(player,board);
        if(Objects.nonNull(best)) return best;
        best = defense(player, board);
        if (Objects.nonNull(best)) return best;
        return null;
    }

    private Cell offense(Player player, TicTacToeBoard board) {
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(board.getSymbol(i, j)==null){
                    Move move = new Move(new Cell(i, j),player);
                    TicTacToeBoard boardCopy=board.copy();
                    boardCopy.move(move);
                    if(ruleEngine.getState(boardCopy).isOver()){
                        return move.getCell();
                    }
                }
            }
        }
        return null;
    }

    private Cell defense(Player player, TicTacToeBoard board) {
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(board.getSymbol(i, j)==null){
                    Move move = new Move(new Cell(i, j), player.flip());
                    TicTacToeBoard boardCopy= board.copy();
                    boardCopy.move(move);
                    if(ruleEngine.getState(boardCopy).isOver()){
                        return new Cell(i, j);
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

    public Cell suggestBasicMove(TicTacToeBoard board) {
        if(board != null){
            for(int i=0;i<3;++i){
                for(int j=0;j<3;++j){
                    if(board.getSymbol(i, j)==null){
                        return new Cell(i, j);
                    }
                }
            }
            throw new IllegalStateException();
        }else {
            throw new IllegalArgumentException();
        }
    }
}
