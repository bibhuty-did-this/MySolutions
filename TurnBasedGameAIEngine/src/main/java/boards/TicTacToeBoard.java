package boards;

import game.Board;
import game.Cell;
import game.Move;

import java.util.Objects;

public class TicTacToeBoard implements Board {
    String[][] cells=new String[3][3];

    public String getSymbol(int i, int j) {
        return cells[i][j];
    }

    public void setCell(Cell cell,String symbol) {
        if(Objects.isNull(cells[cell.getRow()][cell.getCol()])){
            cells[cell.getRow()][cell.getCol()]=symbol;
        }else throw new IllegalStateException();
    }

    @Override
    public String toString() {
        StringBuilder board=new StringBuilder();
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                board.append(cells[i][j]==null ? "-": cells[i][j]);
            }
            board.append("\n");
        }
        return board.toString();
    }

    @Override
    public void move(Move move) {
        setCell(move.getCell(), move.getPlayer().symbol());
    }

    @Override
    public TicTacToeBoard copy() {
        TicTacToeBoard ticTacToeBoard=new TicTacToeBoard();
        for(int i=0;i<3;++i){
            System.arraycopy(cells[i], 0, ticTacToeBoard.cells[i], 0, 3);
        }
        return ticTacToeBoard;
    }
}
