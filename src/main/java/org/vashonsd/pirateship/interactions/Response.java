package org.vashonsd.pirateship.interactions;

/**
 * A Response should be returned by any interactive object that is sent a Request.
 * Changes to the Player happen as a side effect. The Response is merely a container for the textual response,
 * with room for future expansions as needed.
 * The target Player will accept these changes and effect them all at once.
 * @author andy
 *
 */
public class Response 
{
	private String text;
	//The keepAlive flag alerts the game engine to send subsequent commands directly to this instance instead of to the Location.
	//This is used to keep dialogues going between the user and the interactive object.
	private boolean keepAlive;

	public Response() {
		super();
		this.keepAlive = false;
	}

	/**
	 * 
	 * @param text The text of the response to be sent.
	 * @param s A modified PlayerState which the Player will accept as its new state.
	 */
	public Response(String text)
	{
		this.text = text;
		this.keepAlive = false;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public boolean getKeepAlive() {
		return this.keepAlive;
	}
	
	public void setKeepAlive(boolean b) {
		this.keepAlive = b;
	}
}
