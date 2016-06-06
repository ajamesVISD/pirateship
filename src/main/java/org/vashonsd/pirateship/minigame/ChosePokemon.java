package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.*;
import org.vashonsd.pirateship.interactions.poke.*;

public class ChosePokemon extends Minigame {

	private Pokemon pokemon;
	private PokemonGenerator pgen;
	private int lines;
	private boolean over;
	
	public ChosePokemon() {
		super("Professor Oak", "poke", "Chose your pokemon", "An elderly gentleman in a white labcoat stands near a table with three red and white spheres on it.");
		pgen = new PokemonGenerator();
	}
	
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Hello, my name is Professor Oak and this is my pokemon lab.";
	}

	@Override
	public Response handleOtherwise(Request req) {
		// TODO Auto-generated method stub
		
		
		return new Response("Goodbye");
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExit() {
		// TODO Auto-generated method stub
		return "Good luck! Take care of " + pokemon.getName();
	}

}
