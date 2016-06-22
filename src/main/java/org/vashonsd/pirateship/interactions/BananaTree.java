package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;


public class BananaTree extends Actor {

	public BananaTree(String name, String typeName, String description, String splash) {
		super(name, "tree", description, splash);
	}
	
	public BananaTree() {
		super("tree", "tree", "The tree towers over you with bananas hanging from it.", "There is a tree here.");
		setUp();
	}

	private void setUp() {
		this.setAlive(true);
		this.maxHealth=50;
		this.health=maxHealth;
		this.setTypeName("tree");
		this.setTypeNamePlural("trees");
		enrollCommand(new Examine());
		enrollCommand(new Chop());
	}
	
	public void changeHealth(int n) {
		this.health += n;
		checkHealth();
	}
	
	protected void checkHealth() {
		if (health < 0) {
			this.name = "tree stump";
			this.description = "Shards of bark surrounding a stump. \nSome bananas fell.";
			System.out.println("2 bananas are now on the ground.");
		}
		if (health < 15) {
			this.name = "a tree that is close to death";
			this.description = "A tree. Most of it is dead.";
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
}
