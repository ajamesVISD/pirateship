package org.vashonsd.pirateship.minigame;


/**
 * @author andy
 * The minigame factory represents an offer to create an instance of a minigame. Perhaps confusingly, what
 * we stuff into each Location is not an instance a Minigame; it is an offer to produce one. We do this for
 * two reasons:
 * 
 * 1) The MinigameFactory can describe the game, including its name and description and so forth, without
 * having to create an instance of the Factory.
 * 2) We can potentially use the Factory to pass more data to the game. Eventually, we might want to pass
 * an object that represents limited access to Player state, so that the Minigame can find out the Player's name,
 * or do money dealings with the Player.
 */
public interface MinigameFactory {
	/*
	 * The name is the registry's version of what this game is called. Let's use the example of CrazyChess,
	 * a game that plays random chess moves with no hope of winning. GetName() would return "CrazyChess."
	 * 
	 * Expect that this name will be used as the command the user types to start the game.
	 */
	public String getName();
	
	/*
	 * The full name is the name that may be broadcast; e.g., "CrazyChess 2250 -- the game of the future!"
	 * Do not expect that the user will interact using this name. consider it view-only.
	 */
	public String getFullName();
	
	/*
	 * Announce() provides the String by which the Minigame announces its presence in a Location.
	 * 
	 * The game of CrazyChess might return: "If you want to beat a really terrible opponent in chess,
	 * CrazyChess is the game for you!"
	 */
	public String getDescription();
	
	public Minigame newGame();
}