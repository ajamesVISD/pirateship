package org.vashonsd.pirateship.minigame.text;


public class Escape implements TextMinigame {

	private static String story = "\nYou are in a room with a door, a box, a barred window, and a tray with soup and a spoon." + "\nWhat will you do?\n(Digging is good)";
	private boolean hasKey = false;
	private boolean boxIsOpen = false;
	private boolean withWhatKeyAndDoor = false;
	private boolean soupIsEaten = false;
	private boolean spoonIsTaken = false;
	private boolean withWhatSpoonAndDoor = false;
	private boolean doorIsOpen = false;
	
	public String Run() {
		return story;
	}

	public String getPrompt() {
		// TODO Auto-generated method stub
		return "Escape";
	}

	public String Handle(String s) {
		String result = "";
		// TODO Auto-generated method stub
		/*
		if (s.equals("open the door") || s.equals("open door")) {
			result = "With what?";
			if (s.equals("key") || s.equals("the key")) {
				result = escapeText;
			}
		} else if (s.equals("pick up key")){
			result = "You picked up the key." + story;
			if (s.equals("open door") || s.equals("open the door")) {
				result = escapeText;
			}
		}
		*/
		if (s.equals("open door") && hasKey == true) {
			withWhatKeyAndDoor = true;
			result = "With what?";
		} else if(s.equals("key") && withWhatKeyAndDoor == true) {
			withWhatKeyAndDoor = false;
			doorIsOpen = true;
			result = "It opens. Type 'leave' to leave";
		} else if(s.equals("take key") && boxIsOpen == true) {
			hasKey = true;
			result = "You picked up the key.";
		} else if(s.equals("open door") && hasKey == false) {
			result = "It's locked.";
		} else if(s.equals("take key") && boxIsOpen == false) {
			result = "What key?";
		} else if(s.equals("open box")){
			boxIsOpen = true;
			result = "The box is open and there is a key inside";
		} else if(s.equals("close box")) {
			boxIsOpen = false;
			result = "The box is closed";
		} else if(s.equals("open box") && boxIsOpen == true) {
			result = "The box is already open.";
		} else if(s.equals("close box") && boxIsOpen == false) {
			result = "The box is already closed.";
		} else if(s.equals("examine window")){
			result = "These bars are solid iron, I don't think you can get through here.";
		} else if(s.equals("examine door")) {
			result = "Solid iron, but a key could unlock it.";
		} else if(s.equals("examine box")) {
			result = "Oddly small box; what could you even fit in there?";
		} else if(s.equals("examine key") && boxIsOpen == true) {
			result = "For every key, there is a lock.";
		} else if(s.equals("examine key") && boxIsOpen == false) {
			result = "What key?";
		} else if(s.equals("eat soup") && soupIsEaten == false) {
			soupIsEaten = true;
			result = "That hit the spot.";
		} else if(s.equals("eat soup") && soupIsEaten == true) {
			result = "You already ate it. Remember?";
		} else if(s.equals("examine soup")) {
			result = "Looks like last nights soup.";
		} else if(s.equals("examine spoon")) {
			result = "Looks like a spoon. What did you think it would look like?";
		} else if(s.equals("take spoon") && spoonIsTaken == false) {
			spoonIsTaken = true;
			result = "You picked up the spoon.";
		} else if(s.equals("take spoon") && spoonIsTaken == true) {
			result = "You already took it.";
		} else if(s.equals("open door") && spoonIsTaken == true) {
			withWhatSpoonAndDoor = true;
			result = "With what?";
		} else if(s.equals("spoon") && withWhatSpoonAndDoor == true) {
			withWhatSpoonAndDoor = false;
			result = "You try but it wont fit.";
		}  else if(s.equals("leave") && doorIsOpen == true) {
			doorIsOpen = false;
			hasKey = false;
			result = "You walk into the hallway but a guard sees you. He takes the key and locks you in the cell.";
		} else if(s.equals("dig wall") && spoonIsTaken == false) {
			result = "That gets you nowhere, a tool could help.";
		}  else if(s.equals("dig wall") && spoonIsTaken == true) {
			result = "You escaped! Type exit.";
		} else {
			return "I dont understand that command";
		}
		return result;
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "You are free! Thanks for playing.";
	}

}
