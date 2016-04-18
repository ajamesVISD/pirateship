package org.vashonsd.pirateship.minigame.playingcards;

import java.util.*;

public class Deck
{
    private static final int HEARTS = 0;
    private static final int DIAMONDS = 1;
    private static final int SPADES = 2;
    private static final int CLUBS = 3;

    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 14;
    
    // Instance variables
    
    // This stores the deck which is a list of the Card objects.
    private ArrayList<Card> deck;
    
    /**
     * This creates a Deck. A Deck starts as a list of 52 cards.
     * We loop through each suit and rank and construct a card
     * and add it to the deck.
     */
    public Deck()
    {
        deck = new ArrayList<Card>();
        
        for(int rank = 2; rank <= ACE; rank++)
        {
            for(int suit = HEARTS; suit <= CLUBS; suit++)
            {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
    }
    
    // Getter method
    
    /**
     * This getter method returns the ArrayList of cards.
     * @return ArrayList<Card> of the Cards.
     */
    public ArrayList<Card> getCards()
    {
        return deck;
    }
    
    /**
     * This deals the first Card from the deck by removing it.
     * @return The first Card in the deck.
     */
    public Card deal()
    {
    	Card cur = deck.get(0);
    	deck.remove(0);
        return cur;
    }
    
    /**
     * This prints out the current state of the deck.
     */
    public void print()
    {
        for(Card card: deck)
        {
            System.out.println(card);
        }
    }
    
    /**
     * This shuffles the deck by making 52 swaps of
     * card positions.
     */
    public void shuffle()
    {
        for(int i = 0; i < deck.size(); i++)
        {
            int randomIndex = Randomizer.nextInt(52);
            Card x = deck.get(i);
            Card y = deck.get(randomIndex);
            
            deck.set(i, y);
            deck.set(randomIndex, x);
        }
    }

}