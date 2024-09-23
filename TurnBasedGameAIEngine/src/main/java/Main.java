import api.*;
import boards.Board;
import commands.implementations.EmailCommand;
import commands.implementations.SMSCommand;
import event.ActivityEvent;
import event.EventBus;
import event.Subscriber;
import event.WinEvent;
import game.Cell;
import game.Move;
import user.Player;

import java.util.Scanner;

import static java.util.concurrent.TimeUnit.DAYS;

public class Main {
    static EmailService emailService = new EmailService();
    static SMSService smsService = new SMSService();


    public static void main(String[] args) {
        GameEngine gameEngine=new GameEngine();
        RuleEngine ruleEngine=new RuleEngine();
        AIEngine aiEngine=new AIEngine();
        Board board = gameEngine.start("TicTacToe");
        Scanner in=new Scanner(System.in);
        Player computer=new Player("O"), human=new Player("X");
        EventBus eventBus=new EventBus();
        eventBus.subscribe(new Subscriber((event->emailService.send(new EmailCommand(event)))));
        eventBus.subscribe(new Subscriber((event->smsService.send(new SMSCommand(event)))));
        if(human.getUser().activeAfter(10, DAYS)){
            eventBus.publish(new ActivityEvent(human.getUser()));
        }
        while (!ruleEngine.getState(board).isOver()){
            System.out.println("Make your move!");
            int row=in.nextInt(), col=in.nextInt();
            Move humanMove=new Move(new Cell(row, col),human);
            gameEngine.move(board, humanMove);
            if(!ruleEngine.getState(board).isOver()) {
                Cell cell = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, new Move(cell, computer));
            }
        }
        if(ruleEngine.getState(board).getWinner().equals(human.symbol())) {
            eventBus.publish(new WinEvent(human.getUser()));

        }
        System.out.println("GameResult: "+ruleEngine.getState(board));
    }
}
