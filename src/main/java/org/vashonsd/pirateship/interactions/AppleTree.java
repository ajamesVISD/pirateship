package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;


public class AppleTree extends Actor {

	public AppleTree(String name, String typeName, String description, String splash) {
		super(name, "appleTree", description, splash);
	}
	
	public AppleTree() {
		super("tree", "appleTree", "The tree towers over you with apples hanging from it.", "There is a tree here.");
		setUp();
	}

	private void setUp() {
		this.setAlive(true);
		this.maxHealth=50;
		this.health=maxHealth;
		this.setTypeName("appleTree");
		this.setTypeNamePlural("appleTrees");
		enrollCommand(new Examine());
		enrollCommand(new Chop());
	}
	
	public void changeHealth(int n) {
		this.health += n;
		checkHealth();
	}
	
	@Override
	protected void checkHealth() {
		if (health < 0) {
			this.name = "tree stump";
			this.description = "Shards of bark surrounding a stump. \nSome apples fell.";
		}
		if (health < 15) {
			this.name = "a tree that is close to death";
			this.description = "A tree. Most of it is .";
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
}
