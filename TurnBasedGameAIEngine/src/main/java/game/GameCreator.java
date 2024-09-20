package game;

import boards.TicTacToeBoard;

import java.util.Objects;

public class GameCreator {
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

}
