package game;

import api.RuleEngine;
import boards.Board;
import user.Player;

import java.util.Objects;

public class Game {

    private GameConfig gameConfig;
    private Board board;
    private Player winner;
    private Integer lastMoveTimeInMillis;
    private Integer maxTimePerPlayer;
    private Integer maxTimePerMove;
    private RuleEngine ruleEngine = new RuleEngine();

    public Game(GameConfig gameConfig, Board board, Player winner, Integer lastMoveTimeInMillis, Integer maxTimePerPlayer, Integer maxTimePerMove) {
        this.gameConfig = gameConfig;
        this.board = board;
        this.winner = winner;
        this.lastMoveTimeInMillis = lastMoveTimeInMillis;
        this.maxTimePerPlayer = maxTimePerPlayer;
        this.maxTimePerMove = maxTimePerMove;
    }

    public void move(Move move, int timestampInMillis){
        if(Objects.isNull(winner)){
            int timeTakenSinceLastMove = timestampInMillis - lastMoveTimeInMillis;
            move.getPlayer().setTimeTaken(timeTakenSinceLastMove);
            if(gameConfig.timed){
                moveForTimedGame(move, timeTakenSinceLastMove);
            }else{
                board = board.move(move);
            }
            if(Objects.isNull(winner) && ruleEngine.getState(board).isOver()){
                winner = move.getPlayer();
            }
        }
    }

    private void moveForTimedGame(Move move, int timeTakenSinceLastMove) {
        if(move.getPlayer().getTimeUsedInMillis()<maxTimePerPlayer &&
                (Objects.isNull(gameConfig.timePerMove) || timeTakenSinceLastMove < maxTimePerMove)){
            board = board.move(move);
        }else {
            winner= move.getPlayer().flip();
        }
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public Player getWinner() {
        return winner;
    }
}
