import api.AIEngine;
import api.GameEngine;
import api.RuleEngine;
import game.Board;
import game.Cell;
import game.Move;
import user.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine=new GameEngine();
        RuleEngine ruleEngine=new RuleEngine();
        AIEngine aiEngine=new AIEngine();
        Board board = gameEngine.start("TicTacToe");
        Scanner in=new Scanner(System.in);
        while (!ruleEngine.getState(board).isOver()){
            Player computer=new Player("O"), human=new Player("X");
            System.out.println("Make your move!");
            int row=in.nextInt(), col=in.nextInt();
            Move humanMove=new Move(new Cell(row, col),human);
            gameEngine.move(board, humanMove);
            if(!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }
        System.out.println("GameResult: "+ruleEngine.getState(board));
    }
}
