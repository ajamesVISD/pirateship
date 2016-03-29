package org.vashonsd.pirateship;

import java.io.*;

import org.vashonsd.pirateship.structure.*;
import org.vashonsd.pirateship.io.*;

/**
 * We keep the App very sparse. It's just the trigger.
 *
 */
public class App 
{	
    public static void main( String[] args ) throws IOException
    {
    	Game g = new Game("Busytown");
    	g.Run();
    }   
}