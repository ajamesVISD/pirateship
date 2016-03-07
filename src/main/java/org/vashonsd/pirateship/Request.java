package org.vashonsd.pirateship;

import org.vashonsd.pirateship.structure.Location;

public class Request {
	private String text;
	private Player p;
	private Response resp;
	
	public Request(Player p, String text) {
		super();
		this.p = p;
		this.text = text;
		p.getIo();
		resp = new Response("", p.getState());
	}
	
	public Response Handle() {
		if (p.getCurrentLocation().commandAvailable(text)) {
			PlayerState ps = p.getState();
			Location newLoc = ps.getCurrentLocation().travel(text);
			ps.setCurrentLocation(newLoc);
			//
			resp.setResponseText(newLoc.toString());
			resp.setNewPlayerState(ps);
			resp.setValid(true);
		} else {
			resp.setResponseText(text + " is not a valid choice.");
			resp.setValid(false);
		}
		return resp;
	}
    
	/*
	 * This method for centering text is just waiting to be used.
	 */
    private String center(String c)
    {
    	String center = "";
    	String see = c;
    	int dashes = (15 - c.length())/2;
    	for(int i = 0; i < dashes; i++)
    	{
    		center += "-";
    	}
    	see += center;
    	center += see;
    	if(c.length()%2 == 0)
    	center += "-";
    	if (c.length() > 15)
    	center = c;
    	return center;
    }
}
