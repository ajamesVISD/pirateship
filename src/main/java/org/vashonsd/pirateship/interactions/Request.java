package org.vashonsd.pirateship.interactions;

public class Request {
	private String text;
	
	public Request(String s) {
		this.text = s;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
