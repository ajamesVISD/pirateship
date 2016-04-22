package org.vashonsd.pirateship;

import java.io.IOException;

import org.vashonsd.pirateship.structure.Lobby;

/**
 * We keep the App sparse. It's just the trigger.
 *
 */
public class App 
{	
    public static void main( String[] args ) throws IOException
    {
    	Lobby l = new Lobby();
    	l.modeSelect();
    }   
}
