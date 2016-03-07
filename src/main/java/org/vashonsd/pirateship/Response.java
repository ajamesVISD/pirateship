package org.vashonsd.pirateship;

import java.util.ArrayList;
import java.util.HashMap;

import org.vashonsd.pirateship.structure.Location;

/*
 * This permits us to send a full set of objects back in a response.
 */
public class Response {
	private String responseText;
	//interactions can have effects on multiple LocationStates. This dictionary encompasses the changes in every
	//LocationState, keyed to an int we can use as the Location Id. This dictionary can be used to enact changes
	//in the referenced Locations in the World.
//	private HashMap<String, LocationState> newLocationStates;
	
	private PlayerState newPlayerState;
	
	private boolean isValid;

	public Response(String responseText,  PlayerState newPlayerState) {
		super();
		this.responseText = responseText;
		this.newPlayerState = newPlayerState;
		
		//We use the declared location of the PlayerState to add it to the newLocationStates.
		/*newLocationStates = new HashMap<String, LocationState>();
		Location loc = newPlayerState.getCurrentLocation();
		this.newLocationStates.put(loc.getName(), loc);*/
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	/*public HashMap<String, LocationState> getNewLocationStates() {
		return newLocationStates;
	}

	public void setNewLocationStates(HashMap<String, LocationState> newLocationStates) {
		this.newLocationStates = newLocationStates;
	}*/

	public PlayerState getNewPlayerState() {
		return newPlayerState;
	}

	public void setNewPlayerState(PlayerState newPlayerState) {
		this.newPlayerState = newPlayerState;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	
	
}
