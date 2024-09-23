package strategy;

import boards.TicTacToeBoard;
import strategy.BasicStrategy;
import strategy.OptimalStrategy;
import strategy.SmartStrategy;
import strategy.Strategy;
import user.Player;

public class StrategyFactory {
    public Strategy getStrategy(TicTacToeBoard board1, Player player) {
        Strategy strategy = null;
        int threshold=3;
        if(countMoves(board1, threshold)) {
            strategy = new BasicStrategy();
        }else if(countMoves(board1, threshold+1)){
            strategy =  new SmartStrategy();
        }else if(player.getTimeUsedInMillis()>100000){
            strategy = new BasicStrategy();
        }else{
            strategy = new OptimalStrategy();
        }
        return  strategy;
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

}
