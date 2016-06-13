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
		if(lines == 0) {
			lines++;
			this.response.setText("As a Pokemon professor it is my job to provide young trainers like yourself with their first pokemon.");
			return response;
		}
		if(lines == 1) {
			lines++;
			this.response.setText("I have three pokemon for you to choose from, they're inside the pokeballs on the table.\n\n" + pokeballs());
			return response;
		}
		if(lines == 2) {
			for(Pokemon m: availablePokemon) {
				if(req.getText().equalsIgnoreCase(m.getName())) {
					pokemon = m;
					this.response.setText(m.toString() + m.getPrintOut() + "\nWould you like " + m.getName() + " the " + m.getTypeName() + " pokemon?");
					return response;
				}
			}
			
			if(req.getText().equalsIgnoreCase("yes")) {
				lines++;
				this.response.setText("What moves should " + pokemon.getName() + " learn?\n\n" + learnableMoves(pokemon));
				return response;
			} else {
				this.response.setText("Select a pokemon " + pokeballs());
				return response;
			}
		}
		if(lines == 3) {
			if(pokemon.getMoves().size() == 4) {
				lines++;
				this.response.setText("Your Pokemon is ready to battle!");
				return response;
			}
			for(PokeMove m: pokemon.getLearnable()) {
				if(req.getText().equalsIgnoreCase(m.getName())) {
					pokemon.addMove(m);
					if(pokemon.getMoves().size() < 4) {
						this.response.setText("Your Pokemon learned " + m.getName() + "\n" + pokemon.getName() + "'s moves: \n" + pokemon.printMoves() + "\n\nSelect another move. " + learnableMoves(pokemon) + "\n");
						return response;
					} else {
						this.response.setText("Your Pokemon learned " + m.getName() + "\n" + pokemon.getName() + "'s moves: \n" + pokemon.printMoves());
						return response;
					}
				}
			}
			
			this.response.setText("You must select a move from the list.\n" + learnableMoves(pokemon));
			return response;
		}
		Player player = req.getPlayer();
		if(lines == 4) {
			if(!player.getInventory().hasActorType("Pokemon")) {
				player.addToInventory(pokemon);
				lines += 2;
				this.response.setText("Good luck, take care of " + pokemon.getName() + "!");
				return response;
			}
			else {
				lines++;
				this.response.setText("You already have a pokemon, would you like to swap your current pokemon for " + pokemon.getName() + " ?");
				return response;
			}
		}
		if(lines == 5) {
			lines++;
			if(req.getText().equalsIgnoreCase("yes")) {
				player.removeActorTypeFromInventory("pokemon");
				player.addToInventory(pokemon);
				this.response.setText("Good luck, take care of " + pokemon.getName() + "!");
				return response;
			}
			else {
				this.response.setText("Okay then, come back if you want to switch pokemon.");
				return response;
			}
		}
		
		this.response.setText("Goodbye.");
		return response;
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return "Oak";
	}

	@Override
	public String getExit() {
		// TODO Auto-generated method stub
		lines = 0;
		return "Goodbye";
	}
	
	public String availablePokemon() {
		String toReturn = "Select a Pokemon: \n";
		for(Pokemon m: availablePokemon) {
			toReturn += m.getName() + "\n";
		}
		return toReturn;
	}

	public String pokeball() {
		return 
"                000000000000000            \n" +
"             000000000000000000000         \n" +
"          000000000000000000000000000      \n" +
"        0000000000000000000000000000000    \n" +
"      00000000000000000000000000000000000  \n" +
"     0000000000000000000000000000000000000 \n" +
"    000000000000000<<<<>>>>0000000000000000\n" +
"    000000000000000<OOOOOO>0000000000000000\n" +
"    <<<<<<<<<<<<<<<<O<OO>O>>>>>>>>>>>>>>>>>\n" +
"    OOOOOOOOOOOOOOO<OOOOOO>OOOOOOOOOOOOOOOO\n" +
"    OOOOOOOOOOOOOOO<<<<>>>>OOOOOOOOOOOOOOOO\n" +
"     OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO \n" +
"      OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO  \n" +
"        OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO    \n" +
"          OOOOOOOOOOOOOOOOOOOOOOOOOOO      \n" +
"              OOOOOOOOOOOOOOOOOOO          \n" +
"                 OOOOOOOOOOOOO             \n";
	}
	
	public String pokeballs() {
		return 
"                000000000000000            " + "                000000000000000            " + "                000000000000000            \n" +
"             000000000000000000000         " + "             000000000000000000000         " + "             000000000000000000000         \n" +
"          000000000000000000000000000      " + "          000000000000000000000000000      " + "          000000000000000000000000000      \n" +
"        0000000000000000000000000000000    " + "        0000000000000000000000000000000    " + "        0000000000000000000000000000000    \n" +
"      00000000000000000000000000000000000  " + "      00000000000000000000000000000000000  " + "      00000000000000000000000000000000000  \n" +
"     0000000000000000000000000000000000000 " + "     0000000000000000000000000000000000000 " + "     0000000000000000000000000000000000000 \n" +
"    000000000000000<<<<>>>>0000000000000000" + "    000000000000000<<<<>>>>0000000000000000" + "    000000000000000<<<<>>>>0000000000000000\n" +
"    000000000000000<OOOOOO>0000000000000000" + "    000000000000000<OOOOOO>0000000000000000" + "    000000000000000<OOOOOO>0000000000000000\n" +
"    <<<<<<<<<<<<<<<<O<OO>O>>>>>>>>>>>>>>>>>" + "    <<<<<<<<<<<<<<<<O<OO>O>>>>>>>>>>>>>>>>>" + "    <<<<<<<<<<<<<<<<O<OO>O>>>>>>>>>>>>>>>>>\n" +
"    OOOOOOOOOOOOOOO<OOOOOO>OOOOOOOOOOOOOOOO" + "    OOOOOOOOOOOOOOO<OOOOOO>OOOOOOOOOOOOOOOO" + "    OOOOOOOOOOOOOOO<OOOOOO>OOOOOOOOOOOOOOOO\n" +
"    OOOOOOOOOOOOOOO<<<<>>>>OOOOOOOOOOOOOOOO" + "    OOOOOOOOOOOOOOO<<<<>>>>OOOOOOOOOOOOOOOO" + "    OOOOOOOOOOOOOOO<<<<>>>>OOOOOOOOOOOOOOOO\n" +
"     OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO " + "     OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO " + "     OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO \n" +
"      OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO  " + "      OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO  " + "      OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO  \n" +
"        OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO    " + "        OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO    " + "        OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO    \n" +
"          OOOOOOOOOOOOOOOOOOOOOOOOOOO      " + "          OOOOOOOOOOOOOOOOOOOOOOOOOOO      " + "          OOOOOOOOOOOOOOOOOOOOOOOOOOO      \n" +
"              OOOOOOOOOOOOOOOOOOO          " + "              OOOOOOOOOOOOOOOOOOO          " + "              OOOOOOOOOOOOOOOOOOO          \n" +
"                 OOOOOOOOOOOOO             " + "                 OOOOOOOOOOOOO             " + "                 OOOOOOOOOOOOO             \n\n" +
"                  Bulbasaur                " + "                   Squirtle                " + "                  Charmander               ";
	}
	
	public String learnableMoves(Pokemon s) {
		String toReturn = "Available moves:\n";
		for(PokeMove m: s.getLearnable()) {
			toReturn += m.toString() + "\n";
		}
		return toReturn;
	}
}
