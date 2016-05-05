package org.vashonsd.pirateship.interactions;

public class Request {
	private String text;
	private Actor from;
	
	//When the parser is done parsing this request for its verb, it will store it here, leaving the text
	//of the original command in place.
	private String verb;
	
	public Request(String text) {
		super();
		this.text = text;
	}
	
	public Request(String text, Actor requestor) {
		super();
		this.text = text;
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

	public Actor getFrom() {
		return from;
	}

	public void setFrom(Actor from) {
		this.from = from;
	}
}
