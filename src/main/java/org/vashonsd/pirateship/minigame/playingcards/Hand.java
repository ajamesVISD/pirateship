package org.vashonsd.pirateship.minigame.playingcards;

import java.util.*;

public class Hand 
{

    private static final int HEARTS = 0;
    private static final int DIAMONDS = 1;
    private static final int SPADES = 2;
    private static final int CLUBS = 3;

    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 14;

    // This represents the list of cards in the hand.
    private ArrayList<Card> cards;
    private ArrayList<Card> pairs;
    
    /**
     * This constructor sets up our hand by initializing our
     * ArrayList.
     */
    public Hand()
    {
        cards = new ArrayList<Card>();
        pairs = new ArrayList<Card>();
    }
    
    /**
     * This adds a card to our hand.
     * 
     * @param c The card to add to the hand.
     */
    public void addCard(Card c)
    {
        cards.add(c);
    }
    
    public void addPair(Card c)
    {
    	pairs.add(c);
    }
    
    public ArrayList<Card> getPairs()
    {
    	return pairs;
    }
    
    public ArrayList<Card> getList()
    {
    	return cards;
    }
    
    public int getSize()
    {
    	return cards.size();
    }
    
    
    /**
     * This returns the value of the hand as an integer.
     * 
     * The value of the hand is the sum of the values
     * of the individual cards. There is also an adjustment
     * made for the value of an ace, which can be 11 or 1
     * depending on the situation.
     * 
     * @return The value of the hand.
     */
    public int getValue()
    {
        int sum = 0;
        int aceCount = 0;
        
        for(Card c: cards)
        {
            sum += c.getValue();
            
            if(c.getRank() == ACE)
            {
                aceCount++;
            }
        }
        
        while(sum > 21 && aceCount > 0)
        {
            sum -= 10;
            aceCount--;
        }
        
        return sum;
    }
    
    /**
     * Return if this hand has a blackjack.
     * 
     * @return If the hand is a blackjack.
     */
    public boolean hasBlackjack()
    {
        return getValue() == 21 && cards.size() == 2;
    }
    
    /**
     * Return if the hand busted, which means has a value
     * greater than 21.
     * 
     * @return If the hand busted.
     */
    public boolean busted()
    {
        return getValue() > 21;
    }
    
    /**
     * Return if the hand is a five-card-charlie, which means
     * contained five cards.
     * 
     * @return If the hand was a five-card charlie.
     */
    public boolean fiveCardCharlie()
    {
        return cards.size() == 5;
    }
    
    public int getCard(int n)
    {
        return (cards.get(n)).getValue();
    }
    
    /**
     * Print out a dealer hand, and show an X instead of
     * the first card.
     */
    public void printDealerHand()
    {
        for(int i = 0; i < cards.size(); i++)
        {
            Card c = cards.get(i);
            
            if(i == 0)
            {
                System.out.print("X ");
            }
            else
            {
                System.out.print(c + " ");
            }
        }
        System.out.println();
    }
    
    
    /**
     * Return a String representation of the hand, including showing
     * the value.
     */
    public String blackjackToString()
    {
        String result = "";
        
        for(Card c: cards)
        {
            result += c + " ";
        }
        
        result += "(" + getValue() + ")";
        
        return result;
    }
    
    public String toString()
    {
    	 String result = "";
         
         for(Card c: cards)
         {
             result += c + " ";
         }
         
         return result;
    }
    
    public String gofishToString()
    {
    	String result = "";
        
        for(Card c: cards)
        {
            result += c.getRankName() + " ";
        }
        
        return result;
    }
    
    public Card cardAt(int n)
    {
        return cards.get(n);
    }
    
    public void removeCard(Card c)
    {
    	Card cur;
    	
		for(int i=0; i<cards.size(); i++)
		{
			cur = cardAt(i);
			
			if(c.getRank() == cur.getRank() && c.getSuit() == cur.getSuit())
				cards.remove(i);
		}
    }
    
    public void removeCardByRank(Card c)
    {
    	Card cur;
    	
    	for(int i=0; i<cards.size(); i++)
		{
			cur = cardAt(i);
			
			if(c.getRank() == cur.getRank())
			{
				cards.remove(i);
				break;
			}
		}
    }
    
    public void removePair(int n)
    {
    	int pair = 0;
    	ArrayList<Card> toRemove = new ArrayList<Card>();
    	
    	for(Card cur: cards)
		{
    		int k = cur.getRank();
    		
			if(k == n)
			{
				toRemove.add(cur);
				addPair(cur);
				pair++;
			}
			
			if(pair >= 2)
				break;
		}
    	
    	if(pair >= 2)
    	{
	    	for(Card c: toRemove)
	    	{
	    		cards.remove(c);
	    	}
    	}
    }
    
    public boolean isEmpty()
    {
    	if(cards.size() == 0)
    		return true;
    	
    	return false;
    }
    
    public boolean hasCard(Card c)
    {
    	for(Card cur: cards)
    	{
    		if(c.getRank() == cur.getRank())
    			return true;
    	}
    	
    	return false;
    }
    
    public String rankToString()
    {
    	String toReturn = "";
    	
    	for(Card c: cards)
    	{
    		toReturn += c.rankToString();
    		toReturn += " ";
    	}
    	
    	return toReturn;
    }
}
