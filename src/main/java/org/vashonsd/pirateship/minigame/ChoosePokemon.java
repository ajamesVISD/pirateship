package org.vashonsd.pirateship.minigame;

import java.util.ArrayList;

import org.vashonsd.pirateship.interactions.*;
import org.vashonsd.pirateship.interactions.poke.*;
import org.vashonsd.pirateship.minigame.text.MiniPokemon;

public class ChoosePokemon extends Minigame {

	private Pokemon pokemon;
	private PokemonGenerator pgen;
	private int lines;
	private boolean over;
	private ArrayList<Pokemon> availablePokemon;
	
	public ChoosePokemon() {
		super("Professor Oak", "poke", "Chose your pokemon", "An elderly gentleman in a white labcoat stands near a table with three red and white spheres on it.");
		pgen = new PokemonGenerator();
		lines = 0;
		over = false;
		availablePokemon = new ArrayList<Pokemon>();
		
		availablePokemon.add(pgen.bulbasaur());
		availablePokemon.add(pgen.charmander());
		availablePokemon.add(pgen.squirtle());
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
		return "Oak";
	}

	@Override
	public String getExit() {
		// TODO Auto-generated method stub
		return "Good luck! Take care of " + pokemon.getName();
	}
	
	public String availablePokemon() {
		String toReturn = "Select a Pokemon: \n";
		for(Pokemon m: availablePokemon) {
			toReturn += m.getName() + "\n";
		}
		return toReturn;
	}

	public String pokeballs() {
		return 
"                000000000000000            \n" +
"             000000000000000000000         \n" +
"          000000000000000000000000000      \n" +
"        0000000000000000000000000000000    \n" +
"      00000000000000000000000000000000000  \n" +
"     0000000000000000000000000000000000000 \n" +
"    000000000000000<<<<>>>>0000000000000000\n" +
"    000000000000000<OOOOOO>0000000000000000\n" +
"    <<<<<<<<<<<<<<<<OOOOOO>>>>>>>>>>>>>>>>>\n" +
"    OOOOOOOOOOOOOOO<OOOOOO>OOOOOOOOOOOOOOOO\n" +
"    OOOOOOOOOOOOOOO<<<<>>>>OOOOOOOOOOOOOOOO\n" +
"     OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO \n" +
"      OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO  \n" +
"        OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO    \n" +
"          OOOOOOOOOOOOOOOOOOOOOOOOOOO      \n" +
"              OOOOOOOOOOOOOOOOOOO          \n" +
"                 OOOOOOOOOOOOO             \n";
	}
}
