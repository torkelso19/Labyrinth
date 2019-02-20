package cs301.up.edu.labyrinth;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import cs301.up.edu.game.GameMainActivity;
import cs301.up.edu.game.GamePlayer;
import cs301.up.edu.game.LocalGame;
import cs301.up.edu.game.config.GameConfig;
import cs301.up.edu.game.config.GamePlayerType;

/**
 * this is the primary activity for Counter game
 * 
 * @author Andrew M. Nuxoll
 * @author Steven R. Vegdahl
 * @version July 2013
 */
public class LabyrinthMainActivity extends GameMainActivity {
	
	// the port number that this game will use when playing over the network
	private static final int PORT_NUMBER = 2234;

	@Override
	public void onResume() {
		super.onResume();

		//Remove layout borders from tablet
		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
				View.SYSTEM_UI_FLAG_FULLSCREEN |
				View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
		decorView.setSystemUiVisibility(uiOptions);
	}


	/**
	 * Create the default configuration for this game:
	 * - one human player vs. one computer player
	 * - minimum of 1 player, maximum of 2
	 * - one kind of computer player and one kind of human player available
	 * 
	 * @return
	 * 		the new configuration object, representing the default configuration
	 */
	@Override
	public GameConfig createDefaultConfig() {
		
		// Define the allowed player types
		ArrayList<GamePlayerType> playerTypes = new ArrayList<>();
		
		// a human player player type (player type 0)
		playerTypes.add(new GamePlayerType("Local Human Player") {
			public GamePlayer createPlayer(String name) {
				return new LabyrinthHumanPlayer(name);
			}});
		
		// a computer player type (player type 1)
		playerTypes.add(new GamePlayerType("Computer Player Easy") {
			public GamePlayer createPlayer(String name) {
				return new LabyrinthComputerPlayer2(name);
			}});
		
		// a computer player type (player type 2)
		playerTypes.add(new GamePlayerType("Computer Player Hard") {
			public GamePlayer createPlayer(String name) {
				return new LabyrinthComputerPlayer2(name);
			}});


		// Create a game configuration class for Labyrinth:
		// - player types as given above
		// - 4 Players
		// - name of game is "Counter Game"
		// - port number as defined above
		GameConfig defaultConfig = new GameConfig(playerTypes, 4,
				4, "Labyrinth Game",
				PORT_NUMBER);

		// Add the default players to the configuration
		defaultConfig.addPlayer("Human", 0); // player 1: a human player
		defaultConfig.addPlayer("Computer 1", 1); // player 2: an easy computer player
		defaultConfig.addPlayer("Computer 2", 1); // player 3: an easy computer player
		defaultConfig.addPlayer("Computer 3", 2); // player 4: a hard computer player
		
		// Set the default remote-player setup:
		// - player name: "Remote Player"
		// - IP code: (empty string)
		// - default player type: human player
		defaultConfig.setRemoteData("Remote Player", "", 0);
		
		// return the configuration
		return defaultConfig;
	}//createDefaultConfig

	/**
	 * create a local game
	 * 
	 * @return
	 * 		the local game, a counter game
	 */
	@Override
	public LocalGame createLocalGame() {
		return new LabyrinthLocalGame();
	}

}