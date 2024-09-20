import game.Game;
import game.GameCreator;
import org.junit.Test;

public class GameTest {
    GameCreator gameCreator=new GameCreator();

    @Test
    public void timeOutTest(){
        int secondsElapsed=0;
        Game game=gameCreator.createGame(3, 120);
    }

}
