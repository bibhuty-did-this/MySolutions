package boards;

import api.Rule;
import api.RuleSet;
import game.Cell;
import game.GameState;
import game.Move;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TicTacToeBoard implements CellBoard {

    public enum Symbol{
        X("X"),O("O");
        String marker;
        Symbol(String marker){
            this.marker=marker;
        }

        public String marker() {
            return marker;
        }
    }
    String[][] cells=new String[3][3];
    History history=new History();

    public static RuleSet<TicTacToeBoard> getRules() {
        return new RuleSet<>() {{
            add(new Rule(board -> outerTraversal(board::getSymbol)));
            add(new Rule(board -> outerTraversal((i, j) -> board.getSymbol(j, i))));
            add(new Rule(board -> traverse(i -> board.getSymbol(i, i))));
            add(new Rule(board -> traverse(i -> board.getSymbol(i, 2 - i))));
            add(new Rule(board -> countFilledCells((TicTacToeBoard) board)));
        }};

    }

    @Override
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
    public TicTacToeBoard move(Move move) {
        history.add(getRepresentation(this));
        TicTacToeBoard board=copy();
        board.setCell(move.getCell(), move.getPlayer().symbol());
        return board;
    }

    private Representation getRepresentation(TicTacToeBoard ticTacToeBoard) {
        return new Representation(ticTacToeBoard);
    }

    @Override
    public TicTacToeBoard copy() {
        TicTacToeBoard ticTacToeBoard=new TicTacToeBoard();
        for(int i=0;i<3;++i){
            System.arraycopy(cells[i], 0, ticTacToeBoard.cells[i], 0, 3);
        }
        ticTacToeBoard.history = history;
        return ticTacToeBoard;
    }

    private static GameState countFilledCells(TicTacToeBoard board) {
        // Col filled
        int countOfFilledCells = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board.getSymbol(i, j) != null) {
                    ++countOfFilledCells;
                }
            }
        }
        if (countOfFilledCells == 9) {
            return new GameState(true, "-");
        }
        return new GameState(false, "-");
    }



    private static GameState outerTraversal(BiFunction<Integer, Integer, String> next) {
        GameState result = new GameState(false, "-");
        for (int i = 0; i < 3; ++i) {
            final int ii = i;
            GameState traversal = traverse(j -> next.apply(ii, j));
            if (traversal.isOver()) {
                result = traversal;
                break;
            }
        }
        return result;
    }

    private static GameState traverse(Function<Integer, String> traversal) {
        GameState result = new GameState(false, "-");
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
