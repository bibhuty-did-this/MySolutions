package placements;

import boards.TicTacToeBoard;
import game.Cell;
import user.Player;
import utils.Utils;

import java.util.Optional;

public class CornerPlacement implements Placement{

    private static CornerPlacement cornerPlacement;

    private CornerPlacement(){

    }
    static synchronized Placement get(){
        cornerPlacement = (CornerPlacement) Utils.getIfNull(cornerPlacement, CornerPlacement::new);
        return cornerPlacement;
    }

    @Override
    public Optional<Cell> place(TicTacToeBoard board, Player player) {
        int[][] corners=new int[][]{{0,0},{2,0},{0,2},{2,2}};
        Cell corner=null;
        for(int i=0;i<4;i++){
            if(board.getSymbol(corners[i][0],corners[i][1])==null){
                corner = new Cell(corners[i][0], corners[i][1]);
            }
        }
        return Optional.ofNullable(corner);
    }

    @Override
    public Placement next() {
        return null;
    }
}
