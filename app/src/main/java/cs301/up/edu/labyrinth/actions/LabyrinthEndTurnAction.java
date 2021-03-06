package cs301.up.edu.labyrinth.actions;

import cs301.up.edu.game.GamePlayer;
import cs301.up.edu.game.actionMsg.GameAction;

/**
 * A LabyrinthEndTurnAction is an action that is a "move" the game: the player
 * ends their turn to signify that the next player
 * can begin their turn
 *
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version September 2012
 */
public class LabyrinthEndTurnAction extends GameAction {

    // to satisfy the serializable interface
    private static final long serialVersionUID = 82068647865424L;

    /**
     * Constructor for the LabyrinthEndTurnAction class.
     *
     * @param player
     *            the player making the move
     */
    public LabyrinthEndTurnAction(GamePlayer player) {
        super(player);
    }

}//class LabyrinthEndTurnAction
