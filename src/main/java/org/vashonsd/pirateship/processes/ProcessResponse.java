package org.vashonsd.pirateship.processes;

/*
 * A ProcessResponse stores needed variables to go with the result.
 */
public class ProcessResponse {
	private boolean keepAlive;
	private String body;
	
	public ProcessResponse(boolean keepAlive, String body) {
		super();
		this.keepAlive = keepAlive;
		this.body = body;
	}

	public boolean isKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
