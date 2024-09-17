package boards;

import game.Board;
import game.Cell;
import game.Move;

public class TicTacToeBoard extends Board {
    String[][] cells=new String[3][3];

    public String getCell(int i, int j) {
        return cells[i][j];
    }

    public void setCell(Cell cell,String symbol) {
        cells[cell.getRow()][cell.getCol()]=symbol;
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
}
