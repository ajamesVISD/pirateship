/**
 * 
 */
package org.vashonsd.pirateship.minigame;

import twitter4j.TwitterException;

/**
 * @author andy
 * The Minigame interface describes the behaviors of anything that can work as a Minigame in our world.
 * 
 * Minigames are like processes that run within the main process of the game. Once the Player decides to 
 * Run a minigame, the text commands are now piped into the Minigame and consumed there.
 * 
 * This means that Minigames need to be able to quit gracefully, returning an exit message. They cannot
 * grab control of the interface and never let it go.
 */


public interface Minigame {
  /*
   * Run starts up the Minigame. It should return a String to announce its starting up; this may
   * be displayed back to the user. This is the only responsibility of this method.
   * 
   * For the example of CrazyChess, the Minigame might return "Welcome to CrazyChess! Let's get started!",
   * then display the opening board and say "You go first! What's your move?"
   * 
   */
  public String Run();
  
  
  /*
   * The "prompt" in getPrompt is what will be displayed in the chat with the user. 
   * 
   * While playing CrazyChess, the user might want to see a response like:
   * 
   * CrazyChess: "I resign! Do you want to play again? (y/n)"
   * 
   * the "CrazyChess" part of that line is the prompt. The game engine will handle adding it to the
   * start of the line.
   */
  public String getPrompt();
  
  
  
  /*
   * This is the entry point for commands to reach the minigame. This of this as the user input; the return
   * value is the output.
   * 
   * For example, in CrazyChess, expect to receive something like "B>e4" (Bishop to the square at e4).
   * 
   * The return value might be a string representing the board, with CrazyChess' move and bizarre messages.
   */
  public String Handle(String s) throws Exception;
  
  
  
  /*
   * This sends control back to the main environment, along with one last message.
   * 
   * CrazyChess might return:
   * 
   * "Well, that was something! Thanks for playing!"
   */
  public String Exit();
}
