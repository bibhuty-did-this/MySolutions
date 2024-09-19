package placements;

import api.RuleEngine;
import boards.TicTacToeBoard;
import game.Cell;
import user.Player;

import java.util.Optional;

public interface Placement {

    RuleEngine ruleEngine=new RuleEngine();
    Optional<Cell> place(TicTacToeBoard board, Player player);
    Placement next();
}
