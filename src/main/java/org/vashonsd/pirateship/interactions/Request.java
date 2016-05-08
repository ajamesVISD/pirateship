package org.vashonsd.pirateship.interactions;

public class Request {
	private String text;
	private Player from;
	
	//When the parser is done parsing this request for its verb, it will store it here, leaving the text
	//of the original command in place.
	private String verb;
	
	/**
	 * It is possible to create a Request with text only. Not advised outside of the test environment.
	 * @param text
	 */
	public Request(String text) {
		this.text = text;
	}
	
	/**
	 * A full request with text and Player doing the requesting.
	 * @param text
	 * @param requestor
	 */
	public Request(String text, Player requestor) {
		this.text = text;
		this.setFrom(requestor);
	}
	
	/**
	 * A Request with only the Player set. Set the text of this request before using it.
	 * @param requestor
	 */
	public Request(Player requestor) {
		this.setFrom(requestor);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Sets the verb the parser has discovered in the text of the original request.
	 * @param s the verb to be set for this request.
	 */
	public void setVerb(String s) {
		this.verb = s;
	}
	
	public String getVerb() {
		return verb;
	}

	public Player getFrom() {
		return from;
	}

	public void setFrom(Player from) {
		this.from = from;
	}
}
