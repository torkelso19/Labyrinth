package cs301.up.edu.labyrinth.actions;

import cs301.up.edu.game.GamePlayer;
import cs301.up.edu.game.actionMsg.GameAction;

/**
 * A LabyrinthEndTurnAction is an action that is a "move" the game: the player
 * can click the reset button to reset the game state to what it
 * was at the beginning of their turn
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version September 2012
 */
public class LabyrinthResetAction extends GameAction {

    // to satisfy the serializable interface
    private static final long serialVersionUID = 12064896413L;

    /**
     * Constructor for the LabyrinthEndTurnAction class.
     *
     * @param player
     *            the player making the move
     */
    public LabyrinthResetAction(GamePlayer player) {
        super(player);
    }

}//class LabyrinthEndTurnAction
