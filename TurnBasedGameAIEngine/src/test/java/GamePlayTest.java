import api.GameEngine;
import api.RuleEngine;
import game.Board;
import game.Cell;
import game.Move;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import user.Player;

public class GamePlayTest {
    GameEngine gameEngine;
    RuleEngine ruleEngine;
    @Before
    public void setup(){
        gameEngine=new GameEngine();
        ruleEngine=new RuleEngine();
    }
    @Test
    public void checkForRowWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] firstPlayerMove=new int[][]{{1,0},{1,1},{1,2}};
        int[][] secondPlayerMove=new int[][]{{0,0},{0,1},{0,2}};
        playGame(board, firstPlayerMove, secondPlayerMove);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForColWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] firstPlayerMove=new int[][]{{0,1},{1,1},{2,1}};
        int[][] secondPlayerMove=new int[][]{{0,0},{1,0},{0,2}};
        playGame(board, firstPlayerMove, secondPlayerMove);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForDiagWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] firstPlayerMove=new int[][]{{0,0},{1,1},{2,2}};
        int[][] secondPlayerMove=new int[][]{{1,0},{2,0},{0,2}};
        playGame(board, firstPlayerMove, secondPlayerMove);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForRevDiagWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] firstPlayerMove=new int[][]{{2,0},{1,1},{0,2}};
        int[][] secondPlayerMove=new int[][]{{1,0},{0,0},{0,1}};
        playGame(board, firstPlayerMove,secondPlayerMove);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForComputerWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] firstPlayerMove=new int[][]{{1,0},{1,1},{2,2}};
        int[][] secondPlayerMove=new int[][]{{0,0},{0,1},{0,2}};
        playGame(board, firstPlayerMove,secondPlayerMove);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "O");
    }

    private void playGame(Board board, int[][] firstPlayerMoves, int[][] secondPlayerMoves) {
        int next=0;
        while (!ruleEngine.getState(board).isOver()){
            Player computer=new Player("O"), human=new Player("X");
            int row= firstPlayerMoves[next][0], col= firstPlayerMoves[next][1];
            Move humanMove=new Move(new Cell(row, col),human);
            gameEngine.move(board, humanMove);
            if(!ruleEngine.getState(board).isOver()) {
                int sRow=secondPlayerMoves[next][0];
                int sCol=secondPlayerMoves[next][1];
                Move computerMove = new Move(new Cell(sRow, sCol), computer);
                gameEngine.move(board, computerMove);
            }
            ++next;
        }
    }
}
