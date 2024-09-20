package game;

import boards.TicTacToeBoard;

import java.util.Objects;

public class GameFactory {
    public Game createGame(Integer maxTimePerMove, Integer maxTimePerPlayer){
        return new Game(
                new GameConfig(maxTimePerPlayer, Objects.nonNull(maxTimePerPlayer)),
                new TicTacToeBoard(),
                null,
                0,
                maxTimePerPlayer,
                maxTimePerMove
                );
    }

    public Game createGame(Integer maxTimePerMove, Integer maxTimePerPlayer, TicTacToeBoard startingBoard){
        return new Game(
                new GameConfig(maxTimePerPlayer, Objects.nonNull(maxTimePerPlayer)),
                startingBoard,
                null,
                0,
                maxTimePerPlayer,
                maxTimePerMove
        );
    }

    public Game createGame(Integer maxTimePerPlayer){
        return new Game(
                new GameConfig(null, true),
                new TicTacToeBoard(),
                null,
                0,
                maxTimePerPlayer,
                null
        );
    }
    public Game createGame(){
        return new Game(
                new GameConfig(null, false),
                new TicTacToeBoard(),
                null,
                0,
                null,
                null
        );
    }

}
