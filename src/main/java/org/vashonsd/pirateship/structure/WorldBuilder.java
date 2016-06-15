package org.vashonsd.pirateship.structure;

import java.io.IOException;
import org.vashonsd.pirateship.creature.CreatureFactory;
import org.vashonsd.pirateship.interactions.*;
import org.vashonsd.pirateship.minigame.*;

/**
 * @author andy 
 * This class creates an entire structure of connected locations and routes. It can do so
 * interactively, or it can load a preset from a file or database.
 * 
 * Eventually the WorldBuilder should allow a user to build a world which can be saved to a database.
 */

public class WorldBuilder {
	
	
	/*
	 * Consider this a very simple example of a Factory method; it makes a World based on a given String.
	 */
	public static World makeWorld(String s)
	{
		if (s.equals("Poke"))
		{
			return PokemonWorld();
		}
		else
		{
			return null;
		}
	}
	
	public static World PokemonWorld()
	{
		World w = new World("Kanto");
		Location courtyard = new Location("Courtyard", "Not much to do here", "A wide empty courtyard");
		Location lab = new Location("Pokemon Lab", "Professor Oak works here", "You stand amidst big shiny machines");
		Location arena = new Location("Pokemon Arena", "Battle!!!", "Fight your way to the top");
		Location pokemonCenter = new Location("Pokemon Center", "Heal your pokemon", "A nice cozy mix of hospital and cafe");
		Location shop = new Location("Shop", "Buy stuff", "Potions line the walls");
		
		courtyard.addRoute("Sliding glass doors lead to the Pokemon Lab", "lab", "Choose your Pokemon here", lab);
		courtyard.addRoute("A large collisium lies ahead", "arena", "Battle for the Pokemon championship", arena);
		courtyard.addRoute("A sign reads \"Pokemon Center\"", "center", "Heal your pokemon", pokemonCenter);
		courtyard.addRoute("A glass display holds what seem to be medicinal arrosals", "shop", "Buy potions", shop);
		
		lab.addRoute("Return to the courtyard", "back", "Get outta here", courtyard);
		arena.addRoute("Return to the courtyard", "back", "Get outta here", courtyard);
		pokemonCenter.addRoute("Return to the courtyard", "back", "Get outta here", courtyard);
		shop.addRoute("Return to the courtyard", "back", "Get outta here", courtyard);
		
		w.addLocation(courtyard);
		w.addLocation(lab);
		w.addLocation(arena);
		w.addLocation(pokemonCenter);
		w.addLocation(shop);
		
		lab.addToInventory(new ChoosePokemon());
		pokemonCenter.addToInventory(new PokemonCenter());
		arena.addToInventory(new PokemonBattle());
		shop.addToInventory(new Shop());
		shop.addToInventory(new GoldCoin());
		
		w.setStartingLocation(courtyard);
		
		return w;
	}
	
}
