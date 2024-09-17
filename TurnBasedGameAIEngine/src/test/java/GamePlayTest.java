import api.AIEngine;
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
    AIEngine aiEngine;
    @Before
    public void setup(){
        gameEngine=new GameEngine();
        ruleEngine=new RuleEngine();
        aiEngine=new AIEngine();
    }
    @Test
    public void checkForRowWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves=new int[][]{{1,0},{1,1},{1,2}};
        int next=0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForColWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves=new int[][]{{0,1},{1,1},{2,1}};
        int next=0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForDiagWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves=new int[][]{{0,0},{1,1},{2,2}};
        int next=0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForRevDiagWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves=new int[][]{{2,0},{1,1},{0,2}};
        int next=0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForComputerWin() {
        Board board = gameEngine.start("TicTacToe");
        int[][] moves=new int[][]{{1,0},{1,1},{2,2}};
        int next=0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "O");
    }

    private void playGame(Board board, int[][] moves, int next) {
        while (!ruleEngine.getState(board).isOver()){
            Player computer=new Player("O"), human=new Player("X");
            int row= moves[next][0], col= moves[next][1];
            ++next;
            Move humanMove=new Move(new Cell(row, col),human);
            gameEngine.move(board, humanMove);
            if(!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }
    }
}
