package org.vashonsd.pirateship.interactions;

public class TreeStump extends Actor{

	public TreeStump(String name, String typeName, String description, String splash) {
		super(name, "stump", description, splash);
	}
	
	public TreeStump() {
		super("stump", "stump", "The stump is rotting", "There is a tree stump here");
		setUp();
	}

	private void setUp() {
		this.setAlive(true);
		
	}

}
