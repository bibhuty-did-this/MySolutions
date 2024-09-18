package api;

import boards.TicTacToeBoard;
import game.Board;
import game.GameState;

import java.util.Objects;

public class RuleEngine {
    public GameState getState(Board board){
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard tBoard = (TicTacToeBoard) board;

            // Rows
            boolean rowComplete = true;
            String firstCharacter="-";
            for (int i = 0; i < 3; ++i) {
                firstCharacter = tBoard.getSymbol(i,0);
                rowComplete= Objects.nonNull(firstCharacter);
                for (int j = 1; j < 3; ++j) {
                    if (Objects.nonNull(firstCharacter) && !Objects.equals(firstCharacter, tBoard.getSymbol(i,j))) {
                        rowComplete = false;
                        break;
                    }
                }
                if(rowComplete){
                    break;
                }
            }
            if(rowComplete){
                return new GameState(true, firstCharacter);
            }

            // Col
            boolean colComplete = true;
            for (int i = 0; i < 3; ++i) {
                firstCharacter = tBoard.getSymbol(0,i);
                colComplete=Objects.nonNull(firstCharacter);
                for (int j = 1; j < 3; ++j) {
                    if (Objects.nonNull(firstCharacter) && !Objects.equals(firstCharacter, tBoard.getSymbol(j,i))) {
                        colComplete = false;
                        break;
                    }
                }
                if(colComplete){
                    break;
                }
            }
            if(colComplete){
                return new GameState(true, firstCharacter);
            }


            // Diag
            firstCharacter = tBoard.getSymbol(0,0);
            boolean diagComplete = Objects.nonNull(firstCharacter);
            for (int i = 1; i < 3; ++i) {
                if (Objects.nonNull(firstCharacter) && !Objects.equals(firstCharacter, tBoard.getSymbol(i,i))) {
                    diagComplete = false;
                    break;
                }
            }
            if(diagComplete){
                return new GameState(true, firstCharacter);
            }

            // Rev Diag
            firstCharacter = tBoard.getSymbol(0,2);
            boolean revDiagComplete = Objects.nonNull(firstCharacter);
            for (int i = 1; i < 3; ++i) {
                if (Objects.nonNull(firstCharacter) && !Objects.equals(firstCharacter, tBoard.getSymbol(i,2 - i))) {
                    revDiagComplete = false;
                    break;
                }
            }
            if(revDiagComplete){
                return new GameState(true, firstCharacter);
            }

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
}
