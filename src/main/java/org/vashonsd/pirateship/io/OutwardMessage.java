package org.vashonsd.pirateship.io;

public interface OutwardMessage {
	public String getUser();
	
	public String getBody();
	
	public TimeStamp getTime();
}
