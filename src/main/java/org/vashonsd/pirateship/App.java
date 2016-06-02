package org.vashonsd.pirateship;

import java.io.IOException;

/**
 * We keep the App very sparse. It's just the trigger.
 *
 */
public class App 
{	
    public static void main( String[] args ) throws IOException
    {
    	Game g = new Game("Poke");
    	g.Run();
    }   
}
