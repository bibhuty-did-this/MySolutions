import game.Cell;
import game.Game;
import game.GameFactory;
import game.Move;
import org.junit.Assert;
import org.junit.Test;
import user.Player;

public class GameTest {
    GameFactory gameCreator=new GameFactory();

    @Test
    public void timeOutTestForOneMove(){
        Game game=gameCreator.createGame(3, 11);
        Cell c00 = Cell.getCell(0, 0);
        Player x = new Player("X");
        Player o = new Player("O");
        int ts = 5000;
        game.move(new Move(c00, x), ts);
        Assert.assertEquals(game.getWinner().symbol(), o.symbol());
    }

    @Test
    public void timeOutTestForGame(){
        Player x = new Player("X");
        Player o = new Player("O");
        Game game=gameCreator.createGame(6000, 11000);
        Cell c00 = Cell.getCell(0, 0);
        Cell c01 = Cell.getCell(0, 1);
        Cell c02 = Cell.getCell(0, 2);
        Cell c10 = Cell.getCell(1, 0);
        int ts = 5000;
        game.move(new Move(c00, x), ts);
        game.move(new Move(c01, o), ts);
        game.move(new Move(c02, x), ts);
        game.move(new Move(c10, o), 7000);
        Assert.assertEquals(game.getWinner().symbol(), x.symbol());
    }

    @Test
    public void timeOutTestForVictory(){
        Game game=gameCreator.createGame(6000, 11000);

        Player x = new Player("X");
        Player o = new Player("O");

        Cell c00 = Cell.getCell(0, 0);
        Cell c01 = Cell.getCell(0, 1);
        Cell c02 = Cell.getCell(0, 2);
        Cell c10 = Cell.getCell(1, 0);
        Cell c11 = Cell.getCell(1, 1);
        Cell c12 = Cell.getCell(1, 2);
        Cell c20 = Cell.getCell(2, 0);
        int ts = 2000;
        game.move(new Move(c00, x), ts);
        game.move(new Move(c01, o), ts);
        game.move(new Move(c02, x), ts);
        game.move(new Move(c10, o), ts);
        game.move(new Move(c11, x), ts);
        game.move(new Move(c12, o), ts);
        game.move(new Move(c20, x), ts);
        Assert.assertEquals(game.getWinner().symbol(), x.symbol());
    }

    @Test
    public void timeOutTestForPlayer(){
        Player x = new Player("X");
        Player o = new Player("O");
        Game game=gameCreator.createGame( 11000);
        Cell c00 = Cell.getCell(0, 0);
        Cell c01 = Cell.getCell(0, 1);
        Cell c02 = Cell.getCell(0, 2);
        Cell c10 = Cell.getCell(1, 0);
        int ts = 5000;
        game.move(new Move(c00, x), ts);
        game.move(new Move(c01, o), ts);
        game.move(new Move(c02, x), ts);
        game.move(new Move(c10, o), 7000);
        Assert.assertEquals(game.getWinner().symbol(), x.symbol());
    }

    @Test
    public void timeOutTestForOneMoveWithoutTimeout(){
        Game game=gameCreator.createGame(11000);
        Cell c00 = Cell.getCell(0, 0);
        Player x = new Player("X");
        int ts = 5000;
        game.move(new Move(c00, x), ts);
        Assert.assertNull(game.getWinner());
    }

}
