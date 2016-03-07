package org.vashonsd.pirateship;

public interface Process {
	  /*
	   * Run starts up the Process. It should return a String to announce its starting up; this may
	   * be displayed back to the user.
	   * 
	   * 
	   */
	  public String greet();
	  
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
	   * This is the entry point for commands to reach the process. This of this as the user input; the return
	   * value is the output.
	   * 
	   * For example, in CrazyChess, expect to receive something like "B>e4" (Bishop to the square at e4).
	   * 
	   * The return value might be a string representing the board, with CrazyChess' move and bizarre messages.
	   */
	  public String Request(String s);
	  
	  /*
	   * This sends control back to the main environment, along with one last message.
	   */
	  public String Exit();
}
